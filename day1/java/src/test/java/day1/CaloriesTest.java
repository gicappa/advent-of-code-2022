package day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CaloriesTest {

    @Test
    void it_adds_a_calory_count() {
        var calories = new Calories().add(10);

        assertThat(calories.getSummaryList()).isEqualTo(List.of(10));
    }

    @Test
    void it_adds_two_calory_entry_to_the_count() {
        var calories = new Calories().add(10).add(20);

        assertThat(calories.getSummaryList()).isEqualTo(List.of(30));
    }

    @Test
    void it_creates_a_new_elf_report() {
        var calories = new Calories().add(10).add(20).newSummary().add(15).add(3);

        assertThat(calories.getSummaryList()).isEqualTo(List.of(30, 18));
    }

    @Test
    void it_add_all_calories() {
        var calOne = new Calories().add(10).add(20);
        var calTwo = new Calories().add(15).add(3);
        var calories = calOne.add(calTwo);

        assertThat(calories.getSummaryList()).isEqualTo(List.of(30, 18));
    }

}
