package day2;

import static day2.Result.DRAW;
import static day2.Result.LOSE;
import static day2.Result.WIN;
import static day2.Shape.PAPER;
import static day2.Shape.ROCK;
import static day2.Shape.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OutcomeTest {
    @Test
    void it_compute_the_score_ex1() {
        var outcome =  new OutcomePlayerTwo(DRAW, SCISSORS);

        assertThat(outcome.score()).isEqualTo(6);
    }
    @Test
    void it_compute_the_score_ex2() {
        var outcome =  new OutcomePlayerTwo(LOSE, ROCK);

        assertThat(outcome.score()).isEqualTo(1);
    }
    @Test
    void it_compute_the_score_ex3() {
        var outcome =  new OutcomePlayerTwo(WIN, PAPER);

        assertThat(outcome.score()).isEqualTo(8);
    }

}
