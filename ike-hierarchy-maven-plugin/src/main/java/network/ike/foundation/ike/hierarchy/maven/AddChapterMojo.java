package network.ike.foundation.ike.hierarchy.maven;

import java.nio.file.Path;
import java.util.Optional;

import org.apache.maven.api.di.Inject;
import org.apache.maven.api.plugin.Log;
import org.apache.maven.api.plugin.MojoException;
import org.apache.maven.api.plugin.annotations.Mojo;
import org.apache.maven.api.plugin.annotations.Parameter;

import network.ike.foundation.ike.hierarchy.maven.support.ChapterRegistrar;
import network.ike.foundation.ike.hierarchy.maven.support.GoalReport;

/**
 * Registers an existing AsciiDoc file as a chapter of a guide, in one command.
 *
 * <pre>
 * mvn ike-hierarchy:add-chapter -Dfile=ike-doc/src/docs/asciidoc/my-draft.adoc -Dparent=ike-guide
 * </pre>
 *
 * <p>The file is not moved, renamed, split, or copied, and the guide is not edited. The chapter's
 * placement is written into the chapter itself, which is what allows the file to live anywhere in
 * the project and still appear in the right place in the book.
 *
 * <p>Re-running with the same arguments changes nothing and reports nothing, so the command is
 * safe in a script or after an interrupted run. Re-running with a different parent or order moves
 * the chapter rather than adding a second declaration.
 */
@Mojo(name = "add-chapter", aggregator = true, projectRequired = false)
public class AddChapterMojo implements org.apache.maven.api.plugin.Mojo {

    @Inject
    private Log log;

    /** The reactor root; the chapter file must live beneath it. */
    @Parameter(defaultValue = "${session.rootDirectory}", readonly = true)
    private String reactorRoot;

    /** The AsciiDoc file to register, absolute or relative to the reactor root. */
    @Parameter(property = "file", required = true)
    private String file;

    /** The chapter identifier. Derived from the file name when omitted. */
    @Parameter(property = "id")
    private String id;

    /** The identifier of the chapter or root this chapter belongs beneath. */
    @Parameter(property = "parent")
    private String parent;

    /** The display title. Derived from the document heading or existing declaration when omitted. */
    @Parameter(property = "title")
    private String title;

    /** The sort key among siblings. Leave room between values so a chapter can be inserted later. */
    @Parameter(property = "order")
    private Integer order;

    /** One of draft, proposed, review, published, deprecated. */
    @Parameter(property = "status")
    private String status;

    /** Declare this file an assembly root rather than a chapter placed beneath one. */
    @Parameter(defaultValue = "false", property = "root")
    private boolean root;

    /** Comma-separated directories to scan when checking the identifier is free. */
    @Parameter(property = "ike-hierarchy.roots")
    private String roots;

    /** Report what would change without modifying the file. */
    @Parameter(defaultValue = "false", property = "dryRun")
    private boolean dryRun;

    @Override
    public void execute() throws MojoException {
        GoalReport report = ChapterRegistrar.run(
                Path.of(reactorRoot),
                MojoSupport.splitList(roots),
                file,
                MojoSupport.optional(id),
                MojoSupport.optional(title),
                MojoSupport.optional(parent),
                Optional.ofNullable(order),
                MojoSupport.optional(status),
                root,
                MojoSupport.limits(0, 0L, null),
                !dryRun);

        MojoSupport.log(report, log);
        if (report.failed()) {
            throw new MojoException(report.failureMessage("Could not register the chapter:"));
        }
    }
}
