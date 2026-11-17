package network.ike.foundation.ike.doc.extension;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.IncludeProcessor;
import org.asciidoctor.extension.PreprocessorReader;

import network.ike.foundation.ike.hierarchy.index.IndexedChapter;
import network.ike.foundation.ike.hierarchy.model.ChapterId;

/**
 * Resolves {@code hierarchy:} and {@code chapter:} include targets from the generated index.
 *
 * <pre>
 * include::hierarchy:ike-guide[]   // every chapter placed beneath the ike-guide root, in order
 * include::chapter:cql[]           // one named chapter, wherever in the project it lives
 * </pre>
 *
 * <p>What this processor does <em>not</em> do is most of what it replaces. It walks no directories,
 * reads no manifests, and resolves no path it was not handed by the index. Discovery happened once,
 * in the Maven goal, and the answer was validated and written down; rendering just reads it. Two
 * builds of the same tree therefore produce the same document, and a chapter cannot appear or
 * vanish depending on what happens to be on disk at render time.
 *
 * <p>It also has no fallback. The processor it supersedes, on failing to resolve a target, tried
 * the path against the filesystem root and read whatever it found — which made
 * {@code include::chapter:../../../../etc/passwd[]} resolve. Here an unknown identifier produces a
 * warning in the output and nothing else.
 *
 * <p>Heading depth is not guessed. Each chapter's depth was computed when the hierarchy was
 * validated, so a chapter emits {@code leveloffset=+depth} and lands at exactly the level its
 * place in the tree implies — a chapter of the book at {@code ==}, a section within it at
 * {@code ===} — regardless of which file the directive was written in.
 */
public class HierarchyIncludeProcessor extends IncludeProcessor {

    /** Include prefix requesting everything beneath an identifier. */
    public static final String HIERARCHY_PREFIX = "hierarchy:";

    /** Include prefix requesting one named chapter. */
    public static final String CHAPTER_PREFIX = "chapter:";

    /** Document attribute naming the generated index file. */
    public static final String INDEX_ATTRIBUTE = "ike-hierarchy-index";

    /** Document attribute naming the project base directory every path is resolved beneath. */
    public static final String BASE_ATTRIBUTE = "ike-hierarchy-base";

    private ResolvedIndex resolved;
    private String loadProblem;
    private boolean loadAttempted;

    /** Creates a processor with no configuration. */
    public HierarchyIncludeProcessor() {
        super();
    }

    /**
     * Creates a processor with Asciidoctor-supplied configuration.
     *
     * @param config the extension configuration
     */
    public HierarchyIncludeProcessor(Map<String, Object> config) {
        super(config);
    }

    @Override
    public boolean handles(String target) {
        return target != null
                && (target.startsWith(HIERARCHY_PREFIX) || target.startsWith(CHAPTER_PREFIX));
    }

    @Override
    public void process(Document document, PreprocessorReader reader, String target,
                        Map<String, Object> attributes) {

        boolean subtree = target.startsWith(HIERARCHY_PREFIX);
        String rawId = target.substring(
                (subtree ? HIERARCHY_PREFIX : CHAPTER_PREFIX).length()).trim();

        StringBuilder output = new StringBuilder();

        Optional<ResolvedIndex> index = index(document);
        if (index.isEmpty()) {
            push(reader, warning("cannot resolve '" + target + "': " + loadProblem), attributes);
            return;
        }
        Optional<ChapterId> id = ChapterId.parse(rawId);
        if (id.isEmpty()) {
            push(reader, warning("'" + rawId + "' is not a valid chapter id"), attributes);
            return;
        }

        int extraOffset = requestedOffset(attributes);
        List<IndexedChapter> selected = select(index.get(), id.get(), subtree);

        if (selected.isEmpty()) {
            push(reader, warning(subtree
                    ? "no chapters are placed beneath '" + id.get() + "'"
                    : "no chapter with id '" + id.get() + "' is in the index"), attributes);
            return;
        }

        for (IndexedChapter chapter : selected) {
            Optional<Path> file = index.get().fileOf(chapter);
            if (file.isEmpty()) {
                output.append(warning("chapter '" + chapter.id()
                        + "' is in the index but its file could not be read at "
                        + chapter.rootId() + "/" + chapter.path()));
                continue;
            }
            int offset = Math.max(0, chapter.depth() + extraOffset);
            output.append("include::")
                    .append(file.get().toString().replace('\\', '/'))
                    .append("[leveloffset=+").append(offset).append("]\n\n");
        }
        push(reader, output.toString(), attributes);
    }

    /**
     * Chooses the entries a target refers to.
     *
     * <p>A {@code hierarchy:} target yields the subtree beneath the identifier and not the
     * identifier itself, because the identifier is the document the directive was written in. A
     * {@code chapter:} target yields exactly one entry.
     */
    private static List<IndexedChapter> select(ResolvedIndex index, ChapterId id, boolean subtree) {
        if (subtree) {
            return index.index().descendantsOf(id);
        }
        List<IndexedChapter> single = new ArrayList<>();
        index.index().chapter(id).ifPresent(single::add);
        return single;
    }

    /**
     * Reads an optional {@code leveloffset} from the directive, so a whole subtree can be shifted.
     *
     * <p>Additive rather than absolute: the depth computed at validation time stays authoritative,
     * and this only moves the whole subtree relative to wherever it is being pulled in.
     */
    private static int requestedOffset(Map<String, Object> attributes) {
        if (attributes == null) {
            return 0;
        }
        Object raw = attributes.get("leveloffset");
        if (raw == null) {
            return 0;
        }
        String text = String.valueOf(raw).trim();
        if (text.startsWith("+")) {
            text = text.substring(1);
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Loads the index on first use and caches the outcome, success or failure.
     */
    private Optional<ResolvedIndex> index(Document document) {
        if (loadAttempted) {
            return Optional.ofNullable(resolved);
        }
        loadAttempted = true;

        String indexPath = attribute(document, INDEX_ATTRIBUTE);
        String basePath = attribute(document, BASE_ATTRIBUTE);

        if (indexPath == null || basePath == null) {
            loadProblem = "the '" + INDEX_ATTRIBUTE + "' and '" + BASE_ATTRIBUTE
                    + "' document attributes are not set. Configure them in the asciidoctor-maven-plugin"
                    + " and bind ike-hierarchy:index ahead of rendering";
            return Optional.empty();
        }
        ResolvedIndex.Loaded loaded = ResolvedIndex.load(Path.of(indexPath), Path.of(basePath));
        loaded.resolved().ifPresent(value -> this.resolved = value);
        this.loadProblem = loaded.problem();
        return loaded.resolved();
    }

    private static String attribute(Document document, String name) {
        Object value = document.getAttribute(name);
        if (value == null) {
            return null;
        }
        String text = String.valueOf(value).trim();
        return text.isEmpty() ? null : text;
    }

    /**
     * Renders a problem as both an AsciiDoc comment and a visible warning admonition.
     *
     * <p>Visible on purpose. A missing chapter that only produces a comment is invisible in the
     * rendered book, and the whole reason the build fails on a broken hierarchy is that silently
     * absent content is the failure mode worth engineering against.
     */
    private static String warning(String detail) {
        return "// [ike-hierarchy] " + detail + "\n"
                + "WARNING: ike-hierarchy: " + detail + "\n\n";
    }

    private static void push(PreprocessorReader reader, String content,
                             Map<String, Object> attributes) {
        Map<String, Object> cleanAttributes = new HashMap<>(attributes != null ? attributes : Map.of());
        cleanAttributes.remove("leveloffset");
        reader.push_include(content, null, null, 1, cleanAttributes);
    }
}
