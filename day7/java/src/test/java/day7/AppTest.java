package day7;

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
    void it_returns_the_sum_of_the_sizes_less_than_100000() {
        assertThat(app.sumSizesLessThan100000("/test.txt")).isEqualTo(95437);
    }

    @Test
    void it_returns_the_smallest_dir_to_free_space() {
        assertThat(app.smallestDirToFree30000000(
            "/test.txt", 70000000, 30000000)).isEqualTo(24933642);
    }

    @Test
    void it_returns_the_smallest_file_size_to_free_space() {
        assertThat(app.getSelectedSmallestFileSizeToFreeSpace(
            4000,
            3000, List.of(100, 500, 900, 1100, 2000, 4000)))
            .isEqualTo(1100);
    }
    
}
