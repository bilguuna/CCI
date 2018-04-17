package bilguun.ariunbold.solutions.chapter2;

import java.util.Stack;

import static bilguun.ariunbold.solutions.chapter2.Utils.*;

public class Q2_7 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.setNext(n2);
        Node n3 = new Node(3);
        n2.setNext(n3);
        Node n4 = new Node(4);
        n3.setNext(n4);
        Node n5 = new Node(5);
        n4.setNext(n5);

        Node n21 = new Node(11);
        Node n22 = new Node(22);
        n21.setNext(n22);
        Node n33 = new Node(33);
        n22.setNext(n33);
        Node n44 = new Node(44);
        n33.setNext(n44);
        n44.setNext(n3);

        print(n1);
        print(n21);

        System.out.println("Intersection: ");
        Node inter = getInterNode(n1, n21);

        if (inter == null) {
            System.out.println("No intersection found");
        } else {
            System.out.println(inter.getValue());
        }
    }

    static Node getInterNode(Node node1, Node node2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                s1.push(node1);
                node1 = node1.getNext();
            }

            if (node2 != null) {
                s2.push(node2);
                node2 = node2.getNext();
            }
        }

        Node r = null;

        while (!s1.empty() && !s2.empty()) {
            node1 = s1.pop();
            node2 = s2.pop();

            if (node1 != node2) {
                return r;
            } else {
                r = node1;
            }
        }

        return r;
    }
}
