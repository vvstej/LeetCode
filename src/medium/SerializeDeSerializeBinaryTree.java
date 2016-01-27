package medium;

import java.util.LinkedList;
import java.util.Queue;

import easy.TreeNode;

public class SerializeDeSerializeBinaryTree {

	public String serialize(TreeNode root) {
		int height = height(root);
		int blownOutTreeNodes = (int) Math.pow(2, height + 1) - 1;
		StringBuilder serializedString = new StringBuilder();
		Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
		bfsQueue.add(root);
		while (!bfsQueue.isEmpty()) {
			TreeNode node = bfsQueue.remove();
			blownOutTreeNodes--;
			if (blownOutTreeNodes >= 0) {
				if (node == null) {
					serializedString.append("null");
					serializedString.append(",");
					bfsQueue.add(null);
					bfsQueue.add(null);
				} else {
					serializedString.append(node.val);
					serializedString.append(",");
					bfsQueue.add(node.left);
					bfsQueue.add(node.right);
				}
			}

		}
		return serializedString.substring(0, serializedString.length() - 1).toString();
	}

	private int height(TreeNode root) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
	}

	public TreeNode deserialize(String data) {
		return unpack(data.split(","), 0);

	}

	private TreeNode unpack(String[] data, int index) {
		if (2 * index + 1 >= data.length) {
			String s = data[index];
			if (s.equals("null")) {
				return null;
			} else {
				return new TreeNode(Integer.parseInt(s));
			}

		}
		if (!data[index].equals("null")) {
			TreeNode left = unpack(data, 2 * index + 1);
			TreeNode right = unpack(data, 2 * index + 2);
			TreeNode curr = new TreeNode(Integer.parseInt(data[index]));
			curr.left = left;
			curr.right = right;
			return curr;
		}else
			return null;

	}
	
	private String inOrder(TreeNode root) {
		if(root==null){
			return "";
		}
		String curr = Integer.toString(root.val);
		String left = inOrder(root.left);
		String right = inOrder(root.right);
		return new StringBuilder(left).append(",").append(curr).append(",").append(right).toString();
	}

	public static void main(String[] arg) {
		TreeNode node = new TreeNode(1);
//		TreeNode n1 = new TreeNode(2);
//		node.left = n1;
//		TreeNode n2 = new TreeNode(3);
//		n1.right = n2;
//		TreeNode n3 = new TreeNode(4);
//		n2.left = n3;
		String data = new SerializeDeSerializeBinaryTree().serialize(node);
		TreeNode result = new SerializeDeSerializeBinaryTree().deserialize(data);
		System.out.println(new SerializeDeSerializeBinaryTree().inOrder(result));
	}

}
