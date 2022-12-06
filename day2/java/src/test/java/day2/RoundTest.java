package day2;

import static day2.Result.DRAW;
import static day2.Result.LOSE;
import static day2.Result.WIN;
import static day2.Shape.PAPER;
import static day2.Shape.ROCK;
import static day2.Shape.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoundTest {

    private Round round;

    @BeforeEach
    void beforeEach() {
        round = new Round();
    }

    @Test
    void rock_defeat_scissors() {
        OutcomePlayerTwo outcome = round.play(ROCK, SCISSORS);

        assertThat(outcome.result()).isEqualTo(LOSE);
        assertThat(outcome.shape()).isEqualTo(SCISSORS);
    }

    @Test
    void scissor_lose_rock() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, ROCK);

        assertThat(outcome.result()).isEqualTo(WIN);
        assertThat(outcome.shape()).isEqualTo(ROCK);
    }

    @Test
    void scissor_defeat_paper() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, PAPER);

        assertThat(outcome.result()).isEqualTo(LOSE);
        assertThat(outcome.shape()).isEqualTo(PAPER);
    }

    @Test
    void paper_lose_scissor() {
        OutcomePlayerTwo outcome = round.play(PAPER, SCISSORS);

        assertThat(outcome.result()).isEqualTo(WIN);
        assertThat(outcome.shape()).isEqualTo(SCISSORS);
    }

    @Test
    void paper_defeats_rock() {
        OutcomePlayerTwo outcome = round.play(PAPER, ROCK);

        assertThat(outcome.result()).isEqualTo(LOSE);
        assertThat(outcome.shape()).isEqualTo(ROCK);
    }

    @Test
    void rock_lose_paper() {
        OutcomePlayerTwo outcome = round.play(ROCK, PAPER);

        assertThat(outcome.result()).isEqualTo(WIN);
        assertThat(outcome.shape()).isEqualTo(PAPER);
    }

    @Test
    void draw_equals_rock() {
        OutcomePlayerTwo outcome = round.play(ROCK, ROCK);
        assertThat(outcome.result()).isEqualTo(DRAW);
        assertThat(outcome.shape()).isEqualTo(ROCK);
    }

    @Test
    void draw_equals_paper() {
        OutcomePlayerTwo outcome = round.play(PAPER, PAPER);
        assertThat(outcome.result()).isEqualTo(DRAW);
        assertThat(outcome.shape()).isEqualTo(PAPER);
    }

    @Test
    void draw_equals_scissor() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, SCISSORS);
        assertThat(outcome.result()).isEqualTo(DRAW);
        assertThat(outcome.shape()).isEqualTo(SCISSORS);
    }

    @Test
    void it_ends_with_lose_when_X() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, "Y");
        assertThat(outcome.result()).isEqualTo(DRAW);
        assertThat(outcome.shape()).isEqualTo(SCISSORS);

    }

    @Test
    void it_ends_with_win_when_Z() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, "Z");
        assertThat(outcome.result()).isEqualTo(WIN);
        assertThat(outcome.shape()).isEqualTo(ROCK);

    }
    @Test
    void it_ends_with_win_when_X() {
        OutcomePlayerTwo outcome = round.play(SCISSORS, "X");
        assertThat(outcome.result()).isEqualTo(LOSE);
        assertThat(outcome.shape()).isEqualTo(PAPER);

    }

}
