package network.ike.foundation.ike.doc.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

/**
 * Registers the hierarchy include processor with Asciidoctor through the service loader.
 *
 * <p>An include processor is registered this way, rather than per execution in the POM, because it
 * must be present for every backend: a chapter that appears in the HTML build and not the PDF one
 * would be worse than a chapter that appears in neither. Per {@code IKE-JAVA.md}, only
 * postprocessors and tree processors need the per-execution treatment, and only because of the
 * Prawn backend.
 */
public class HierarchyExtensionRegistry implements ExtensionRegistry {

    /** Creates the registry; invoked by the service loader. */
    public HierarchyExtensionRegistry() {
    }

    @Override
    public void register(Asciidoctor asciidoctor) {
        JavaExtensionRegistry registry = asciidoctor.javaExtensionRegistry();
        registry.includeProcessor(new HierarchyIncludeProcessor());
    }
}
