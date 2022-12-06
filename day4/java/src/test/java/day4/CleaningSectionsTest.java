package day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CleaningSectionsTest {

    @Test
    void it_split_in_two_sections() {
        var sections = new CleaningSections("49-51,31-50");

        assertThat(sections.sectionOne()).isEqualTo(new Section("49-51"));
        assertThat(sections.sectionTwo()).isEqualTo(new Section("31-50"));
    }

    @Test
    void it_computes_overlaps() {
        var sections = new CleaningSections("2-8,3-7");

        assertThat(sections.overlapsTotalCount()).isEqualTo(1);
    }

    @Test
    void it_computes_partial_overlaps() {
        var sections = new CleaningSections("5-7,7-9");

        assertThat(sections.overlapsPartialCount()).isEqualTo(1);
    }

}
