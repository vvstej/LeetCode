package medium;

import easy.TreeNode;

public class CountFullNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		return left + right + 1;
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		root.left = n1;
		TreeNode n2 = new TreeNode(3);
		n1.right = n2;
		TreeNode n3 = new TreeNode(4);
		n2.left = n3;
		System.out.println(new CountFullNodes().countNodes(root));
	}
}
