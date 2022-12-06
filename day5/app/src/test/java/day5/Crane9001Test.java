package day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * [D] [N] [C] [Z] [M] [P] 1   2   3
 * <p>
 * move 1 from 2 to 1 move 3 from 1 to 3 move 2 from 2 to 1 move 1 from 1 to 2
 */
public class Crane9001Test {

    private Crane crane;

    @BeforeEach
    void beforeEach() {
        crane = Crane.newCrane9001();
        crane.newStack("NZ");
        crane.newStack("DCM");
        crane.newStack("P");
    }

    @Test
    void it_create_stacks() {
        var stack = new Stack<String>();
        stack.push("Z");
        stack.push("N");

        assertThat(crane.get(1)).isEqualTo(stack);
    }

    /**
     * [D] [N] [C] [Z] [M] [P] 1   2   3
     */
    @Test
    void it_move_1_stack_2_to_1() {
        crane.move(1, 2, 1);

        var stack1 = new Stack<String>();
        stack1.push("Z");
        stack1.push("N");
        stack1.push("D");

        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");

        assertThat(crane.get(1)).isEqualTo(stack1);
        assertThat(crane.get(2)).isEqualTo(stack2);
    }

    /**
     * [Z] [N] [C] [D] [M] [P] 1   2   3
     */
    @Test
    void it_move_3_stack_1_to_3() {
        crane.move(1, 2, 1);
        crane.move(3, 1, 3);

        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");

        var stack3 = new Stack<String>();
        stack3.push("P");
        stack3.push("Z");
        stack3.push("N");
        stack3.push("D");

        assertThat(crane.get(1)).isEqualTo(new Stack<String>());
        assertThat(crane.get(2)).isEqualTo(stack2);
        assertThat(crane.get(3)).isEqualTo(stack3);
    }

    /**
     * [Z] [N] [M]     [D] [C]     [P] 1   2   3
     */
    @Test
    void it_test_the_move() {
        crane.move(1, 2, 1);
        crane.move(3, 1, 3);
        crane.move(2, 2, 1);

        var stack1 = new Stack<String>();
        stack1.push("M");
        stack1.push("C");

        var stack3 = new Stack<String>();
        stack3.push("P");
        stack3.push("Z");
        stack3.push("N");
        stack3.push("D");

        assertThat(crane.get(1)).isEqualTo(stack1);
        assertThat(crane.get(2)).isEqualTo(new Stack<String>());
        assertThat(crane.get(3)).isEqualTo(stack3);

    }

    @Test
    void it_get_the_top_of_the_stack() {

        crane.move(1, 2, 1);
        crane.move(3, 1, 3);
        crane.move(2, 2, 1);
        crane.move(1, 1, 2);
        assertThat(crane.getCrateSequence()).isEqualTo("MCD");

    }

    @Test
    void it_accept_an_array_as_input_move() {
        crane.handle(new Command(1, 2, 1));

        var stack1 = new Stack<String>();
        stack1.push("Z");
        stack1.push("N");
        stack1.push("D");

        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");

        assertThat(crane.get(1)).isEqualTo(stack1);
        assertThat(crane.get(2)).isEqualTo(stack2);

    }
}
