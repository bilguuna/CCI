package bilguun.ariunbold.solutions.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bilguuna
 */

public class TreeUtils {
	public <T> void printBinaryTree(BinaryTreeNode<T> root) {

	}

	public static <T> void bfs(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}

		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.poll();

			System.out.println(node.getValue());
			BinaryTreeNode<T> left = node.getLeft();
			BinaryTreeNode<T> right = node.getRight();

			if (left != null) {
				queue.add(left);
			}

			if (right != null) {
				queue.add(right);
			}
		}
	}

	public static class BinaryTreeNode<T> {
		private T value;
		private BinaryTreeNode<T> left;
		private BinaryTreeNode<T> right;
		private int level;
		private String path;

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

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	}
}
