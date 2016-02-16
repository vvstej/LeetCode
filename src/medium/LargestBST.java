package medium;

import easy.TreeNode;
import medium.ValidateBST.Result;

public class LargestBST {

	class Result {
		boolean isValid;
		int smallestNode;
		int largestNode;
		int nodes;
		int max;
	}

	public int largestBSTSubtree(TreeNode root) {
		return isValidBST1(root).max;
	}

	private Result isValidBST1(TreeNode root) {
		if (root == null) {
			Result r = new Result();
			r.isValid = true;
			r.smallestNode = Integer.MAX_VALUE;
			r.largestNode = Integer.MIN_VALUE;
			r.nodes = 0;
			return r;
		}
		if (root.left == null && root.right == null) {
			Result r = new Result();
			r.isValid = true;
			r.smallestNode = root.val;
			r.largestNode = root.val;
			if (r.max < 1) {
				r.max = 1;
			}
			r.nodes=1;
			return r;
		}
		Result isLeftValidBST = isValidBST1(root.left);
		Result isRightValidBST = isValidBST1(root.right);
		boolean isLeftValid = true;
		boolean isRightValid = true;
		if (isLeftValidBST.isValid) {
			if (root.left != null) {
				if (root.val > root.left.val && root.val > isLeftValidBST.largestNode) {
					isLeftValid = true;
				} else {
					isLeftValid = false;
				}
			}
		} else {
			isLeftValid = false;
		}
		if (isRightValidBST.isValid) {
			if (root.right != null) {
				if (root.val < root.right.val && root.val < isRightValidBST.smallestNode) {
					isRightValid = true;
				} else {
					isRightValid = false;
				}
			}
		} else {
			isRightValid = false;
		}
		Result r = new Result();
		r.smallestNode = Math.min(root.val,Math.min(isLeftValidBST.smallestNode, isRightValidBST.smallestNode));
		r.largestNode = Math.max(root.val,Math.max(isLeftValidBST.largestNode, isRightValidBST.largestNode));
		if (!isLeftValid || !isRightValid) {
			r.isValid = false;
			r.nodes = 0;
			r.max = Math.max(isLeftValidBST.max, isRightValidBST.max);
		} else {
			r.isValid = true;
			r.nodes = r.max=isLeftValidBST.nodes + isRightValidBST.nodes + 1;
			
		}
		return r;

	}


	public static void main(String[] arg) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(3);

		root.right = n1;
		n1.left = n2;
		n2.right = n3;
		n3.left = n4;
		System.out.println(new LargestBST().largestBSTSubtree(root));
	}
}
