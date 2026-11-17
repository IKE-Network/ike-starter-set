package network.ike.foundation.ike.hierarchy.scan;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verifies the containment guarantee.
 *
 * <p>The processor this design replaces resolved an unmatched include target against the
 * filesystem root, so a documentation build could be made to read any file the build user could.
 * Each case here is one way out of the project that must stay closed.
 */
class SafePathTest {

    @TempDir
    Path temp;

    private Path root() throws IOException {
        Path root = temp.resolve("project/docs");
        Files.createDirectories(root);
        return SafePath.realDirectory(root).orElseThrow();
    }

    @Test
    void shouldAcceptAFileInsideTheRoot() throws IOException {
        Path root = root();
        Path inside = root.resolve("chapter.adoc");
        Files.writeString(inside, "= Chapter");

        assertThat(SafePath.contain(root, inside)).isPresent();
    }

    @Test
    void shouldRefuseATargetThatWalksOutOfTheRoot() throws IOException {
        Path root = root();
        Path outside = temp.resolve("outside.adoc");
        Files.writeString(outside, "= Outside");

        assertThat(SafePath.contain(root, root.resolve("../../outside.adoc"))).isEmpty();
    }

    @Test
    void shouldRefuseAnAbsolutePathOutsideTheRoot() throws IOException {
        assertThat(SafePath.contain(root(), Path.of("/etc/passwd"))).isEmpty();
    }

    @Test
    void shouldRefuseAPathThatEscapesThroughASymbolicLink() throws IOException {
        Path root = root();
        Path outside = temp.resolve("secret.adoc");
        Files.writeString(outside, "= Secret");
        Path link = root.resolve("innocent.adoc");
        try {
            Files.createSymbolicLink(link, outside);
        } catch (UnsupportedOperationException | IOException unsupported) {
            return; // Symbolic links are unavailable on this filesystem.
        }
        // The link is inside the root by name, and outside it in fact. Only real-path
        // resolution can tell the difference, which is why normalising a path is not enough.
        assertThat(SafePath.contain(root, link)).isEmpty();
    }

    @Test
    void shouldAllowAWriteToAFileThatDoesNotExistYetInsideTheRoot() throws IOException {
        Path root = root();
        Optional<Path> target = SafePath.containForWrite(root, root.resolve("new/deep/chapter.adoc"));

        assertThat(target).isPresent();
        assertThat(target.orElseThrow().startsWith(root)).isTrue();
    }

    @Test
    void shouldRefuseAWriteThatWouldLandOutsideTheRoot() throws IOException {
        Path root = root();
        assertThat(SafePath.containForWrite(root, root.resolve("../../escape.adoc"))).isEmpty();
        assertThat(SafePath.containForWrite(root, Path.of("/tmp/escape.adoc"))).isEmpty();
    }

    @Test
    void shouldRenderRelativePathsWithForwardSlashesSoIndexesMatchAcrossPlatforms() throws IOException {
        Path root = root();
        Path nested = root.resolve("a/b/chapter.adoc");
        Files.createDirectories(nested.getParent());
        Files.writeString(nested, "= Chapter");

        assertThat(SafePath.relativise(root, SafePath.contain(root, nested).orElseThrow()))
                .isEqualTo("a/b/chapter.adoc");
    }
}
