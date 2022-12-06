package day5;

import java.util.Stack;

public class Crane9001Strategy implements CraneStrategy {

    @Override
    public void move(int number, Stack<String> fromStack, Stack<String> toStack) {
        if (number == 0) {
            return;
        }
        var stackFromSize = fromStack.size();

        for (int i = stackFromSize - number; i < stackFromSize; i++) {
            var element = fromStack.get(i);
            toStack.push(element);
        }
        for (int i = stackFromSize - number; i < stackFromSize; i++) {
            fromStack.pop();
        }
    }
}
