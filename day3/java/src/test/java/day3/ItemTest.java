package day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ItemTest {

    //Lowercase item types a through z have priorities 1 through 26.
    //Uppercase item types A through Z have priorities 27 through 52.
    @Test
    void it_computes_the_priority_a() {
        var item = new Item("a");
        assertThat(item.priority()).isEqualTo(1);
    }


    @Test
    void it_computes_the_priority_z() {
        var item = new Item("z");
        assertThat(item.priority()).isEqualTo(26);
    }

    @Test
    void it_computes_the_priority_A() {
        var item = new Item("A");
        assertThat(item.priority()).isEqualTo(27);
    }

    @Test
    void it_computes_the_priority_Z() {
        var item = new Item("Z");
        assertThat(item.priority()).isEqualTo(52);
    }
}
