package network.ike.foundation.ike.hierarchy.maven;

import java.nio.file.Path;

import org.apache.maven.api.Lifecycle.Phase;
import org.apache.maven.api.di.Inject;
import org.apache.maven.api.plugin.Log;
import org.apache.maven.api.plugin.MojoException;
import org.apache.maven.api.plugin.annotations.Mojo;
import org.apache.maven.api.plugin.annotations.Parameter;

import network.ike.foundation.ike.hierarchy.index.HierarchyIndex;
import network.ike.foundation.ike.hierarchy.maven.support.IndexBuilder;

/**
 * Discovers every chapter in the project, validates the hierarchy they declare, and writes the
 * index that document rendering reads.
 *
 * <p>Bind this ahead of the phase that renders documentation. It is the only step that touches the
 * filesystem looking for chapters; everything after it works from the index.
 *
 * <p>The goal fails the build on any defect — a duplicate identifier, a parent that does not
 * exist, a cycle, a chapter nested too deeply, or a file that resolves outside the project. A
 * chapter that cannot be placed would otherwise be a chapter that quietly disappears from a
 * twenty-chapter book, which is close to impossible to notice in review.
 */
@Mojo(name = "index", defaultPhase = Phase.INITIALIZE)
public class IndexMojo implements org.apache.maven.api.plugin.Mojo {

    @Inject
    private Log log;

    /** The reactor root; every scan root must resolve beneath it. */
    @Parameter(defaultValue = "${session.rootDirectory}", readonly = true)
    private String reactorRoot;

    /** Where the index is written. */
    @Parameter(defaultValue = "${project.build.directory}/ike-hierarchy-index.json",
            property = "ike-hierarchy.indexFile")
    private String indexFile;

    /**
     * Comma-separated directories to scan, relative to the reactor root. Empty means the reactor
     * root itself, so a chapter may be dropped anywhere in the project.
     */
    @Parameter(property = "ike-hierarchy.roots")
    private String roots;

    /** The deepest a chapter may nest below its assembly root. */
    @Parameter(defaultValue = "5", property = "ike-hierarchy.maxDepth")
    private int maxDepth;

    /** The most AsciiDoc files a single scan will examine. */
    @Parameter(defaultValue = "0", property = "ike-hierarchy.maxFiles")
    private int maxFiles;

    /** The largest file, in bytes, whose header will be read. */
    @Parameter(defaultValue = "0", property = "ike-hierarchy.maxFileBytes")
    private long maxFileBytes;

    /** Comma-separated directory names never descended into. Empty uses the built-in list. */
    @Parameter(property = "ike-hierarchy.exclude")
    private String exclude;

    /** Report what would be written without writing it. */
    @Parameter(defaultValue = "false", property = "ike-hierarchy.dryRun")
    private boolean dryRun;

    /** Skip this goal entirely. */
    @Parameter(defaultValue = "false", property = "ike-hierarchy.skip")
    private boolean skip;

    @Override
    public void execute() throws MojoException {
        if (skip) {
            log.info("ike-hierarchy:index skipped.");
            return;
        }
        IndexBuilder.Outcome outcome = IndexBuilder.run(
                Path.of(reactorRoot),
                MojoSupport.splitList(roots),
                Path.of(indexFile),
                maxDepth,
                MojoSupport.limits(maxFiles, maxFileBytes, exclude),
                !dryRun);

        MojoSupport.log(outcome.report(), log);
        if (outcome.report().failed()) {
            throw new MojoException(outcome.report().failureMessage(
                    "The chapter hierarchy is not valid, so no index was written:"));
        }
        outcome.index().ifPresent(index -> log.debug(
                "Index schema " + HierarchyIndex.SCHEMA + " with " + index.chapters().size()
                        + " entries."));
    }
}
