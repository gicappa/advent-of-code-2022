package day4;

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
    void it_returns_the_number_of_pairs_with_full_overlapping() {
        assertThat(ex1.computeCleaningOverlapping("/test.txt")).isEqualTo(2);
    }
    @Test
    void it_returns_the_number_of_pairs_with_full_overlapping_true() {
        assertThat(ex1.computeCleaningOverlapping("/input.txt")).isEqualTo(2);
    }

    @Test
    void it_returns_the_number_of_pairs_with_partial_overlapping() {
        assertThat(ex1.computePartialCleaningOverlapping("/test.txt")).isEqualTo(4);
    }

    @Test
    void it_returns_the_number_of_pairs_with_partial_overlapping_true() {
        assertThat(ex1.computePartialCleaningOverlapping("/input.txt")).isEqualTo(2);
    }
}
