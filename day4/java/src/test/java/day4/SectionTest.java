package day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SectionTest {

    @Test
    void it_split_the_section_range() {
        var section = new Section("32-56");

        assertThat(section.start()).isEqualTo(32);
        assertThat(section.end()).isEqualTo(56);
    }

}
