/**
 * Sealed class. Allows us to control the inheritance.
 * Demonstrates Java 21 pattern matching in switch expressions.
 */
public sealed class Letters permits English {

    /**
     * Pattern matching with switch expression (Java 21).
     *
     * @param object to be checked for its type
     */
    void check(Object object) {
        switch (object) {
            case String name -> System.out.println("String: " + name);
            case Integer num -> System.out.println("Integer: " + num);
            case null -> System.out.println("Null value");
            default -> System.out.println("Unknown type");
        }
    }
}
