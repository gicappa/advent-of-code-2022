package day2;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final Round round;
    private final LoadInput loader;

    public App() {
        loader = new LoadInput();
        round = new Round();
    }

    public static void main(String... args) {
        new App().run();
    }

    private void run() {
        var result = loader.load("/input.txt").stream()
            .map(this::play)
            .mapToInt(Integer::valueOf)
            .sum();

        System.out.println("Total score strategy one" + result);
    }

    private Integer play(String line) {
        return round.play(Shape.of(getShapePlayerOne(line)), getShapePlayerTwo(line)).score();
    }

    private String getShapePlayerTwo(String line) {
        return line.split(" ")[1];
    }

    private String getShapePlayerOne(String line) {
        return line.split(" ")[0];
    }
}
