package day4;

import java.util.Objects;

public class Section {

    private final Integer start;
    private final Integer end;
    // "23-43"
    public Section(String range) {
        start = Integer.valueOf(range.split("-")[0]);
        end = Integer.valueOf(range.split("-")[1]);
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Section section = (Section) o;
        return Objects.equals(start, section.start) && Objects.equals(end,
            section.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
