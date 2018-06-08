package bilguun.ariunbold.solutions.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bilguuna
 */

public class GraphTraversal {
    public static void main(String... args) {
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeS = new Node<>("s");
        Node<String> nodeZ = new Node<>("z");
        Node<String> nodeX = new Node<>("x");
        Node<String> nodeD = new Node<>("d");
        Node<String> nodeC = new Node<>("c");
        Node<String> nodeV = new Node<>("v");
        Node<String> nodeF = new Node<>("f");

        // Connecting the graph
        nodeA.getNeighbors().addAll(Arrays.asList(nodeS, nodeZ));
        nodeZ.getNeighbors().add(nodeA);

        nodeS.getNeighbors().addAll(Arrays.asList(nodeA, nodeX));
        nodeX.getNeighbors().addAll(Arrays.asList(nodeS, nodeD, nodeC));

        nodeD.getNeighbors().addAll(Arrays.asList(nodeX, nodeF));
        nodeC.getNeighbors().addAll(Arrays.asList(nodeX, nodeF, nodeV));

        nodeF.getNeighbors().addAll(Arrays.asList(nodeD, nodeC, nodeV));

        nodeV.getNeighbors().addAll(Arrays.asList(nodeF, nodeC));

        traverseBfs(nodeS);
    }

    static void traverseBfs(Node<String> root) {
        root.setLevel(0);
        int level = 1;

        List<Node<String>> frontiers = new ArrayList<>();
        frontiers.add(root);

        while (!frontiers.isEmpty()) {
            System.out.println("level " + level + " nodes: ");
            List<Node<String>> next = new ArrayList<>();

            for (Node<String> frontier :
                    frontiers) {
                for (Node<String> neighbor :
                        frontier.getNeighbors()) {
                    if (neighbor.getLevel() == null) {
                        neighbor.setLevel(level);
                        next.add(neighbor);
                        System.out.println(neighbor.getValue());
                    }
                }
            }
            frontiers = next;
            level++;
        }
    }

}

class Node<T> {
    T value;
    List<Node<T>> neighbors = new ArrayList<>();
    Integer level;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
