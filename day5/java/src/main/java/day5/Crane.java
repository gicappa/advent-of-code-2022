package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Crane {

    private final List<Stack<String>> stacks;
    private final CraneStrategy strategy;

    public static Crane newCrane9000() {
        return new Crane(new Crane9000Strategy());
    }

    public static Crane newCrane9001() {
        return new Crane(new Crane9001Strategy());
    }

    public Crane(CraneStrategy strategy) {
        stacks = new ArrayList<>();
        this.strategy = strategy;
    }

    public void newStack(String stackDefinition) {
        var stack = new Stack<String>();
        stack.addAll(crateList(stackDefinition));
        stacks.add(stack);
    }

    private List<String> crateList(String stackDefinition) {
        var definition = new StringBuffer(stackDefinition).reverse().toString();
        return Arrays.stream(definition.split("")).toList();
    }

    public Stack<String> get(int stackNumber) {
        assert stackNumber > 0;
        return stacks.get(stackNumber - 1);
    }

    public void move(int crateNumber, int from, int to) {
        strategy.move(crateNumber, get(from), get(to));
    }

    public String getCrateSequence() {
        return stacks.stream().map(Stack::pop).collect(Collectors.joining());
    }

    public Crane handle(Command cmd) {
        move(cmd.number(), cmd.from(), cmd.to());
        return this;
    }
}
