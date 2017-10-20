package medium;

import easy.TreeNode;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode newRoot = findNewRoot(root);
        return newRoot;
    }
    
    private TreeNode findNewRoot(TreeNode root) {
        if(root.left == null) {
            TreeNode newRoot = root;
            return newRoot;
        }
        TreeNode newRoot = findNewRoot(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
            
    }
    
    public static void main(String[] arg){
    	BinaryTreeUpsideDown up = new BinaryTreeUpsideDown();
    	TreeNode root = new TreeNode(1);
    	TreeNode r2 = new TreeNode(2);
    	TreeNode r3 = new TreeNode(3);
    	TreeNode r4 = new TreeNode(4);
    	TreeNode r5= new TreeNode(5);
    	
    	root.left = r2;
    	root.right = r3;
    	r2.left = r4;
    	r2.right = r5;
    	up.upsideDownBinaryTree(root);
    }
}
