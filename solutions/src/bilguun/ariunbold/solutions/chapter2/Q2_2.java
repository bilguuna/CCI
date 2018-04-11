package bilguun.ariunbold.solutions.chapter2;

/**
 * @author bilguuna
 */

public class Q2_2 {
    public static void main(String[] args) {
        Node<Integer> head = Utils.initLinkedList(20);
        Utils.print(head);
        int k = 6;
        moveToLast(head, k);
        System.out.println("AFTER MOVING " + k + "th ELEMENT: ");
        Utils.print(head);
    }

    static void moveToLast(Node<Integer> node, int k) {
        int i = 1;
        Node<Integer> currNode = node;
        Node kthNode = null;

        if(k == 1) {
            kthNode = node;
        }

        while(currNode.getNext() != null) {
            i++;

            if(i == k) {
                kthNode = currNode.getNext();
                currNode.setNext(currNode.getNext().getNext());
                kthNode.setNext(null);
            }

            currNode = currNode.getNext();
        }

        currNode.setNext(kthNode);
    }
}
