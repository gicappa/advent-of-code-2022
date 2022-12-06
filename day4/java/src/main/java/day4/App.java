package day4;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final LoadInput loader;

    public App() {
        loader = new LoadInput();
    }

    public int computeCleaningOverlapping(String filename) {
        var cleaningLines = loader.load(filename);

        return cleaningLines.stream()
            .map(CleaningSections::new)
            .map(CleaningSections::overlapsTotalCount)
            .mapToInt(Integer::valueOf)
            .sum();
    }

    public int computePartialCleaningOverlapping(String filename) {
        var cleaningLines = loader.load(filename);

        return cleaningLines.stream()
            .map(CleaningSections::new)
            .map(CleaningSections::overlapsPartialCount)
            .mapToInt(Integer::valueOf)
            .sum();
    }

    public static void main(String... args) {
        var ex1 = new App();

        System.out.printf("Number of overlaps %d%n", ex1.computeCleaningOverlapping("input.txt"));
    }
}
