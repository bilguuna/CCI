package bilguun.ariunbold.solutions.chapter2;

/**
 * @author bilguuna
 */
public class Q2_6 {
    public static void main(String... args) {
        Node head = null;
        Node node = null;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                node = new Node(0);
                head = node;
            } else {
                node.setNext(new Node(i));
                node = node.getNext();
            }
        }

        for (int i = 3; i >= 0; i--) {
            node.setNext(new Node(i));
            node = node.getNext();
        }

        Utils.print(head);

        int length = Utils.lengthOfLinkedList(head);
        System.out.println("Is Palindrom (recursively): " + isPalindromeRecurse(head, length).result);
    }


    static Result isPalindromeRecurse(Node<Integer> node, int length) {
        if (node == null || length <= 0) {
            return new Result(true, node);
        } else if (length == 1) {
            return new Result(true, node.getNext());
        }

        Result res = isPalindromeRecurse(node.getNext(), length - 2);

        // if it's already false in inner calls
        if (!res.result) {
            return res;
        }

        if (res.node.getValue().intValue() == node.getValue().intValue()) {
            res.result = true;
        } else {
            res.result = false;
        }

        res.node = res.node.getNext();

        return res;
    }


}

class Result {
    public boolean result;
    public Node<Integer> node;

    public Result() {
    }

    public Result(boolean result, Node node) {
        this.result = result;
        this.node = node;
    }
}
