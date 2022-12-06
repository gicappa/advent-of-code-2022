package day5;

import java.util.Stack;

@FunctionalInterface
public interface CraneStrategy {
    void move(int number, Stack<String> fromStack, Stack<String> toStack);
}
