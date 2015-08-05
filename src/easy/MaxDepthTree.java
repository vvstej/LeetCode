package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthTree {

	public int maxDepth(TreeNode root) {
		int maxDepth = Integer.MIN_VALUE;
		if(root==null){
			return 0;
		}
		Deque<TreeNodeWithDepth> stack = new ArrayDeque<TreeNodeWithDepth>();
		stack.push(new TreeNodeWithDepth(root, 1));
		while(!stack.isEmpty()){
			TreeNodeWithDepth elem = stack.pop();
			if(elem.t.left == null && elem.t.right == null){
				if(elem.depth > maxDepth){
					maxDepth = elem.depth;
				}
			}
			if(elem.t.left!=null){
				stack.push(new TreeNodeWithDepth(elem.t.left, elem.depth+1));
			}
			if(elem.t.right!=null){
				stack.push(new TreeNodeWithDepth(elem.t.right, elem.depth+1));
			}			
		}
		return maxDepth;

	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(88);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(54);
		System.out.println(new MaxDepthTree().maxDepth(root));
	}

}

