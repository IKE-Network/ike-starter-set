package network.ike.foundation.ike.hierarchy.maven;

import java.nio.file.Path;

import org.apache.maven.api.di.Inject;
import org.apache.maven.api.plugin.Log;
import org.apache.maven.api.plugin.MojoException;
import org.apache.maven.api.plugin.annotations.Mojo;
import org.apache.maven.api.plugin.annotations.Parameter;

import network.ike.foundation.ike.hierarchy.maven.support.IndexBuilder;

/**
 * Checks the chapter hierarchy without writing anything.
 *
 * <p>The same scan and validation {@code index} performs, with the write suppressed — for asking
 * "would this build succeed?" after moving chapters around, and for a continuous-integration step
 * that wants to fail a pull request before anything is generated.
 */
@Mojo(name = "validate", aggregator = true)
public class ValidateMojo implements org.apache.maven.api.plugin.Mojo {

    @Inject
    private Log log;

    /** The reactor root; every scan root must resolve beneath it. */
    @Parameter(defaultValue = "${session.rootDirectory}", readonly = true)
    private String reactorRoot;

    /** Comma-separated directories to scan, relative to the reactor root. */
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

    /** Comma-separated directory names never descended into. */
    @Parameter(property = "ike-hierarchy.exclude")
    private String exclude;

    @Override
    public void execute() throws MojoException {
        IndexBuilder.Outcome outcome = IndexBuilder.run(
                Path.of(reactorRoot),
                MojoSupport.splitList(roots),
                Path.of(reactorRoot).resolve("target").resolve("ike-hierarchy-index.json"),
                maxDepth,
                MojoSupport.limits(maxFiles, maxFileBytes, exclude),
                false);

        MojoSupport.log(outcome.report(), log);
        if (outcome.report().failed()) {
            throw new MojoException(outcome.report().failureMessage(
                    "The chapter hierarchy is not valid:"));
        }
        log.info("The chapter hierarchy is valid.");
    }
}
