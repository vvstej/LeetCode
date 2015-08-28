package medium;

import java.util.ArrayList;
import java.util.List;

import easy.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return isSymmertic(root.left, root.right);        
    }
    
    private boolean isSymmertic(TreeNode left, TreeNode right) {
		if(left==null && right==null){
			return true;
		}
		if(left==null || right==null){
			return false;
		}
		if(left.val!=right.val){
			return false;
		}
		return isSymmertic(left.left, right.right) && isSymmertic(left.right, right.left);
		
	}    
    public static void main(String[] arg){
    	TreeNode root = new TreeNode(1);
    	TreeNode l1 = new TreeNode(2);
    	TreeNode l2 = new TreeNode(2);
    	TreeNode l3 = new TreeNode(3);
    	TreeNode l4 = new TreeNode(3);
    	l1.left = null;
    	l1.right = l3;
    	l2.left = l4;
    	l2.right = null;
    	root.left = l1;
    	root.right = l2;
    	System.out.println(new SymmetricTree().isSymmetric(root));
    	
    	
    }
}
