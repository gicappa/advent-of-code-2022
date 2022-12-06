package day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App ex1;

    @BeforeEach
    void beforeEach() {
        ex1 = new App();
    }

    @Test
    void it_returns_the_priority_sum() {
        assertThat(ex1.totalPriorities("/test.txt")).isEqualTo(157);
    }
    @Test
    void it_returns_the_priority_sum_true() {
        assertThat(ex1.totalPriorities("/src/main/resources/input.txt")).isEqualTo(157);
    }
    @Test
    void it_returns_the_priority_sum_ex2() {
        assertThat(ex1.totalBadgesPriorities("/test.txt")).isEqualTo(70);
    }
    @Test
    void it_returns_the_priority_sum_ex2_true() {
        assertThat(ex1.totalBadgesPriorities("/src/main/resources/input.txt")).isEqualTo(70);
    }
}
