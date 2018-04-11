package bilguun.ariunbold.solutions.chapter2;

/**
 * @author bilguuna
 */

public class Q2_2 {
    public static void main(String[] args) {
        Node<Integer> head = Utils.initLinkedList(20);
        Utils.print(head);
        int k = 4;
        System.out.println(k + "th to the last is : " + getKth(head, k).getValue());
        System.out.println(k + "th to the last is(2 pointers) : " + getKthByTwoPointers(head, k).getValue());
        getKthRecursively(head, k);

    }

    static int getKthRecursively(Node node, int k) {
        if (node == null) {
            return 0;
        }

        int index = getKthRecursively(node.getNext(), k) + 1;
        if (index == k) {
            System.out.println(k + "th to the last is(Recursively) : " + node.getValue());
        }

        return index;
    }


    static Node getKth(Node node, int k) {
        Node curr = node;
        int length = 0;

        while (curr != null) {
            curr = curr.getNext();
            length++;
        }

        if (k > length) {
            return null;
        }

        curr = node;
        int i = 0;

        while (curr != null && i < (length - k)) {
            if (i == (length - k)) {
                return curr;
            }
            curr = curr.getNext();
            i++;
        }

        return curr;
    }

    static Node getKthByTwoPointers(Node node, int k) {
        Node p1 = node;
        Node p2 = node;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }

            p1 = p1.getNext();
        }

        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p2;
    }
}
