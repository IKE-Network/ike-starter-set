package network.ike.foundation.ike.hierarchy.maven;

import java.nio.file.Path;

import org.apache.maven.api.di.Inject;
import org.apache.maven.api.plugin.Log;
import org.apache.maven.api.plugin.MojoException;
import org.apache.maven.api.plugin.annotations.Mojo;
import org.apache.maven.api.plugin.annotations.Parameter;

import network.ike.foundation.ike.hierarchy.maven.support.GoalReport;
import network.ike.foundation.ike.hierarchy.maven.support.GuideSplitter;

/**
 * Splits a guide whose chapters are written inline into decentralised chapter files.
 *
 * <pre>
 * mvn ike-hierarchy:decompose -Dfile=ike-doc/src/docs/asciidoc/ike-guide.adoc
 * mvn ike-hierarchy:decompose -Dfile=ike-doc/src/docs/asciidoc/ike-guide.adoc -Dwrite=true
 * </pre>
 *
 * <p>This is the migration goal, and it rewrites a document that took a long time to write, so it
 * defaults to reporting the plan without touching anything. Run it once to read the list of
 * chapters it proposes and the identifiers it would assign; run it again with
 * {@code -Dwrite=true} to apply.
 *
 * <p>Nothing is written unless every destination is clear: a run that would overwrite an existing
 * file fails having changed nothing.
 */
@Mojo(name = "decompose", aggregator = true, projectRequired = false)
public class DecomposeMojo implements org.apache.maven.api.plugin.Mojo {

    @Inject
    private Log log;

    /** The reactor root; the guide must live beneath it. */
    @Parameter(defaultValue = "${session.rootDirectory}", readonly = true)
    private String reactorRoot;

    /** The assembly document to decompose, absolute or relative to the reactor root. */
    @Parameter(property = "file", required = true)
    private String file;

    /** The identifier the guide will declare as its root. Derived from its file name when omitted. */
    @Parameter(property = "root")
    private String root;

    /** Where chapter files are written, relative to the guide's own directory. */
    @Parameter(defaultValue = "chapters", property = "subdirectory")
    private String subdirectory;

    /** Apply the plan. Without this the goal only reports what it would do. */
    @Parameter(defaultValue = "false", property = "write")
    private boolean write;

    @Override
    public void execute() throws MojoException {
        GoalReport report = GuideSplitter.run(
                Path.of(reactorRoot),
                file,
                MojoSupport.optional(root),
                subdirectory,
                write);

        MojoSupport.log(report, log);
        if (report.failed()) {
            throw new MojoException(report.failureMessage("Could not decompose the guide:"));
        }
    }
}
