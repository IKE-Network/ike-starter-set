package network.ike.foundation.ike.hierarchy.index;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;

/**
 * Converts a {@link HierarchyIndex} to and from its JSON representation.
 *
 * <p>Kept separate from the index record so that the on-disk format can change without the model
 * changing, and so that both directions are exercised by one round-trip test: an index written and
 * read back must be equal to the one written. That test is the reason the reading side can afford
 * to be strict — nothing else produces this file.
 */
public final class IndexCodec {

    private static final String SCHEMA = "schema";
    private static final String MAX_DEPTH = "maxDepth";
    private static final String ROOTS = "roots";
    private static final String CHAPTERS = "chapters";
    private static final String ID = "id";
    private static final String PATH = "path";
    private static final String TITLE = "title";
    private static final String PARENT = "parent";
    private static final String ORDER = "order";
    private static final String STATUS = "status";
    private static final String ROOT = "root";
    private static final String DEPTH = "depth";
    private static final String ROOT_ID = "rootId";

    private IndexCodec() {
    }

    /**
     * Renders an index as indented JSON text with a trailing newline.
     *
     * @param index the index to render
     * @return the JSON document
     * @throws IllegalArgumentException if the index is null
     */
    public static String write(HierarchyIndex index) {
        if (index == null) {
            throw new IllegalArgumentException("An index is required");
        }
        Map<String, Json> document = new LinkedHashMap<>();
        document.put(SCHEMA, new Json.Str(index.schema()));
        document.put(MAX_DEPTH, Json.Num.of(index.maxDepth()));

        List<Json> roots = new ArrayList<>();
        for (IndexedRoot root : index.roots()) {
            Map<String, Json> member = new LinkedHashMap<>();
            member.put(ID, new Json.Str(root.id()));
            member.put(PATH, new Json.Str(root.path()));
            roots.add(new Json.Obj(member));
        }
        document.put(ROOTS, new Json.Arr(roots));

        List<Json> chapters = new ArrayList<>();
        for (IndexedChapter chapter : index.chapters()) {
            Map<String, Json> member = new LinkedHashMap<>();
            member.put(ID, new Json.Str(chapter.id().value()));
            member.put(TITLE, new Json.Str(chapter.title()));
            member.put(PARENT, chapter.parent()
                    .<Json>map(parent -> new Json.Str(parent.value()))
                    .orElseGet(Json.Nul::new));
            member.put(ORDER, Json.Num.of(chapter.order()));
            member.put(STATUS, new Json.Str(chapter.status().token()));
            member.put(ROOT, new Json.Bool(chapter.root()));
            member.put(DEPTH, Json.Num.of(chapter.depth()));
            member.put(ROOT_ID, new Json.Str(chapter.rootId()));
            member.put(PATH, new Json.Str(chapter.path()));
            chapters.add(new Json.Obj(member));
        }
        document.put(CHAPTERS, new Json.Arr(chapters));

        return new Json.Obj(document).render();
    }

    /**
     * Parses an index from JSON text under the default parse limits.
     *
     * @param text the JSON document
     * @return the parsed index
     * @throws JsonException if the document is malformed or does not match the index schema
     */
    public static HierarchyIndex read(String text) {
        return read(text, JsonLimits.defaults());
    }

    /**
     * Parses an index from JSON text.
     *
     * @param text   the JSON document
     * @param limits the parse bounds to respect
     * @return the parsed index
     * @throws JsonException if the document is malformed or does not match the index schema
     */
    public static HierarchyIndex read(String text, JsonLimits limits) {
        Json.Obj document = Json.Obj.require(Json.parse(text, limits));

        String schema = document.requireString(SCHEMA);
        if (!HierarchyIndex.SCHEMA.equals(schema)) {
            throw new JsonException("Index declares schema '" + schema + "' but this build reads "
                    + HierarchyIndex.SCHEMA + ". Re-run ike-hierarchy:index.");
        }
        int maxDepth = document.requireInt(MAX_DEPTH);

        List<IndexedRoot> roots = new ArrayList<>();
        for (Json element : document.requireArray(ROOTS)) {
            Json.Obj root = Json.Obj.require(element);
            String rootId = root.requireString(ID);
            try {
                roots.add(new IndexedRoot(rootId, root.requireString(PATH)));
            } catch (IllegalArgumentException e) {
                // IndexedRoot rejects absolute paths and '..' segments. Reaching here means the
                // index on disk is not one this build wrote, so it is reported the same way as any
                // other malformed document: every failure to read an index must arrive at the
                // caller as a JsonException, because that is the only thing the Asciidoctor
                // extension catches. An IllegalArgumentException escaping here would surface as an
                // unhandled exception out of the include processor instead of a legible warning.
                throw new JsonException(
                        "Index entry for root '" + rootId + "' is invalid: " + e.getMessage(), e);
            }
        }

        List<IndexedChapter> chapters = new ArrayList<>();
        for (Json element : document.requireArray(CHAPTERS)) {
            Json.Obj entry = Json.Obj.require(element);
            chapters.add(readChapter(entry));
        }

        try {
            return new HierarchyIndex(schema, maxDepth, roots, chapters);
        } catch (IllegalArgumentException e) {
            throw new JsonException("Index is structurally invalid: " + e.getMessage(), e);
        }
    }

    private static IndexedChapter readChapter(Json.Obj entry) {
        String rawId = entry.requireString(ID);
        ChapterId id = ChapterId.parse(rawId).orElseThrow(
                () -> new JsonException("Index contains an invalid chapter id '" + rawId + "'"));

        Optional<ChapterId> parent = entry.optionalString(PARENT).flatMap(ChapterId::parse);

        String rawStatus = entry.requireString(STATUS);
        ChapterStatus status = ChapterStatus.parse(rawStatus).orElseThrow(
                () -> new JsonException("Index contains an invalid status '" + rawStatus
                        + "' for chapter '" + rawId + "'"));

        try {
            return new IndexedChapter(
                    id,
                    entry.requireString(TITLE),
                    parent,
                    entry.requireInt(ORDER),
                    status,
                    entry.booleanOr(ROOT, false),
                    entry.requireInt(DEPTH),
                    entry.requireString(ROOT_ID),
                    entry.requireString(PATH));
        } catch (IllegalArgumentException e) {
            throw new JsonException(
                    "Index entry for chapter '" + rawId + "' is invalid: " + e.getMessage(), e);
        }
    }
}
