package network.ike.foundation.ike.hierarchy.scan;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;
import network.ike.foundation.ike.hierarchy.model.HeaderAttribute;

/**
 * Reads a chapter's hierarchy declaration from the top of an AsciiDoc file.
 *
 * <p>Only the document header is examined — the attribute entries and optional title that precede
 * the body. The parser stops at the first line that is unmistakably content, and in no case reads
 * past {@link ScanLimits#maxHeaderLines}. A scan visits every AsciiDoc file beneath its roots, so
 * the cost of deciding "is this a chapter?" is paid on every file in the project; reading a few
 * dozen lines instead of whole documents is what keeps that affordable, and refusing to read
 * further is what keeps a pathological file from becoming a build hazard.
 *
 * <p>Operating on a list of lines rather than a path is deliberate: it keeps every parsing rule
 * testable without a filesystem, and leaves all I/O in {@link ChapterScanner} where the
 * containment checks are.
 */
public final class HeaderParser {

    private static final Pattern ATTRIBUTE_ENTRY =
            Pattern.compile("^:([A-Za-z0-9_][A-Za-z0-9_.-]*)!?:(?:[ \\t]+(.*?))?[ \\t]*$");
    private static final Pattern HEADING =
            Pattern.compile("^(={1,6})[ \\t]+(\\S.*?)[ \\t]*$");
    private static final Pattern BLOCK_DELIMITER =
            Pattern.compile("^(////|----|\\.\\.\\.\\.|\\+\\+\\+\\+|____|====|\\*\\*\\*\\*)[ \\t]*$");

    private HeaderParser() {
    }

    /**
     * Parses the hierarchy declaration from a file's leading lines.
     *
     * @param lines  the file's lines, in order; only the leading portion is examined
     * @param limits the bounds to respect while reading
     * @return whether this file is a chapter, and if so its declaration or the reason it is unusable
     * @throws IllegalArgumentException if either argument is null
     */
    public static HeaderParseResult parse(List<String> lines, ScanLimits limits) {
        if (lines == null || limits == null) {
            throw new IllegalArgumentException("Lines and limits are both required");
        }
        Map<HeaderAttribute, String> attributes = new EnumMap<>(HeaderAttribute.class);
        String firstHeading = null;
        boolean headingSeen = false;

        int examined = Math.min(lines.size(), limits.maxHeaderLines());
        for (int i = 0; i < examined; i++) {
            String line = stripByteOrderMark(lines.get(i), i);

            if (line.isBlank()) {
                continue;
            }
            if (BLOCK_DELIMITER.matcher(line).matches()) {
                break;
            }
            if (line.startsWith("//")) {
                continue;
            }
            Matcher heading = HEADING.matcher(line);
            if (heading.matches()) {
                if (headingSeen) {
                    break;
                }
                headingSeen = true;
                firstHeading = heading.group(2);
                continue;
            }
            Matcher attribute = ATTRIBUTE_ENTRY.matcher(line);
            if (attribute.matches()) {
                Optional<HeaderAttribute> known = HeaderAttribute.fromAttributeName(attribute.group(1));
                if (known.isPresent()) {
                    String value = attribute.group(2) == null ? "" : attribute.group(2).trim();
                    if (value.length() > limits.maxValueLength()) {
                        return new HeaderParseResult.Malformed(
                                "attribute ':" + known.get().attributeName() + ":' exceeds "
                                        + limits.maxValueLength() + " characters");
                    }
                    attributes.put(known.get(), value);
                }
                continue;
            }
            break;
        }
        return toResult(attributes, firstHeading);
    }

    /**
     * Combines the collected attributes with the file's own heading into a declaration.
     *
     * <p>The heading is the title fallback, which is what lets an author drop an existing
     * {@code = Some Chapter} file into the tree, add one {@code :chapter-id:} line, and have it
     * render with the title it already had.
     */
    private static HeaderParseResult toResult(Map<HeaderAttribute, String> attributes, String firstHeading) {
        String rawId = attributes.get(HeaderAttribute.CHAPTER_ID);
        if (rawId == null) {
            return new HeaderParseResult.NotAChapter();
        }
        Optional<ChapterId> id = ChapterId.parse(rawId);
        if (id.isEmpty()) {
            return new HeaderParseResult.Malformed(
                    "':chapter-id:' must be lowercase kebab-case, but was '" + rawId + "'");
        }

        boolean root = attributes.containsKey(HeaderAttribute.CHAPTER_ROOT);

        String rawParent = attributes.get(HeaderAttribute.CHAPTER_PARENT);
        Optional<ChapterId> parent = Optional.empty();
        if (rawParent != null && !rawParent.isBlank()) {
            parent = ChapterId.parse(rawParent);
            if (parent.isEmpty()) {
                return new HeaderParseResult.Malformed(
                        "':chapter-parent:' must be a chapter id, but was '" + rawParent + "'");
            }
        }

        int order = ChapterHeader.DEFAULT_ORDER;
        String rawOrder = attributes.get(HeaderAttribute.CHAPTER_ORDER);
        if (rawOrder != null && !rawOrder.isBlank()) {
            try {
                order = Integer.parseInt(rawOrder.trim());
            } catch (NumberFormatException e) {
                return new HeaderParseResult.Malformed(
                        "':chapter-order:' must be a whole number, but was '" + rawOrder + "'");
            }
        }

        ChapterStatus status = ChapterStatus.DEFAULT;
        String rawStatus = attributes.get(HeaderAttribute.CHAPTER_STATUS);
        if (rawStatus != null && !rawStatus.isBlank()) {
            Optional<ChapterStatus> parsed = ChapterStatus.parse(rawStatus);
            if (parsed.isEmpty()) {
                return new HeaderParseResult.Malformed(
                        "':chapter-status:' must be one of draft, proposed, review, published, "
                                + "deprecated, but was '" + rawStatus + "'");
            }
            status = parsed.get();
        }

        String declaredTitle = attributes.get(HeaderAttribute.CHAPTER_TITLE);
        Optional<String> title = Optional.ofNullable(
                declaredTitle != null && !declaredTitle.isBlank() ? declaredTitle : firstHeading);

        try {
            return new HeaderParseResult.Parsed(
                    new ChapterHeader(id.get(), title, parent, order, status, root));
        } catch (IllegalArgumentException e) {
            return new HeaderParseResult.Malformed(e.getMessage());
        }
    }

    /**
     * Removes a UTF-8 byte order mark from the first line.
     *
     * <p>An editor that writes one turns the opening {@code :chapter-id:} into a line starting
     * with an invisible character, and the attribute silently stops matching. Stripping it costs
     * one comparison and removes an entire class of "why is my chapter not showing up".
     */
    private static String stripByteOrderMark(String line, int index) {
        if (index == 0 && line != null && !line.isEmpty() && line.charAt(0) == '\uFEFF') {
            return line.substring(1);
        }
        return line == null ? "" : line;
    }
}
