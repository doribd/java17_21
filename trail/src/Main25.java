/**
 * Java 25 new features demonstration.
 *
 * Features:
 * 1. Flexible constructor bodies (JEP 482) - statements before super()
 * 2. Primitive type patterns (JEP 455) - pattern matching with primitives
 * 3. Enhanced switch with primitive patterns
 */
public class Main25 {

    // Base class for flexible constructor bodies example
    static class Logger {
        private final String name;

        public Logger(String name) {
            this.name = name;
        }

        public void log(String message) {
            System.out.println("[" + name + "] " + message);
        }
    }

    // Demonstrates flexible constructor bodies - statements before super()
    static class ServiceLogger extends Logger {
        private final long startTime;

        public ServiceLogger(String serviceName) {
            // Java 25: Can now validate and prepare data before super()
            long initTime = System.currentTimeMillis();
            String validatedName = serviceName != null ? serviceName : "UnknownService";

            super(validatedName);  // super() no longer needs to be first statement
            this.startTime = initTime;
        }

        public void logStartup() {
            log("Service initialized at " + startTime);
        }
    }

    // Demonstrates primitive type patterns in switch
    public static String describePrimitive(Object value) {
        return switch (value) {
            case int i when i > 0 -> "Positive integer: " + i;
            case int i when i < 0 -> "Negative integer: " + i;
            case int i -> "Zero";
            case long l -> "Long value: " + l;
            case double d when d > 0.0 -> "Positive double: " + d;
            case double d -> "Non-positive double: " + d;
            case null -> "Null value";
            default -> "Other type: " + value.getClass().getSimpleName();
        };
    }

    // Demonstrates primitive patterns in instanceof
    public static void primitiveInstanceofExample(Object obj) {
        // Java 25: Pattern matching with primitive types
        if (obj instanceof int i) {
            System.out.println("Integer with value: " + i);
        } else if (obj instanceof double d) {
            System.out.println("Double with value: " + d);
        } else if (obj instanceof long l) {
            System.out.println("Long with value: " + l);
        } else {
            System.out.println("Not a recognized primitive type");
        }
    }

    // Record for pattern matching example
    record Temperature(double celsius) {
        public String category() {
            return switch (celsius) {
                case double c when c < 0.0 -> "Freezing";
                case double c when c < 20.0 -> "Cold";
                case double c when c < 30.0 -> "Moderate";
                case double c -> "Hot";
            };
        }
    }

    public static void main(String[] args) {
        // Flexible constructor bodies demo
        System.out.println("=== Flexible Constructor Bodies ===");
        ServiceLogger logger = new ServiceLogger("PaymentService");
        logger.logStartup();

        // Primitive type patterns in switch
        System.out.println("\n=== Primitive Type Patterns in Switch ===");
        System.out.println(describePrimitive(42));
        System.out.println(describePrimitive(-5));
        System.out.println(describePrimitive(3.14));
        System.out.println(describePrimitive(100L));

        // Primitive patterns in instanceof
        System.out.println("\n=== Primitive Patterns in instanceof ===");
        primitiveInstanceofExample(Integer.valueOf(10));
        primitiveInstanceofExample(Double.valueOf(2.5));

        // Pattern matching with primitives in records
        System.out.println("\n=== Enhanced Pattern Matching ===");
        Temperature temp = new Temperature(25.5);
        System.out.println("Temperature 25.5°C is: " + temp.category());
    }
}
