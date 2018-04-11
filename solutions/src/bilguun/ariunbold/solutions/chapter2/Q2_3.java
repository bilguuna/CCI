package bilguun.ariunbold.solutions.chapter2;

/**
 * @author bilguuna
 */
public class Q2_3 {
    public static void main(String... args) {
        int n = 9;
        Node head = Utils.initLinkedList(n);


        Node curr = head;
        for (int i = 0; i < n / 2; i++) {
            curr = curr.getNext();
        }

        System.out.println("Before removal: ");
        Utils.print(head);
        deleteNode(curr);
        System.out.println("After removal: ");
        Utils.print(head);
    }

    static boolean deleteNode(Node node) {
        if (node == null || node.getNext() == null) {
            return false;
        }

        Node next = node.getNext();
        node.setValue(next.getValue());
        node.setNext(next.getNext());

        return true;
    }
}
