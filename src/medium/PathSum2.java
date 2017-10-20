package medium;

import java.util.ArrayList;
import java.util.List;

import easy.TreeNode;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        pathSumHelper(root, ret, curr, 0, sum);
        return ret;
    }
    
    private void pathSumHelper(TreeNode root, List<List<Integer>> ret, List<Integer> curr, int currSum, int targetSum) {
        if(root==null) return;
        if(root.left == null && root.right == null) {
            if(root.val+currSum == targetSum) {
                curr.add(root.val);
                ret.add(curr);
            }
        }
        curr.add(root.val);
        List<Integer> forLeft = new ArrayList(curr);
        List<Integer> forRight = new ArrayList(curr);
        pathSumHelper(root.left, ret, forLeft, root.val+currSum, targetSum);
        pathSumHelper(root.right, ret, forRight, root.val+currSum, targetSum);
    }
    
}
