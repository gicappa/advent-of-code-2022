package day2;

import static day2.Shape.PAPER;
import static day2.Shape.ROCK;
import static day2.Shape.SCISSORS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ShapeTest {

    @Test
    void it_gives_1_point_for_rock() {
        assertThat(ROCK.score()).isEqualTo(1);
    }

    @Test
    void it_gives_2_point_for_paper() {
        assertThat(PAPER.score()).isEqualTo(2);
    }

    @Test
    void it_gives_3_point_for_scissors() {
        assertThat(Shape.SCISSORS.score()).isEqualTo(3);
    }

    //    A for Rock, B for Paper, and C for Scissors
    @Test
    void it_returns_ROCK_A() {
        assertThat(Shape.of("A")).isEqualTo(ROCK);
    }

    @Test
    void it_returns_PAPER_B() {
        assertThat(Shape.of("B")).isEqualTo(PAPER);
    }

    @Test
    void it_returns_SCISSORS_C() {
        assertThat(Shape.of("C")).isEqualTo(SCISSORS);
    }
    //X for Rock, Y for Paper, and Z for Scissors
    @Test
    void it_returns_ROCK_X() {
        assertThat(Shape.of("X")).isEqualTo(ROCK);
    }

    @Test
    void it_returns_PAPER_Y() {
        assertThat(Shape.of("Y")).isEqualTo(PAPER);
    }

    @Test
    void it_returns_SCISSORS_Z() {
        assertThat(Shape.of("Z")).isEqualTo(SCISSORS);
    }

}
