package network.ike.foundation.ike.doc.extension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.index.HierarchyIndex;
import network.ike.foundation.ike.hierarchy.index.IndexCodec;
import network.ike.foundation.ike.hierarchy.index.IndexedChapter;
import network.ike.foundation.ike.hierarchy.index.IndexedRoot;
import network.ike.foundation.ike.hierarchy.index.JsonException;
import network.ike.foundation.ike.hierarchy.scan.SafePath;

/**
 * The index, loaded once per document and re-anchored beneath a base directory this build supplied.
 *
 * <p>The re-anchoring is the point. The index records every path relative to a root, and every root
 * relative to the project base — it contains no absolute path and no way to express one. The base
 * comes from Maven, not from the index. So even an index that is stale, hand-edited, or copied from
 * another machine can only ever name files inside this project, and every path it names is checked
 * again here before anything is read.
 *
 * <p>Loading is done once and cached, because an include processor is invoked for every directive
 * in the document and re-reading the index each time would make a large guide quadratic for no
 * reason.
 */
final class ResolvedIndex {

    private final HierarchyIndex index;
    private final Map<String, Path> rootDirectories;

    private ResolvedIndex(HierarchyIndex index, Map<String, Path> rootDirectories) {
        this.index = index;
        this.rootDirectories = rootDirectories;
    }

    /**
     * Loads an index and resolves its roots beneath a base directory.
     *
     * @param indexFile the index to read
     * @param baseDir   the project base every root is resolved beneath
     * @return the loaded index, or a failure describing why it could not be used
     */
    static Loaded load(Path indexFile, Path baseDir) {
        Optional<Path> realBase = SafePath.realDirectory(baseDir);
        if (realBase.isEmpty()) {
            return new Loaded(Optional.empty(),
                    "the base directory '" + baseDir + "' does not exist or is not a directory");
        }
        Optional<Path> realIndex = SafePath.contain(realBase.get(), indexFile);
        if (realIndex.isEmpty()) {
            return new Loaded(Optional.empty(),
                    "the index '" + indexFile + "' was not found inside the project. "
                            + "Run 'mvn ike-hierarchy:index' first");
        }

        HierarchyIndex parsed;
        try {
            parsed = IndexCodec.read(Files.readString(realIndex.get(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            return new Loaded(Optional.empty(), "the index could not be read: " + e.getMessage());
        } catch (JsonException e) {
            return new Loaded(Optional.empty(), e.getMessage());
        }

        Map<String, Path> directories = new LinkedHashMap<>();
        for (IndexedRoot root : parsed.roots()) {
            Path candidate = root.path().equals(".")
                    ? realBase.get()
                    : realBase.get().resolve(root.path());
            Optional<Path> contained = SafePath.contain(realBase.get(), candidate);
            if (contained.isEmpty()) {
                return new Loaded(Optional.empty(),
                        "scan root '" + root.id() + "' resolves outside the project");
            }
            directories.put(root.id(), contained.get());
        }
        return new Loaded(Optional.of(new ResolvedIndex(parsed, directories)), null);
    }

    /**
     * Returns the underlying index.
     *
     * @return the parsed index
     */
    HierarchyIndex index() {
        return index;
    }

    /**
     * Resolves an indexed chapter to a real file, re-checking containment.
     *
     * <p>Checked here as well as at scan time because the two happen in different processes at
     * different moments: a file can be replaced by a symbolic link between the build that wrote the
     * index and the render that reads it.
     *
     * @param chapter the indexed chapter
     * @return the chapter's file, or empty when its root is unknown or the file escapes it
     */
    Optional<Path> fileOf(IndexedChapter chapter) {
        Path rootDirectory = rootDirectories.get(chapter.rootId());
        if (rootDirectory == null) {
            return Optional.empty();
        }
        Path candidate = rootDirectory;
        for (String segment : chapter.path().split("/")) {
            candidate = candidate.resolve(segment);
        }
        return SafePath.contain(rootDirectory, candidate)
                .filter(Files::isRegularFile);
    }

    /**
     * The outcome of loading an index.
     *
     * @param resolved the loaded index, or empty on failure
     * @param problem  why loading failed, or null on success
     */
    record Loaded(Optional<ResolvedIndex> resolved, String problem) {
    }
}
