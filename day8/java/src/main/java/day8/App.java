package day8;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final ScenicScore scenicScore;
    private final VisibleTreeCounter counter;
    private final LoadInput loader;
    private final Parser parser;

    public static void main(String... args) {

        new App().run();
    }

    public App() {
        loader = new LoadInput();
        parser = new Parser();
        counter = new VisibleTreeCounter();
        scenicScore = new ScenicScore();
    }

    private void run() {
        System.out.println("--- Day 8: Treetop Tree House ---");
        System.out.printf("The number of visible tree is: %d%n", visibleTrees("/input.txt"));
        System.out.println("--- Part Two ---");
        System.out.printf("The max scenic score is: %d%n", maxScenicScore("/input.txt"));
        System.out.println("--- End Day 8 ---");
    }

    public int visibleTrees(String filename) {
        var commands = loader.load(filename);
        var grid = parser.parse(commands);
        var visibilityGrid = counter.intersectVisibilityGrids(grid);
        return counter.countVisibleTrees(visibilityGrid);
    }


    public int maxScenicScore(String filename) {
        var commands = loader.load(filename);
        var grid = parser.parse(commands);
        return scenicScore.maxScore(grid);
    }
}
