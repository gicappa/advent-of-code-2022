package day2;

public record OutcomePlayerTwo(Result result, Shape shape) {

    public int score() {
        return result.score() + shape.score();
    }
}
