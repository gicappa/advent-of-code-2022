package day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    void beforeEach() {
        app = new App();
    }

    @Test
    void it_returns_the_max_sum() {
        assertThat(app.returnsMaxCalories("/test.txt")).isEqualTo(24000);
    }

    @Test
    void it_create_a_list_of_summed_calories() {
        var result = app.createListOfSummedCalories(List.of("1000", "2000", "", "4000"));

        assertThat(result).containsExactly(3000, 4000);
    }

    @Test
    void it_returns_the_sum_of_the_three_max() {
        assertThat(app.returnsThreeMaxCalories("/test.txt")).isEqualTo(45000);
    }

}
