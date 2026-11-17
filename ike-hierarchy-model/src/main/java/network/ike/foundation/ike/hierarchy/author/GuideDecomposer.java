package network.ike.foundation.ike.hierarchy.author;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;

/**
 * Carves an existing assembly document into decentralised chapter files.
 *
 * <p>This is the migration path for a guide whose chapters are written inline. Each top-level
 * section becomes a file that declares its own identity and placement; the guide keeps its title,
 * its document attributes, and its preamble, and gains a single directive in place of the twenty-odd
 * sections that used to follow.
 *
 * <p>Two details do most of the work. Headings inside delimited blocks are left alone, so a
 * listing that shows AsciiDoc markup — of which a documentation guide has many — does not get
 * mistaken for structure and split the document in the wrong place. And every heading in an
 * extracted section is promoted by one level, because a fragment starts at {@code = Title} and the
 * assembly supplies the depth, exactly as {@code IKE-ASCIIDOC-FRAGMENT.md} requires.
 *
 * <p>Nothing here writes a file. The caller receives the complete proposed result and decides
 * whether to apply it, which is what makes a dry run possible.
 */
public final class GuideDecomposer {

    private static final Pattern HEADING = Pattern.compile("^(={1,6})[ \\t]+(\\S.*?)[ \\t]*$");
    private static final Pattern BLOCK_DELIMITER =
            Pattern.compile("^(-{4,}|\\.{4,}|\\+{4,}|_{4,}|={4,}|\\*{4,}|/{4,})[ \\t]*$");

    /** The gap left between consecutive chapters' sort keys, so one can be inserted between two. */
    public static final int ORDER_STEP = 100;

    private GuideDecomposer() {
    }

    /**
     * Decomposes an assembly document.
     *
     * @param lines       the assembly document's current lines
     * @param rootId      the identifier the assembly document will declare as its root
     * @param subdirectory the directory chapter files go in, relative to the assembly document,
     *                     or empty to place them alongside it
     * @return the proposed chapter files and the assembly document's new contents
     * @throws IllegalArgumentException if the lines or root identifier are null, or the
     *                                  subdirectory escapes the guide's directory
     */
    public static Decomposition decompose(List<String> lines, ChapterId rootId, String subdirectory) {
        if (lines == null || rootId == null) {
            throw new IllegalArgumentException("Lines and a root id are both required");
        }
        String directory = normaliseSubdirectory(subdirectory);

        int splitLevel = topLevelSectionLevel(lines);
        List<Section> sections = split(lines, splitLevel);

        List<DecomposedChapter> chapters = new ArrayList<>();
        Set<ChapterId> taken = new LinkedHashSet<>();
        taken.add(rootId);

        int order = ORDER_STEP;
        int fallbackIndex = 1;
        for (Section section : sections) {
            Optional<ChapterId> id = Slug.unique(section.title(), taken);
            if (id.isEmpty()) {
                String fallback = "section-" + fallbackIndex;
                while (ChapterId.parse(fallback).isPresent() && taken.contains(ChapterId.parse(fallback).get())) {
                    fallbackIndex++;
                    fallback = "section-" + fallbackIndex;
                }
                id = ChapterId.parse(fallback);
                fallbackIndex++;
            }
            if (id.isEmpty()) {
                throw new IllegalStateException("Cannot generate a valid chapter identifier for section: " + section.title());
            }
            taken.add(id.get());

            // The declaration written into the file carries no title: the section's own heading
            // travels with it and becomes the fragment's level-1 title, so declaring the title a
            // second time would create two places to change it. The reported header keeps the
            // title so the goal can name each chapter it created.
            ChapterHeader declared = new ChapterHeader(
                    id.get(), Optional.empty(), Optional.of(rootId), order, ChapterStatus.PUBLISHED, false);
            ChapterHeader reported = new ChapterHeader(
                    id.get(), Optional.of(section.title()), Optional.of(rootId), order,
                    ChapterStatus.PUBLISHED, false);

            List<String> body = promote(section.lines(), splitLevel - 1);
            List<String> content = HeaderStamper.stamp(body, declared).lines();

            chapters.add(new DecomposedChapter(reported, directory + id.get().value() + ".adoc", content));
            order += ORDER_STEP;
        }

        return new Decomposition(rebuildGuide(lines, sections, rootId), chapters);
    }

    /**
     * Rebuilds the assembly document as its header, its preamble, and one hierarchy directive.
     */
    private static List<String> rebuildGuide(List<String> lines, List<Section> sections, ChapterId rootId) {
        int firstSection = sections.isEmpty() ? lines.size() : sections.get(0).start();
        List<String> preamble = new ArrayList<>(lines.subList(0, firstSection));
        while (!preamble.isEmpty() && preamble.get(preamble.size() - 1).isBlank()) {
            preamble.remove(preamble.size() - 1);
        }

        ChapterHeader rootHeader = ChapterHeader.root(rootId);
        StampOutcome stamped = HeaderStamper.stamp(preamble, rootHeader);

        List<String> guide = new ArrayList<>(stamped.lines());
        guide.add("");
        guide.add("// Every chapter beneath '" + rootId.value() + "' is discovered from its own");
        guide.add("// ':chapter-parent:' declaration and rendered here in ':chapter-order:' order.");
        guide.add("// To add one, run: mvn ike-hierarchy:add-chapter -Dfile=<draft.adoc> -Dparent="
                + rootId.value());
        guide.add("include::hierarchy:" + rootId.value() + "[]");
        return guide;
    }

    /**
     * Determines which heading level the document's chapters sit at.
     *
     * <p>Taken from the document rather than assumed, because an assembly with a {@code = Title}
     * has chapters at {@code ==}, while a fragment being decomposed further may not.
     */
    private static int topLevelSectionLevel(List<String> lines) {
        int documentTitleLevel = 0;
        boolean inBlock = false;
        String delimiter = null;

        for (String line : lines) {
            if (BLOCK_DELIMITER.matcher(line).matches()) {
                String token = line.trim();
                if (!inBlock) {
                    inBlock = true;
                    delimiter = token;
                } else if (token.equals(delimiter)) {
                    inBlock = false;
                    delimiter = null;
                }
                continue;
            }
            if (inBlock) {
                continue;
            }
            Matcher matcher = HEADING.matcher(line);
            if (matcher.matches()) {
                documentTitleLevel = matcher.group(1).length();
                break;
            }
        }
        return documentTitleLevel == 0 ? 2 : documentTitleLevel + 1;
    }

    /**
     * Splits the document at headings of the split level, ignoring anything inside a delimited
     * block.
     */
    private static List<Section> split(List<String> lines, int splitLevel) {
        List<Section> sections = new ArrayList<>();
        boolean inBlock = false;
        String delimiter = null;

        String currentTitle = null;
        int currentStart = -1;
        List<String> current = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (BLOCK_DELIMITER.matcher(line).matches()) {
                String token = line.trim();
                if (!inBlock) {
                    inBlock = true;
                    delimiter = token;
                } else if (token.equals(delimiter)) {
                    inBlock = false;
                    delimiter = null;
                }
            }

            if (!inBlock) {
                Matcher matcher = HEADING.matcher(line);
                if (matcher.matches() && matcher.group(1).length() == splitLevel) {
                    int attachStart = backUpOverBlockAttributes(lines, i);
                    List<String> attached = new ArrayList<>(lines.subList(attachStart, i));

                    if (currentTitle != null) {
                        // Those attached lines were appended to the previous section as ordinary
                        // content. They belong to the heading that follows them, so hand them over
                        // rather than leaving a stray [preface] or block title behind.
                        for (int drop = 0; drop < attached.size() && !current.isEmpty(); drop++) {
                            current.remove(current.size() - 1);
                        }
                        sections.add(new Section(currentTitle, currentStart, trimTrailingBlanks(current)));
                    }
                    currentTitle = matcher.group(2);
                    currentStart = attachStart;
                    current = new ArrayList<>(attached);
                    current.add(line);
                    continue;
                }
            }
            if (currentTitle != null) {
                current.add(line);
            }
        }
        if (currentTitle != null) {
            sections.add(new Section(currentTitle, currentStart, trimTrailingBlanks(current)));
        }
        return sections;
    }

    /**
     * Moves a section's start back over any block attribute lines or comments attached to its
     * heading.
     *
     * <p>A line such as {@code [preface]} or {@code [#anchor]} immediately above a heading belongs
     * to that heading. Leaving it behind in the guide would attach it to whatever followed, which
     * in the case of {@code [preface]} silently changes the document's structure.
     */
    private static int backUpOverBlockAttributes(List<String> lines, int headingIndex) {
        int start = headingIndex;
        while (start > 0) {
            String previous = lines.get(start - 1).trim();
            boolean attached = (previous.startsWith("[") && previous.endsWith("]"))
                    || previous.startsWith(".") && previous.length() > 1 && !previous.startsWith("..");
            if (!attached) {
                break;
            }
            start--;
        }
        return start;
    }

    /**
     * Promotes every heading in a section by the given number of levels, leaving delimited blocks
     * untouched.
     */
    private static List<String> promote(List<String> lines, int levels) {
        if (levels <= 0) {
            return List.copyOf(lines);
        }
        List<String> promoted = new ArrayList<>(lines.size());
        boolean inBlock = false;
        String delimiter = null;

        for (String line : lines) {
            if (BLOCK_DELIMITER.matcher(line).matches()) {
                String token = line.trim();
                if (!inBlock) {
                    inBlock = true;
                    delimiter = token;
                } else if (token.equals(delimiter)) {
                    inBlock = false;
                    delimiter = null;
                }
                promoted.add(line);
                continue;
            }
            if (inBlock) {
                promoted.add(line);
                continue;
            }
            Matcher matcher = HEADING.matcher(line);
            if (matcher.matches()) {
                int level = Math.max(1, matcher.group(1).length() - levels);
                promoted.add("=".repeat(level) + " " + matcher.group(2));
                continue;
            }
            promoted.add(line);
        }
        return promoted;
    }

    private static List<String> trimTrailingBlanks(List<String> lines) {
        List<String> trimmed = new ArrayList<>(lines);
        while (!trimmed.isEmpty() && trimmed.get(trimmed.size() - 1).isBlank()) {
            trimmed.remove(trimmed.size() - 1);
        }
        return trimmed;
    }

    private static String normaliseSubdirectory(String subdirectory) {
        if (subdirectory == null || subdirectory.isBlank()) {
            return "";
        }
        String normalised = subdirectory.replace('\\', '/').trim();
        while (normalised.startsWith("/")) {
            normalised = normalised.substring(1);
        }
        while (normalised.endsWith("/")) {
            normalised = normalised.substring(0, normalised.length() - 1);
        }
        for (String segment : normalised.split("/")) {
            if (segment.equals("..")) {
                throw new IllegalArgumentException(
                        "Chapter subdirectory must not escape the guide's directory: " + subdirectory);
            }
        }
        return normalised.isEmpty() ? "" : normalised + "/";
    }

    /**
     * One extracted top-level section.
     *
     * @param title the heading text
     * @param start the index in the source document where the section begins, including any block
     *              attribute lines attached to its heading
     * @param lines the section's lines, trailing blanks removed
     */
    private record Section(String title, int start, List<String> lines) {
    }
}
