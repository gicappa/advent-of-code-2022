package day5;

import java.util.Stack;

public class Crane9000Strategy implements CraneStrategy {

    @Override
    public void move(int number, Stack<String> fromStack, Stack<String> toStack) {
        if (number == 0) {
            return;
        }

        for (int i = 0; i < number; i++) {
            var element = fromStack.pop();
            toStack.push(element);
        }
    }
}
