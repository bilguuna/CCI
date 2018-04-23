package bilguun.ariunbold.solutions.chapter3;

import bilguun.ariunbold.solutions.chapter2.Node;

import java.util.Stack;

/**
 * @author bilguuna
 */

public class Q3_2 {
    public static void main(String... args) {
        BStack bStack = new BStack();
        bStack.push(53);
        bStack.push(12);
        bStack.push(5);
        bStack.push(2);
        bStack.push(11);

//        while (!bStack.isEmpty()) {
//            System.out.println(bStack.pop());
//        }

        System.out.println(bStack.pop() + " has been removed");
        System.out.println(bStack.pop() + " has been removed");
        System.out.println("-----------");
        System.out.print("MIN: ");
        Integer min = bStack.min();
        if (min == null) {
            System.out.print("EMPTY;");
        } else {
            System.out.print(min);
        }
        System.out.println("");
    }
}

class BStack extends Stack<Integer> {
    private Stack<Integer> minsStack = new Stack<>();

    public void push(int n) {
        if (n < min()) {
            minsStack.push(n);
        }

        super.push(n);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minsStack.pop();
        }

        return value;
    }

    public int min() {
        if (minsStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minsStack.peek();
        }
    }
}
