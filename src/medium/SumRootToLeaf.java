package medium;

import java.util.ArrayList;
import java.util.List;

import easy.TreeNode;

public class SumRootToLeaf {
	 public int sumNumbers(TreeNode root) {
	        if(root==null) {
	            return 0;
	        }
	        List<String> finalList = findSum(root);
	        long sum = 0;
	        for(String s: finalList){
	            sum+=Long.parseLong(s);
	        }
	        return (int)sum;
	    }
	    
	    public List<String> findSum(TreeNode node){
	        if(node==null){
	            return null;
	        }if(node.left==null && node.right==null){
	            List<String> leafList = new ArrayList<String>();
	            leafList.add(Integer.toString(node.val));
	            return leafList;
	        }
	        List<String> leftList = findSum(node.left);
	        List<String> rightList = findSum(node.right);
	        List<String> finalList = new ArrayList<String>();
	        if(leftList!=null){
	           for(String subString : leftList){
	            finalList.add(new StringBuilder().append(Integer.toString(node.val)).append(subString).toString());
	        } 
	        }
	        if(rightList!=null){
	            for(String subString : rightList){
	            finalList.add(new StringBuilder().append(Integer.toString(node.val)).append(subString).toString());
	        }
	        }
	        
	        return finalList;
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
	    	System.out.println(new SumRootToLeaf().sumNumbers(l2));
}
}
