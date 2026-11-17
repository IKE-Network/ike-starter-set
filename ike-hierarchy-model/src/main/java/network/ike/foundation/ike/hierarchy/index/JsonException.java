package network.ike.foundation.ike.hierarchy.index;

/**
 * Raised when JSON text is not well formed, exceeds a parse limit, or does not have the shape the
 * index schema requires.
 *
 * <p>Unchecked because every call site treats it the same way: the index is machine-generated, so
 * a malformed one means the build is broken, not that a recoverable condition occurred.
 */
public class JsonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a message.
     *
     * @param message what was wrong with the document
     */
    public JsonException(String message) {
        super(message);
    }

    /**
     * Creates an exception with a message and cause.
     *
     * @param message what was wrong with the document
     * @param cause   the underlying failure
     */
    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
