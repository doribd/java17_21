/**
 * Java 21 example demonstrating:
 * - Text blocks (Java 15+)
 * - Sealed class inheritance (Java 17+)
 * - Sealed interface implementation (Java 17+)
 */
public final class English extends Letters implements Hash {
    @Override
    public String hash() {
        return """
                <html>
                    <body>
                        <p> Test !! </p>
                    </body>
                </html>
                """;
    }
}
