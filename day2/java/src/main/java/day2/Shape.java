package day2;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int score;

    Shape(int score) {
        this.score = score;
    }

    public static Shape of(String code) {
        if (code.equals("A") || code.equals("X")) {
            return ROCK;
        }
        if (code.equals("B") || code.equals("Y")) {
            return PAPER;
        }
        if (code.equals("C") || code.equals("Z")) {
            return SCISSORS;
        }
        throw new RuntimeException("Unknown code");
    }

    public int score() {
        return score;
    }

    public Shape winsOn() {
        if (this.equals(PAPER)) {
            return ROCK;
        }
        if (this.equals(ROCK)) {
            return SCISSORS;
        }
        if (this.equals(SCISSORS)) {
            return PAPER;
        }
        throw new RuntimeException();
    }

    public Shape loseOn() {
        if (this.equals(ROCK)) {
            return PAPER;
        }
        if (this.equals(SCISSORS)) {
            return ROCK;
        }
        if (this.equals(PAPER)) {
            return SCISSORS;
        }
        throw new RuntimeException();
    }
}
