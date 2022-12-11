package day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    void beforeEach() {
        app = new App();
    }

    @Test
    void it_returns_some_greetings() {
        assertThat(app.visibleTrees("/test.txt")).isEqualTo(21);
    }
    
    @Test
    void it_higher_scenic_score() {
      assertThat(app.maxScenicScore("/test.txt")).isEqualTo(8);
    }
}
