package easy;

import java.util.concurrent.BlockingQueue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.val);
		inOrderTraversal(node.right);
	}

	public static void main(String[] arg) {
		N<Integer> root = null;
		insert(5, root);
		
	}

	private static <T extends Comparable<T>> N<T> insert(T i, N<T> root) {
		if (root == null) {
			N<T> root1 = new N<T>(i);
			return root1;
		}
		if (root.val.compareTo(i) < 0) {
			return insert(i, root.right);
		} else {
			return insert(i, root.left);
		}

	}
}

class N<T> {
	public T val;
	public N<T> left;
	public N<T> right;

	public N(T x) {
		this.val = x;
	}
}
