package easy;

import java.util.concurrent.BlockingQueue;

public class TreeNode {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + val;
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
		TreeNode other = (TreeNode) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (val != other.val)
			return false;
		return true;
	}

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
