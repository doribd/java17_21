/**
 * Java 21 features demonstration.
 *
 * Features demonstrated:
 * - var keyword (Java 10+)
 * - Switch expressions (Java 14+)
 * - Pattern matching in switch (Java 21)
 * - null handling in switch (Java 21)
 */
public class Main {

    /**
     * Simple print to System.out. Will receive one or more parameters.
     * Uses var-args feature.
     *
     * @param x one or more variables, type String
     */
    public static void printer(String... x) {
        System.out.println("X size=" + x.length);
        for (String str : x) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        // var - type inference (Java 10+)
        var zero = 0;
        if (args != null && args.length > zero) {
            var first = args[zero];
            // Java 21 pattern matching switch with null handling
            switch (first) {
                case null -> printer("Null", "Nothing");
                case "1" -> printer("1");
                case "2" -> System.out.println("2");
                case String s when s.isEmpty() -> System.out.println("Empty string");
                default -> System.out.println("default: " + first);
            }
        }
    }


}