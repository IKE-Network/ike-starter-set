package network.ike.foundation.ike.hierarchy.author;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.HeaderAttribute;

/**
 * Writes a chapter's hierarchy declaration into the top of an existing AsciiDoc file, in place.
 *
 * <p>This is what "one command" comes down to. Registering a draft is not a matter of moving it,
 * splitting it, copying it into a conventional directory, or adding a line to a central document —
 * it is adding a handful of attribute entries to the file where it already sits. The file stays
 * where its author put it; only its self-description changes.
 *
 * <p>Stamping is idempotent by construction. Rather than patching individual lines, it removes
 * every existing hierarchy attribute from the header and reinserts the complete set in a canonical
 * order at the position the first one occupied. Running it twice with the same request therefore
 * produces a file identical to running it once, and running it with a different placement produces
 * exactly the lines that placement implies — no accumulation of stale attributes, no drift in
 * ordering that would show up as noise in a diff.
 *
 * <p>Operating on lines rather than a path keeps this testable without a filesystem and keeps the
 * containment checks in one place, in the goal that calls it.
 */
public final class HeaderStamper {

    private static final Pattern ATTRIBUTE_ENTRY =
            Pattern.compile("^:([A-Za-z0-9_][A-Za-z0-9_.-]*)!?:(?:[ \\t]+(.*?))?[ \\t]*$");
    private static final Pattern HEADING =
            Pattern.compile("^(={1,6})[ \\t]+(\\S.*?)[ \\t]*$");
    private static final Pattern BLOCK_DELIMITER =
            Pattern.compile("^(////|----|\\.\\.\\.\\.|\\+\\+\\+\\+|____|====|\\*\\*\\*\\*)[ \\t]*$");

    /**
     * The order hierarchy attributes are written in. Fixed so that the block reads the same way in
     * every chapter and so that stamping is a stable, diffable operation.
     */
    private static final List<HeaderAttribute> WRITE_ORDER = List.of(
            HeaderAttribute.CHAPTER_ID,
            HeaderAttribute.CHAPTER_TITLE,
            HeaderAttribute.CHAPTER_PARENT,
            HeaderAttribute.CHAPTER_ORDER,
            HeaderAttribute.CHAPTER_STATUS,
            HeaderAttribute.CHAPTER_ROOT);

    private HeaderStamper() {
    }

    /**
     * Stamps a declaration into a file's lines.
     *
     * @param lines   the file's current lines, in order
     * @param desired the declaration the file should carry afterwards
     * @return the resulting lines, whether anything changed, and what changed
     * @throws IllegalArgumentException if either argument is null
     */
    public static StampOutcome stamp(List<String> lines, ChapterHeader desired) {
        if (lines == null || desired == null) {
            throw new IllegalArgumentException("Lines and a desired header are both required");
        }
        int headerEnd = headerRegionEnd(lines);
        Map<HeaderAttribute, String> existing = new EnumMap<>(HeaderAttribute.class);

        List<String> result = new ArrayList<>(lines.size() + WRITE_ORDER.size() + 1);
        int insertAt = -1;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i < headerEnd) {
                Optional<HeaderAttribute> attribute = hierarchyAttribute(line, existing);
                if (attribute.isPresent()) {
                    if (insertAt < 0) {
                        insertAt = result.size();
                    }
                    continue;
                }
            }
            result.add(line);
        }
        if (insertAt < 0) {
            insertAt = 0;
        }

        List<String> block = renderBlock(desired);
        result.addAll(insertAt, block);

        int afterBlock = insertAt + block.size();
        if (afterBlock < result.size() && !result.get(afterBlock).isBlank()) {
            result.add(afterBlock, "");
        }

        List<String> notes = describeChanges(existing, desired);
        boolean changed = !result.equals(lines);
        return new StampOutcome(result, changed, notes);
    }

    /**
     * Finds where the document header stops and the body begins.
     *
     * <p>Deliberately conservative: it stops at the first block delimiter, the second heading, or
     * any line that is neither blank, a comment, an attribute entry, nor the doctitle. Attributes
     * are only ever recognised — and only ever written — above that point, so a line inside a
     * listing block that happens to look like an attribute entry is never touched.
     */
    private static int headerRegionEnd(List<String> lines) {
        boolean headingSeen = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (BLOCK_DELIMITER.matcher(line).matches()) {
                return i;
            }
            if (line.isBlank() || line.startsWith("//")) {
                continue;
            }
            if (HEADING.matcher(line).matches()) {
                if (headingSeen) {
                    return i;
                }
                headingSeen = true;
                continue;
            }
            if (ATTRIBUTE_ENTRY.matcher(line).matches()) {
                continue;
            }
            return i;
        }
        return lines.size();
    }

    /**
     * Recognises a hierarchy attribute entry and records its current value.
     */
    private static Optional<HeaderAttribute> hierarchyAttribute(
            String line, Map<HeaderAttribute, String> existing) {

        Matcher matcher = ATTRIBUTE_ENTRY.matcher(line);
        if (!matcher.matches()) {
            return Optional.empty();
        }
        Optional<HeaderAttribute> attribute = HeaderAttribute.fromAttributeName(matcher.group(1));
        attribute.ifPresent(known ->
                existing.put(known, matcher.group(2) == null ? "" : matcher.group(2).trim()));
        return attribute;
    }

    /**
     * Renders the canonical attribute block for a declaration.
     *
     * <p>A root carries no parent or order, and a placed chapter carries no root marker, so the
     * block written is exactly the set of attributes that placement needs and nothing more.
     */
    private static List<String> renderBlock(ChapterHeader desired) {
        List<String> block = new ArrayList<>();
        for (HeaderAttribute attribute : WRITE_ORDER) {
            switch (attribute) {
                case CHAPTER_ID -> block.add(attribute.entry(desired.id().value()));
                case CHAPTER_TITLE -> desired.title().ifPresent(title -> block.add(attribute.entry(title)));
                case CHAPTER_PARENT -> desired.parent()
                        .ifPresent(parent -> block.add(attribute.entry(parent.value())));
                case CHAPTER_ORDER -> {
                    if (!desired.root()) {
                        block.add(attribute.entry(Integer.toString(desired.order())));
                    }
                }
                case CHAPTER_STATUS -> block.add(attribute.entry(desired.status().token()));
                case CHAPTER_ROOT -> {
                    if (desired.root()) {
                        block.add(attribute.entry(null));
                    }
                }
            }
        }
        return block;
    }

    /**
     * Explains the difference between what the file declared and what it now declares.
     */
    private static List<String> describeChanges(
            Map<HeaderAttribute, String> existing, ChapterHeader desired) {

        List<String> notes = new ArrayList<>();
        Map<HeaderAttribute, String> wanted = new EnumMap<>(HeaderAttribute.class);
        for (String line : renderBlock(desired)) {
            Matcher matcher = ATTRIBUTE_ENTRY.matcher(line);
            if (matcher.matches()) {
                HeaderAttribute.fromAttributeName(matcher.group(1)).ifPresent(attribute ->
                        wanted.put(attribute, matcher.group(2) == null ? "" : matcher.group(2).trim()));
            }
        }
        for (HeaderAttribute attribute : WRITE_ORDER) {
            String before = existing.get(attribute);
            String after = wanted.get(attribute);
            if (before == null && after != null) {
                notes.add("set :" + attribute.attributeName() + ": " + display(after));
            } else if (before != null && after == null) {
                notes.add("removed :" + attribute.attributeName() + ":");
            } else if (before != null && !before.equals(after)) {
                notes.add("changed :" + attribute.attributeName() + ": from "
                        + display(before) + " to " + display(after));
            }
        }
        return notes;
    }

    private static String display(String value) {
        return value.isEmpty() ? "(set)" : value;
    }
}
