import java.util.List;
import java.util.stream.Gatherers;

/**
 * Java 25 Stream Gatherers demonstration.
 *
 * Features:
 * 1. Stream Gatherers API - custom intermediate operations
 * 2. Built-in gatherers: fold, mapConcurrent, windowFixed, windowSliding
 */
public class StreamGatherers25 {

    // Demonstrates windowFixed gatherer - process stream in fixed-size windows
    public static void windowFixedExample() {
        System.out.println("=== Fixed Window Gatherer ===");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Process in windows of 3
        List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowFixed(3))
                .toList();

        windows.forEach(window -> System.out.println("Window: " + window));
    }

    // Demonstrates windowSliding gatherer - overlapping windows
    public static void windowSlidingExample() {
        System.out.println("\n=== Sliding Window Gatherer ===");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // Sliding window of size 3
        List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowSliding(3))
                .toList();

        windows.forEach(window -> System.out.println("Window: " + window));
    }

    // Demonstrates fold gatherer - stateful transformation
    public static void foldExample() {
        System.out.println("\n=== Fold Gatherer ===");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Running sum using fold
        List<Integer> runningSums = numbers.stream()
                .gather(Gatherers.fold(() -> 0, (sum, num) -> sum + num))
                .toList();

        System.out.println("Running sums: " + runningSums);
    }

    // Demonstrates mapConcurrent gatherer - parallel mapping
    public static void mapConcurrentExample() {
        System.out.println("\n=== Map Concurrent Gatherer ===");
        List<String> urls = List.of("page1", "page2", "page3", "page4");

        // Simulate concurrent processing
        List<String> results = urls.stream()
                .gather(Gatherers.mapConcurrent(4, url -> {
                    // Simulate some processing
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return "Processed: " + url.toUpperCase();
                }))
                .toList();

        results.forEach(System.out::println);
    }

    // Custom example: batch processing with windows
    public static void batchProcessingExample() {
        System.out.println("\n=== Batch Processing Example ===");
        List<String> items = List.of("A", "B", "C", "D", "E", "F", "G");

        // Process items in batches of 3
        items.stream()
                .gather(Gatherers.windowFixed(3))
                .forEach(batch -> {
                    System.out.println("Processing batch: " + batch);
                    // Simulate batch processing
                    System.out.println("  -> Batch processed successfully");
                });
    }

    // Example: moving average calculation
    public static void movingAverageExample() {
        System.out.println("\n=== Moving Average Example ===");
        List<Double> prices = List.of(10.0, 12.0, 11.0, 13.0, 15.0, 14.0, 16.0);

        List<Double> movingAverages = prices.stream()
                .gather(Gatherers.windowSliding(3))
                .map(window -> window.stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0))
                .toList();

        System.out.println("Prices: " + prices);
        System.out.println("3-period moving averages: " + movingAverages);
    }

    public static void main(String[] args) {
        windowFixedExample();
        windowSlidingExample();
        foldExample();
        mapConcurrentExample();
        batchProcessingExample();
        movingAverageExample();
    }
}
