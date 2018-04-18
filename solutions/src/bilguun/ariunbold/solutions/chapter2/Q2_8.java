package bilguun.ariunbold.solutions.chapter2;

/**
 * @author bilguuna
 */
public class Q2_8 {
    public static void main(String... args) {
        Node head = Utils.initLinkedList(11);

        Node node = head;
        Node loopBeginning = null;
        Node tail = null;
        int i = 1;
        while (node != null) {
            if (i == 4) {
                loopBeginning = node;
            }

            if (node.getNext() == null) {
                tail = node;
            }
            node = node.getNext();
            i++;
        }

        Utils.print(head);
        tail.setNext(loopBeginning);

        System.out.println("Beginning of the loop is: " + getLoopBegining(head).getValue());
    }

    static Node getLoopBegining(Node head) {
        Node fastR = head;
        Node slowR = head;

        while (fastR != null && fastR.getNext() != null) {
            slowR = slowR.getNext();
            fastR = fastR.getNext().getNext();

            if (slowR == fastR) {
                break; // they met, collision point
            }
        }

        if (fastR == null || fastR.getNext() == null) {
            return null;
        }

        fastR = head;

        while (slowR != fastR) {
            slowR = slowR.getNext();
            fastR = fastR.getNext();
        }

        return fastR;
    }
}
