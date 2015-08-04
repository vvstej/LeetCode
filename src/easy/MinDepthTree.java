package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinDepthTree {

	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		Queue<TreeNodeWithDepth> queue = new LinkedList<TreeNodeWithDepth>();
		queue.add(new TreeNodeWithDepth(root, 1));
		while(!queue.isEmpty()){
			TreeNodeWithDepth elem = queue.remove();
			if(elem.t.left == null && elem.t.right == null){
				return elem.depth;
			}
			if(elem.t.left!=null){
				queue.add(new TreeNodeWithDepth(elem.t.left, elem.depth+1));
			}
			if(elem.t.right!=null){
				queue.add(new TreeNodeWithDepth(elem.t.right, elem.depth+1));
			}			
		}
		return 0;

	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		//root.right = new TreeNode(15);
		//root.right.left = new TreeNode(13);
		//root.right.right = new TreeNode(88);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(54);
		System.out.println(new MinDepthTree().minDepth(root));
	}

}

class TreeNodeWithDepth {
	TreeNode t;
	int depth;

	public TreeNodeWithDepth(TreeNode t, int depth) {
		this.t = t;
		this.depth = depth;
	}
}
