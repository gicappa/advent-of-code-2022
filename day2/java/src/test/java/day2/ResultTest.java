package day2;

import static day2.Result.DRAW;
import static day2.Result.LOSE;
import static day2.Result.WIN;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    void it_returns_0_lose() {
        assertThat(LOSE.score()).isEqualTo(0);
    }
    @Test
    void it_returns_3_draw() {
        assertThat(DRAW.score()).isEqualTo(3);
    }
    @Test
    void it_returns_6_win() {
        assertThat(WIN.score()).isEqualTo(6);
    }

}
