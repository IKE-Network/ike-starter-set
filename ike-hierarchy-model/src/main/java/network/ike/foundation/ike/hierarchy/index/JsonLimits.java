package network.ike.foundation.ike.hierarchy.index;

/**
 * The bounds a JSON parse will not exceed.
 *
 * <p>A recursive-descent parser turns nesting depth in the input into stack depth in the process,
 * so a document consisting of ten thousand open brackets is a stack overflow rather than a parse
 * error. The depth limit turns that into an ordinary, catchable failure. The length limit bounds
 * the work done before any structure is known at all.
 *
 * @param maxDepth  the deepest nesting of objects and arrays accepted
 * @param maxLength the longest document accepted, in characters
 */
public record JsonLimits(int maxDepth, int maxLength) {

    /**
     * Rejects nonsensical bounds.
     *
     * @throws IllegalArgumentException if either bound is not positive
     */
    public JsonLimits {
        if (maxDepth <= 0 || maxLength <= 0) {
            throw new IllegalArgumentException("JSON limits must be positive");
        }
    }

    /**
     * Returns bounds generous for a generated index and hostile to a pathological document.
     *
     * @return the default limits: 32 levels of nesting, 16 MiB of text
     */
    public static JsonLimits defaults() {
        return new JsonLimits(32, 16 * 1024 * 1024);
    }
}
