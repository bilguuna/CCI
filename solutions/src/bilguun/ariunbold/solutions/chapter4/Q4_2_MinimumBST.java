package bilguun.ariunbold.solutions.chapter4;

import bilguun.ariunbold.solutions.chapter4.TreeUtils.BinaryTreeNode;

/**
 * @author bilguuna
 */

public class Q4_2_MinimumBST {
    public static void main(String... args) {
        int[] arr = {2, 4, 6, 7, 12, 30, 60};
        BinaryTreeNode<Integer> root = buildMinBst(arr, 0, arr.length - 1);

        TreeUtils.bfs(root);

    }

    static BinaryTreeNode<Integer> buildMinBst(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[mid]);

        node.setLeft(buildMinBst(arr, start, mid - 1));
        node.setRight(buildMinBst(arr, mid + 1, end));

        return node;

    }
}
