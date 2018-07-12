package bilguun.ariunbold.solutions.chapter4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author bilguuna
 */

public class TreeUtils {
    public void printBinaryTree(BinaryTreeNode root) {

    }

    public static void bfs(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();

            System.out.println(node.getValue());
            BinaryTreeNode left = node.getLeft();
            BinaryTreeNode right = node.getRight();

            if(left != null) {
                queue.add(left);
            }

            if(right != null) {
                queue.add(right);
            }
        }
    }
}

class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
