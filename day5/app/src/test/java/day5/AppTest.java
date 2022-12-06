package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;
    private Crane crane;

    @BeforeEach
    void beforeEach() {
        app = new App();
        crane = Crane.newCrane9000();
        crane.newStack("NZ");
        crane.newStack("DCM");
        crane.newStack("P");
    }

    @Test
    void it_computes_the_sequence() {
        assertThat(app.computeCrateSequence("/test.txt", crane)).isEqualTo("CMZ");
    }

}
