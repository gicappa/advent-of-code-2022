package day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParserTest {

    private Parser parser;
    private final List<String> rows = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390");


    @BeforeEach
    void beforeEach() {
        parser = new Parser();
    }

    @Test
    void it_parses_the_grid() {
        var grid = parser.parse(rows);

        assertThat(grid[0][0]).isEqualTo(3);
        assertThat(grid[0][1]).isEqualTo(0);
        assertThat(grid[0][2]).isEqualTo(3);
        assertThat(grid[0][3]).isEqualTo(7);
        assertThat(grid[1][1]).isEqualTo(5);
        assertThat(grid[1][2]).isEqualTo(5);
        assertThat(grid[4][4]).isEqualTo(0);
    }

}
