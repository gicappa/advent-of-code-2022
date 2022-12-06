package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void it_parse_a_line() {
        var parser = new MoveParser();
        assertThat(parser.parse("move 1 from 2 to 1")).isEqualTo(new Command(1,2,1));

    }
}
