package bilguun.ariunbold.solutions.chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import bilguun.ariunbold.solutions.chapter4.TreeUtils.BinaryTreeNode;

/**
 * 
 * @author bilguuna
 *
 */

public class Q4_3_ListOfDepths {
	public static void main(String... args) {
		int[] arr = { 2, 4, 6, 7, 12, 30, 60 };
		BinaryTreeNode<Integer> root = Q4_2_MinimumBST.buildMinBst(arr, 0, arr.length - 1);

		List<LinkedList<Integer>> linkedLists = buildListOfDepths(root);

		linkedLists.forEach(list -> {
			System.out.println(//
					list.stream() //
							.map(node -> node.toString())//
							.collect(Collectors.joining("->"))//
			);
		});
	}

	static List<LinkedList<Integer>> buildListOfDepths(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

		Map<Integer, LinkedList<Integer>> r = new HashMap<>();

		root.setLevel(1);
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();

			LinkedList<Integer> linkedList = r.get(node.getLevel());
			if (linkedList == null) {
				linkedList = new LinkedList<>();
			}

			linkedList.add(node.getValue());

			r.put(node.getLevel(), linkedList);

			BinaryTreeNode<Integer> left = node.getLeft();
			if (left != null) {
				left.setLevel(node.getLevel() + 1);
				queue.add(left);
			}

			BinaryTreeNode<Integer> right = node.getRight();
			if (right != null) {
				right.setLevel(node.getLevel() + 1);
				queue.add(right);
			}
		}

		return r.values().stream() //
				.collect(Collectors.toList());

	}

}
