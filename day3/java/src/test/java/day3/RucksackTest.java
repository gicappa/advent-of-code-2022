package day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RucksackTest {

    private Rucksack rucksack;

    @BeforeEach
    void beforeEach() {
        rucksack = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
    }

    @Test
    void it_separate_the_two_pockets() {
        assertThat(rucksack.pocketOne()).isEqualTo("vJrwpWtwJgWr");
        assertThat(rucksack.pocketTwo()).isEqualTo("hcsFMMfFFhFp");
    }

    @Test
    void it_extract_the_stringItem() {
        assertThat(rucksack.extractString()).isEqualTo("p");
    }

    @Test
    void it_extract_the_item() {
        assertThat(rucksack.extractItem()).isEqualTo(new Item("p"));
    }
}
