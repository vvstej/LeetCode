package easy;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
	
	public static void inOrderTraversal(TreeNode node){
		if(node == null){
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.val);
		inOrderTraversal(node.right);
	}
}
