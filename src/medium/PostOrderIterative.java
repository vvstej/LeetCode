package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import easy.TreeNode;

public class PostOrderIterative {
	public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            List<Integer> resultList = new ArrayList<Integer>();
            return resultList;
        }
        if(root.left==null && root.right==null){
            List<Integer> resultList = new ArrayList<Integer>();
            resultList.add(root.val);
        }
        Deque<TreeNode> postOrderStack = new ArrayDeque<TreeNode>();
        List<Integer> resultList = new ArrayList<Integer>();
        TreeNode current = root;
        postOrderStack.push(current.right);
        postOrderStack.push(current);
        //resultList.add(current.val);
        while(!postOrderStack.isEmpty()){
            while(current!=null){
            current = current.left;
            if(current!=null){
            	if(current.right!=null)
            		postOrderStack.push(current.right);
                postOrderStack.push(current);
            }
            
        }
           TreeNode leftLeaf = postOrderStack.pop();
           //resultList.add(leftLeaf.val);
           if(leftLeaf.right!=null && leftLeaf.right==postOrderStack.peek()){
                   //resultList.add(leftLeaf.right.val);
        		   TreeNode right = postOrderStack.pop();
        		   postOrderStack.push(leftLeaf);
        		   current = right;
        		   
        	   
           }else{
        	   resultList.add(leftLeaf.val);
               current = null;
           }          
           
        }
		return resultList;
    }
        
	public static void main(String[] arg){
		TreeNode node = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(7);
		n5.right = n6;
		n3.right = n5;
		n3.left = n4;
		node.left = n3;
		n1.right = n2;
		node.right = n1;
		PostOrderIterative solution = new PostOrderIterative();
		List<Integer> result = solution.postorderTraversal(node);
		for(int val : result){
			System.out.println(val);
		}
		
		
	}
}
