package easy;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> ancestorList1 = new ArrayList<TreeNode>();
		List<TreeNode> ancestorList2 = new ArrayList<TreeNode>();
		boolean found1 = inOrderTraversal(root, p.val, ancestorList1);
		boolean found2 = inOrderTraversal(root, q.val, ancestorList2);
		if (!found1 || !found2) {
			return null;
		}
		for (TreeNode node : ancestorList1) {
			if (node.val == q.val) {
				return q;
			}
		}

		for (TreeNode node : ancestorList2) {
			if (node.val == p.val) {
				return p;
			}
		}
		int firstIndex = 0;
		int secondIndex = 0;
		int size = 0;
		if(ancestorList1.size() > ancestorList2.size()){
			firstIndex = ancestorList1.size() - ancestorList2.size();
			size = ancestorList2.size();
		}
		
		else if(ancestorList2.size() > ancestorList1.size()){
			secondIndex = ancestorList2.size() - ancestorList1.size();
			size = ancestorList1.size();
		}else{
			size = ancestorList1.size();
		}
		for(int i=0;i<size;i++){
			if(ancestorList2.get(secondIndex) ==  ancestorList1.get(firstIndex)){
				return ancestorList1.get(firstIndex);
			}
			firstIndex++;
			secondIndex++;
		}
		return null;
	}

	public static boolean inOrderTraversal(TreeNode node, int target,
			List<TreeNode> ancestorList) {
		if (node == null) {
			return false;
		}
		if (node.val == target) {
			return true;
		} else {
			boolean found = inOrderTraversal(node.left, target, ancestorList);
			if (!found) {
				found = inOrderTraversal(node.right, target, ancestorList);
				if (!found) {
					return false;
				} else {
					ancestorList.add(node);
					return true;
				}
			} else {
				ancestorList.add(node);
				return true;
			}
		}

	}
	
	public static void main(String[] arg){
		TreeNode root = new TreeNode(4);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(7);

		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(6);
		n5.left = new TreeNode(5);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(8);
		n6.left = n7;
		TreeNode n8 = new TreeNode(40);
		TreeNode n9 = new TreeNode(23);
		TreeNode n10 = new TreeNode(37);
		n8.left = n9;
		n8.right = n10;
		n6.right = n8;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		root.left = n1;
		root.right = n2;
		TreeNode result = new LeastCommonAncestor().lowestCommonAncestor(root, n9, n4);
		if(result!=null){
			System.out.println(result.val);
		}
	}
}
