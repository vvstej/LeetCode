package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import easy.TreeNode;

public class PreOrderIterative {
	public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            List<Integer> resultList = new ArrayList<Integer>();
            resultList.add(root.val);
        }
        Deque<TreeNode> preOrderStack = new ArrayDeque<TreeNode>();
        List<Integer> resultList = new ArrayList<Integer>();
        TreeNode current = root;
        preOrderStack.push(current);
        resultList.add(current.val);
        while(!preOrderStack.isEmpty()){
            while(current!=null){
            current = current.left;
            if(current!=null){
                resultList.add(current.val);
                preOrderStack.push(current);
            }
            
        }
           TreeNode leftLeaf = preOrderStack.pop();
           if(leftLeaf.right!=null){
               resultList.add(leftLeaf.right.val);
               preOrderStack.push(leftLeaf.right);
               current = leftLeaf.right;
           }else{
        	   if(!preOrderStack.isEmpty()){
        		   TreeNode grandParent = preOrderStack.pop();
                   current = grandParent.right;
                   resultList.add(current.val);
                   preOrderStack.push(current);
        	   }
               
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
		node.right = n3;
		n1.right = n2;
		node.left = n1;
		PreOrderIterative solution = new PreOrderIterative();
		List<Integer> result = solution.preorderTraversal(node);
		for(int val : result){
			System.out.println(val);
		}
		
		
	}
}
