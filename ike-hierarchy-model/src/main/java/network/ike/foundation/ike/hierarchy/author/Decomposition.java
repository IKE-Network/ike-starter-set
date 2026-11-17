package network.ike.foundation.ike.hierarchy.author;

import java.util.List;

/**
 * The complete result of decomposing an assembly document: the chapters carved out of it, and the
 * shell the document becomes.
 *
 * @param guideLines the assembly document's new contents — its header, its preamble, and a single
 *                   directive that pulls in everything placed beneath it
 * @param chapters   the chapter files to create
 */
public record Decomposition(List<String> guideLines, List<DecomposedChapter> chapters) {

    /**
     * Copies both lists defensively.
     *
     * @throws IllegalArgumentException if either list is null
     */
    public Decomposition {
        if (guideLines == null || chapters == null) {
            throw new IllegalArgumentException("A decomposition requires both lists");
        }
        guideLines = List.copyOf(guideLines);
        chapters = List.copyOf(chapters);
    }
}
