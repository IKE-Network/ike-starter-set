package network.ike.foundation.ike.doc.extension;

import network.ike.foundation.ike.hierarchy.index.HierarchyIndex;
import network.ike.foundation.ike.hierarchy.index.IndexCodec;
import network.ike.foundation.ike.hierarchy.index.IndexedChapter;
import network.ike.foundation.ike.hierarchy.index.IndexedRoot;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class HierarchyRenderTest {

    @Test
    void renderHierarchyWithFixtureIndex(@TempDir Path tempDir) throws IOException {
        Path rootDoc = tempDir.resolve("my-guide.adoc");
        Files.writeString(rootDoc, """
                = My Test Guide
                :toc: left
                :chapter-id: my-guide
                :chapter-root:

                include::hierarchy:my-guide[]
                """);

        Path ch1 = tempDir.resolve("chapter1.adoc");
        Files.writeString(ch1, """
                :chapter-id: intro
                :chapter-parent: my-guide
                :chapter-order: 100
                :chapter-status: published

                = Introduction

                Welcome to the test guide.
                """);

        Path ch2 = tempDir.resolve("chapter2.adoc");
        Files.writeString(ch2, """
                :chapter-id: details
                :chapter-parent: my-guide
                :chapter-order: 200
                :chapter-status: published

                = Deep Dive

                == Section 2.1
                Detailed explanations here.
                """);

        HierarchyIndex index = new HierarchyIndex(
                HierarchyIndex.SCHEMA,
                5,
                List.of(new IndexedRoot(
                        "docs",
                        "."
                )),
                List.of(
                        new IndexedChapter(
                                new ChapterId("my-guide"),
                                "My Test Guide",
                                Optional.empty(),
                                0,
                                ChapterStatus.PUBLISHED,
                                true,
                                0,
                                "docs",
                                "my-guide.adoc"
                        ),
                        new IndexedChapter(
                                new ChapterId("intro"),
                                "Introduction",
                                Optional.of(new ChapterId("my-guide")),
                                100,
                                ChapterStatus.PUBLISHED,
                                false,
                                1,
                                "docs",
                                "chapter1.adoc"
                        ),
                        new IndexedChapter(
                                new ChapterId("details"),
                                "Deep Dive",
                                Optional.of(new ChapterId("my-guide")),
                                200,
                                ChapterStatus.PUBLISHED,
                                false,
                                1,
                                "docs",
                                "chapter2.adoc"
                        )
                )
        );

        Path indexPath = tempDir.resolve("hierarchy-index.json");
        Files.writeString(indexPath, IndexCodec.write(index));

        Path outputFile = tempDir.resolve("my-guide.html");

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        try {
            new HierarchyExtensionRegistry().register(asciidoctor);

            Attributes attributes = Attributes.builder()
                    .attribute("ike-hierarchy-index", indexPath.toString())
                    .attribute("ike-hierarchy-base", tempDir.toString())
                    .attribute("toc", "left")
                    .attribute("sectnums", "true")
                    .build();

            Options options = Options.builder()
                    .baseDir(tempDir.toFile())
                    .safe(SafeMode.UNSAFE)
                    .backend("html5")
                    .toFile(outputFile.toFile())
                    .attributes(attributes)
                    .build();

            asciidoctor.convertFile(rootDoc.toFile(), options);

            assertThat(outputFile).exists();
            String html = Files.readString(outputFile);
            assertThat(html).contains("My Test Guide");
            assertThat(html).contains("Introduction");
            assertThat(html).contains("Welcome to the test guide");
            assertThat(html).contains("Deep Dive");
            assertThat(html).contains("Detailed explanations here");
        } finally {
            asciidoctor.shutdown();
        }
    }

    @Test
    void renderIkeGuideIfIndexExists() throws IOException {
        Path projectRoot = Paths.get("..").toAbsolutePath().normalize();
        if (!Files.exists(projectRoot.resolve("ike-doc"))) {
            projectRoot = Paths.get(".").toAbsolutePath().normalize();
        }

        Path guidePath = projectRoot.resolve("ike-doc/src/docs/asciidoc/ike-guide.adoc");
        Path indexPath = projectRoot.resolve("ike-doc/target/ike-hierarchy-index.json");
        Path outputDir = projectRoot.resolve("ike-doc/target/generated-docs");

        if (!Files.exists(indexPath)) {
            // Evaluated during isolated module tests; fixture test covers hermetic rendering
            return;
        }

        Files.createDirectories(outputDir);
        Path outputFile = outputDir.resolve("ike-guide.html");

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        try {
            new HierarchyExtensionRegistry().register(asciidoctor);

            Attributes attributes = Attributes.builder()
                    .attribute("ike-hierarchy-index", indexPath.toString())
                    .attribute("ike-hierarchy-base", projectRoot.toString())
                    .attribute("toc", "left")
                    .attribute("sectnums", "true")
                    .build();

            Options options = Options.builder()
                    .baseDir(guidePath.getParent().toFile())
                    .safe(SafeMode.UNSAFE)
                    .backend("html5")
                    .toFile(outputFile.toFile())
                    .attributes(attributes)
                    .build();

            asciidoctor.convertFile(guidePath.toFile(), options);

            assertThat(outputFile).exists();
            String html = Files.readString(outputFile);
            assertThat(html).contains("Ike Starter Set");
            assertThat(html).contains("How to Read This Guide");
            assertThat(html).contains("Tinkar Base Model");
            assertThat(html).contains("CQL in Komet");
            assertThat(html).contains("cql-dictionary.html");
            assertThat(html).doesNotContain("All 136 CQL keywords");
        } finally {
            asciidoctor.shutdown();
        }
    }

    @Test
    void renderCqlDictionaryIfPresent() throws IOException {
        Path projectRoot = Paths.get("..").toAbsolutePath().normalize();
        if (!Files.exists(projectRoot.resolve("ike-doc"))) {
            projectRoot = Paths.get(".").toAbsolutePath().normalize();
        }

        Path dictPath = projectRoot.resolve("ike-doc/src/docs/asciidoc/cql-dictionary.adoc");
        Path indexPath = projectRoot.resolve("ike-doc/target/ike-hierarchy-index.json");
        Path outputDir = projectRoot.resolve("ike-doc/target/generated-docs");

        if (!Files.exists(dictPath) || !Files.exists(indexPath)) {
            // Evaluated during isolated module tests; fixture test covers hermetic rendering
            return;
        }

        Files.createDirectories(outputDir);
        Path outputFile = outputDir.resolve("cql-dictionary.html");

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        try {
            new HierarchyExtensionRegistry().register(asciidoctor);

            Attributes attributes = Attributes.builder()
                    .attribute("ike-hierarchy-index", indexPath.toString())
                    .attribute("ike-hierarchy-base", projectRoot.toString())
                    .attribute("toc", "left")
                    .attribute("sectnums", "true")
                    .build();

            Options options = Options.builder()
                    .baseDir(dictPath.getParent().toFile())
                    .safe(SafeMode.UNSAFE)
                    .backend("html5")
                    .toFile(outputFile.toFile())
                    .attributes(attributes)
                    .build();

            asciidoctor.convertFile(dictPath.toFile(), options);

            assertThat(outputFile).exists();
            String html = Files.readString(outputFile);
            assertThat(html).contains("CQL Keyword Dictionary");
            assertThat(html).contains("All 136 CQL keywords");
            assertThat(html).contains("term-and");
        } finally {
            asciidoctor.shutdown();
        }
    }
}
