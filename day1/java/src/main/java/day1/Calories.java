package day1;

import java.util.List;
import java.util.Stack;

public class Calories {

    private final Stack<Integer> summary;

    public Calories() {
        summary = new Stack<>();
        newSummary();
    }

    public Calories newSummary() {
        summary.push(0);
        return this;
    }

    public List<Integer> getSummaryList() {
        return summary;
    }

    public Calories add(int calories) {
        summary.push(summary.pop() + calories);
        return this;
    }

    public Calories add(Calories other) {
        summary.addAll(other.getSummaryList());
        return this;
    }
}
