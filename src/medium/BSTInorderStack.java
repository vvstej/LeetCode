package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import easy.TreeNode;

public class BSTInorderStack {
	public List<Integer> inorderTraversal(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}

		stack.push(root);
		while (!stack.isEmpty()) {
			if (stack.peekFirst().left == null) {
				if (stack.peekFirst().right == null) {
					ret.add(stack.pop().val);
				}
				while (!stack.isEmpty()) {
					TreeNode elem = stack.pop();
					ret.add(elem.val);
					if (elem.right == null) {
						continue;
					} else {
						stack.push(elem.right);
						break;
					}
				}
			} else {
				stack.push(stack.peekFirst().left);
			}
		}
		return ret;
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		left.left = new TreeNode(1);
		root.left = left;
		List<Integer> ret = new BSTInorderStack().inorderTraversal(root);
		ret.stream().forEach((val) -> System.out.println(val));
	}

}
