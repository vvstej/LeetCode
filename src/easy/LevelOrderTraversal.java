package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root){
		
		Map<Integer,List<Integer>> levelMap = new HashMap<Integer,List<Integer>>();
		if(root==null){
			return new ArrayList<List<Integer>>();
		}
		Queue<TreeNodeWithDepth> queue = new LinkedList<TreeNodeWithDepth>();
		TreeNodeWithDepth rootWithDepth = new TreeNodeWithDepth(root, 1);
		queue.add(rootWithDepth);
		while(!queue.isEmpty()){
			TreeNodeWithDepth node = queue.remove();
			List<Integer> nthLevelList = levelMap.get(node.depth);
			if(nthLevelList==null){
				nthLevelList = new ArrayList<Integer>();
			}
			nthLevelList.add(node.t.val);
			levelMap.put(node.depth, nthLevelList);
			if(node.t.left!=null){
				queue.add(new TreeNodeWithDepth(node.t.left, node.depth+1));
			}
			if(node.t.right!=null){
				queue.add(new TreeNodeWithDepth(node.t.right, node.depth+1));
			}
		}
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		resultList.addAll(levelMap.values());
		return resultList;
	}
	
	public static void levelOrder1(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(node!=null){
			queue.add(node);
			queue.add(null);
		}
		while(!queue.isEmpty()){
			TreeNode curr = queue.remove();
			if(curr==null) {
				System.out.println("");
				continue;
			}
			System.out.print(curr.val+" ");
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
				
		}
	}
	
	public static void invert(TreeNode node) {
		if(node==null) {
			return;
		}
		invert(node.left);
		invert(node.right);
		TreeNode leftTemp = node.left;
		node.left = node.right;
		node.right = leftTemp;
		return;
	}
	
	public static void copyLeft(TreeNode node) {
		if(node==null)
			return;
		copyLeft(node.left);
		copyLeft(node.right);
		TreeNode newNode = new TreeNode(node.val);
		newNode.left = node.left;
		newNode.right = node.right;
		node.left = newNode;
	}
	
	public static void main(String[] arg){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(88);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(54);
		for(List<Integer> list : new LevelOrderTraversal().levelOrder(root)){
			for(Integer i : list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
