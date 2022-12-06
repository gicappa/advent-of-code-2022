package day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElfGroupTest {

    private ElfGroup elfGroup;

    @BeforeEach
    void beforeEach() {
        elfGroup = new ElfGroup(List.of(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg"
        ));
    }

    @Test
    void it_returns_item() {
        assertThat(elfGroup.extractItem()).isEqualTo(new Item("r"));
    }
}
