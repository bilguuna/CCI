package bilguun.ariunbold.solutions.chapter8;

import java.util.HashSet;
import java.util.Set;

import bilguun.ariunbold.solutions.chapter4.TreeUtils.BinaryTreeNode;

/**
 * 
 * @author bilguuna
 *
 */

public class Q8_2_RobotInGrid {
	public static void main(String... args) {
		Set<Point> offLimits = new HashSet<>();
		offLimits.add(new Point(2, 1));
		offLimits.add(new Point(3, 3));
		offLimits.add(new Point(0, 4));
		offLimits.add(new Point(2, 4));

		Point corner = new Point(3, 5);
		BinaryTreeNode<Point> root = buildTree(null, 0, 0, corner, offLimits);
		System.out.println(findPath(root, corner, ""));
	}

	static BinaryTreeNode<Point> buildTree(BinaryTreeNode<Point> node, int rx, int cy, Point corner,
			Set<Point> offLimits) {
		if (rx > corner.x || cy > corner.y) {
			return null;
		}

		Point p = new Point(rx, cy);

		if (offLimits.contains(p)) {
			return null;
		}

		node = new BinaryTreeNode<>(p);

		node.setLeft(buildTree(null, rx + 1, cy, corner, offLimits));
		node.setRight(buildTree(null, rx, cy + 1, corner, offLimits));

		return node;

	}

	static String findPath(BinaryTreeNode<Point> node, Point corner, String path) {
		if (node == null) {
			return "";
		}

		node.setPath(String.format("%s -> (%d, %d)", path, node.getValue().x, node.getValue().y));
		if (corner.x == node.getValue().x && corner.y == node.getValue().y) {
			return node.getPath();
		}

		String left = findPath(node.getLeft(), corner, node.getPath());
		if (left != null && !left.isEmpty()) {
			return left;
		}

		String right = findPath(node.getRight(), corner, node.getPath());
		if (right != null && !right.isEmpty()) {
			return right;
		}

		return "";
	}

}

class Point {
	int x;
	int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
