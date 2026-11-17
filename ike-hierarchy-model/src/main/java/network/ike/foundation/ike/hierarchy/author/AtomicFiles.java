package network.ike.foundation.ike.hierarchy.author;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Writes a file in one step, so a reader never sees a partial one.
 *
 * <p>This matters more than it might seem. The files these goals write are the author's own source
 * — a draft chapter, the guide itself — usually open in an editor at the time. A plain write
 * truncates the file and then fills it, and anything that interrupts the process in between leaves
 * the author's work as a half-written file. Writing to a temporary file in the same directory and
 * moving it into place makes the change all-or-nothing: either the old content or the new,
 * never a mixture.
 *
 * <p>The temporary file is created in the destination directory rather than the system temporary
 * directory because an atomic move is only atomic within a filesystem.
 */
public final class AtomicFiles {

    private AtomicFiles() {
    }

    /**
     * Writes UTF-8 text to a path atomically, creating parent directories as needed.
     *
     * @param target  the file to write
     * @param content the text to write
     * @throws IOException if the parent cannot be created, or the write or move fails
     * @throws IllegalArgumentException if either argument is null
     */
    public static void write(Path target, String content) throws IOException {
        if (target == null || content == null) {
            throw new IllegalArgumentException("A target path and content are both required");
        }
        Path directory = target.toAbsolutePath().getParent();
        if (directory == null) {
            throw new IOException("Cannot determine a parent directory for " + target);
        }
        Files.createDirectories(directory);

        Path temporary = Files.createTempFile(directory, ".ike-hierarchy-", ".tmp");
        try {
            Files.writeString(temporary, content, StandardCharsets.UTF_8);
            try {
                Files.move(temporary, target,
                        StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                // Some network and container filesystems cannot move atomically. A replacing move
                // is still a single operation from the reader's point of view on every filesystem
                // this runs on, and is strictly better than truncate-then-write.
                Files.move(temporary, target, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporary);
        }
    }

    /**
     * Joins lines with the platform line separator and a trailing newline.
     *
     * @param lines the lines to join, without terminators
     * @return the joined text, ending in a line separator, or an empty string for no lines
     * @throws IllegalArgumentException if the list is null
     */
    public static String join(java.util.List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("A line list is required");
        }
        if (lines.isEmpty()) {
            return "";
        }
        return String.join("\n", lines) + "\n";
    }
}
