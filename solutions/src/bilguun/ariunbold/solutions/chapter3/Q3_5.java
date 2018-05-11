package bilguun.ariunbold.solutions.chapter3;

import java.util.Stack;

/**
 * @author bilguuna
 */

public class Q3_5 {
    public static void main(String... args) {
        SortedStack stack = new SortedStack();
        stack.push(14);
        stack.push(13);
        stack.push(20);
        stack.push(1);
        stack.push(113);
        stack.push(2);
        stack.push(4);
        stack.push(33);
        stack.push(6);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}

class SortedStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmpStack = new Stack<>();

    public void push(Integer value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            Integer head = stack.peek();
            if (head >= value) {
                stack.push(value);
            } else {
                while (head < value && !stack.isEmpty()) {
                    tmpStack.push(stack.pop());

                    if (stack.isEmpty()) {
                        break;
                    }
                    head = stack.peek();
                }
                stack.push(value);
                moveBackStacks();
            }
        }
    }

    public Integer peek() {
        return stack.peek();
    }

    public Integer pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    private void moveBackStacks() {
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }
}
