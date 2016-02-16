package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOrder2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Map<Integer, List<Integer>> levelMap = new HashMap<Integer, List<Integer>>();
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		levelOrder(root, levelMap, 0);
		List<List<Integer>> vals = new ArrayList<List<Integer>>();
		vals.addAll(levelMap.values());
		return vals;
	}

	private void levelOrder(TreeNode root, Map<Integer, List<Integer>> levelMap, int level) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			List<Integer> list = levelMap.get(level);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(root.val);
			levelMap.put(level, list);
			return;
		}
		List<Integer> vals = levelMap.get(level);
		if (vals == null) {
			vals = new ArrayList<Integer>();
		}
		vals.add(root.val);
		levelMap.put(level, vals);
		levelOrder(root.left, levelMap, level + 1);
		levelOrder(root.right, levelMap, level + 1);
		return;
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
		List<List<Integer>> vals = new LevelOrder2().levelOrder(root);
		for (List<Integer> val : vals) {
			for (int val1 : val) {
				System.out.print(val1+" ");
			}
			System.out.println();
		}
	}
}
