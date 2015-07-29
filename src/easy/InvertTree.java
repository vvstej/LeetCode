package easy;

public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		} else if (root.left == null && root.right == null) {
			return root;
		} else {
			invertTree(root.left);
			invertTree(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}

	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(4);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(7);

		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(6);
		n5.left = new TreeNode(5);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(8);
		n6.left = n7;
		TreeNode n8 = new TreeNode(40);
		TreeNode n9 = new TreeNode(23);
		TreeNode n10 = new TreeNode(37);
		n8.left = n9;
		n8.right = n10;
		n6.right = n8;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		root.left = n1;
		root.right = n2;
		new InvertTree().invertTree(root);
		TreeNode.inOrderTraversal(root);
	}

}
