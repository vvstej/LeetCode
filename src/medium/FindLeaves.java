package medium;

import java.util.ArrayList;
import java.util.List;

import easy.TreeNode;

public class FindLeaves {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        while(!isLeaf(root)) {
            List<Integer> leaves = new ArrayList<Integer>();
            recursivelySolve(root, leaves);
            all.add(leaves);
        }
        List<Integer> rootLeaf = new ArrayList<Integer>();
        rootLeaf.add(root.val);
        all.add(rootLeaf);
        return all;
    }
    
    private void recursivelySolve(TreeNode root, List<Integer> leaves) {
        if(root.left!=null) {
            if(isLeaf(root.left)) {
                leaves.add(root.left.val);
                root.left = null;
            }else{
                recursivelySolve(root.left, leaves);
            }
        }
        if(root.right!=null) {
            if(isLeaf(root.right)) {
                leaves.add(root.right.val);
                root.right = null;
            }else{
                recursivelySolve(root.right, leaves);
            } 
        }  
    }
    
    private boolean isLeaf(TreeNode node) {
        return node!=null && node.left==null && node.right==null;
    }
    
    public static void main(String[] arg){
    	TreeNode root = new TreeNode(1);
    	TreeNode r2 = new TreeNode(2);
    	TreeNode r3 = new TreeNode(3);
    	TreeNode r4 = new TreeNode(4);
    	TreeNode r5= new TreeNode(5);
    	
    	root.left = r2;
    	root.right = r3;
    	r2.left = r4;
    	r2.right = r5;
    	new FindLeaves().findLeaves(root);
    }
}
