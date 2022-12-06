package day2;

public enum Result {
    WIN(6),
    LOSE(0),
    DRAW(3);

    private final int score;

    Result(int score) {
        this.score = score;
    }

    public int score() {
        return score;
    }
}
