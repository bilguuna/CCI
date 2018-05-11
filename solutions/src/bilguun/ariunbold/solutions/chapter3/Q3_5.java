package bilguun.ariunbold.solutions.chapter3;

import java.util.Stack;

/**
 * @author bilguuna
 */

public class Q3_5 {
    public static void main(String... args) {
        Stack stack = new Stack();
        stack.push(14);
        stack.push(13);
        stack.push(20);
        stack.push(1);
        stack.push(113);
        stack.push(2);
        stack.push(4);
        stack.push(33);
        stack.push(6);

        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void sort(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<>();

        while (!stack.isEmpty()) {
            if (tmpStack.isEmpty()) {
                tmpStack.push(stack.pop());
            } else {
                Integer tmp = stack.pop();
                while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                    stack.push(tmpStack.pop());
                }

                tmpStack.push(tmp);
            }
        }

        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
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
                while (!stack.isEmpty() && stack.peek() < value) {
                    tmpStack.push(stack.pop());
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
