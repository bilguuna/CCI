package bilguun.ariunbold.solutions.chapter3;

import java.util.Stack;

/**
 * @author bilguuna
 */

public class Q3_3 {
    public static void main(String... args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        setOfStacks.print();

    }
}

class SetOfStacks {

    Stack<Stack> setOfStacks = new Stack<>();
    int currSize = 0;
    int max = 0;

    public SetOfStacks(int max) {
        this.max = max;
    }

    public void push(Integer n) {
        if (currSize >= max || setOfStacks.isEmpty()) {
            setOfStacks.push(new Stack());
            currSize = 0;
        }

        Stack headStack = setOfStacks.pop();
        headStack.push(n);
        setOfStacks.push(headStack);
        currSize++;
    }

    public Integer pop() {
        if (setOfStacks.isEmpty()) {
            return null;
        }

        Stack<Integer> headStack = setOfStacks.pop();
        if (headStack.isEmpty()) {
            headStack = setOfStacks.pop();
            currSize = max;
        }

        if (setOfStacks.isEmpty()) {
            return null;
        }

        int r = headStack.pop();
        setOfStacks.push(headStack);

        currSize--;

        return r;
    }

    public void print() {
        while (!setOfStacks.isEmpty()) {
            System.out.println("Outer element:----");
            Stack<Integer> headStack = setOfStacks.pop();
            while (!headStack.isEmpty()) {
                Integer val = headStack.pop();
                System.out.print(val + ", ");
            }

        }
    }

}
