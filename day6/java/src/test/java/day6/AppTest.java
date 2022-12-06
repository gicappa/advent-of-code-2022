package day6;

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
    void it_finds_the_marker() {
        assertThat(app.findPacketMarkerPosition("mjqjpqmgbljsphdztnvjfqwrcgsmlb")).isEqualTo(7);
        assertThat(app.findPacketMarkerPosition("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(5);
        assertThat(app.findPacketMarkerPosition("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(6);
        assertThat(app.findPacketMarkerPosition("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(10);
        assertThat(app.findPacketMarkerPosition("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(11);
    }

    @Test
    void it_finds_the_message_marker() {
        assertThat(app.findMessageMarkerPosition("mjqjpqmgbljsphdztnvjfqwrcgsmlb")).isEqualTo(19);
        assertThat(app.findMessageMarkerPosition("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(23);
        assertThat(app.findMessageMarkerPosition("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(23);
        assertThat(app.findMessageMarkerPosition("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(29);
        assertThat(app.findMessageMarkerPosition("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(26);
    }

    @Test
    void it_check_for_repeated_chars() {
        assertThat(app.checkRepeatedChars("abca")).isTrue();
    }

    @Test
    void it_check_for_not_repeated_chars() {
        assertThat(app.checkRepeatedChars("abcd")).isFalse();
    }

    @Test
    void it_returns_the_position_at_the_end_of_the_marker() {
        assertThat(app.checkRepeatedChars("abcd")).isFalse();
    }
}
