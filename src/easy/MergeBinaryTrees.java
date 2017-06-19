package easy;

public class MergeBinaryTrees {
    public TreeNode mergeTrees(final TreeNode t1, final TreeNode t2) {
        final TreeNode result = null;
        recursiveMerge(t1, t2, result);
        return result;

    }

    private void recursiveMerge(final TreeNode t1, final TreeNode t2, TreeNode newTree) {
        if (t1 == null && t2 == null) {
            return;
        }
        if (t1 == null) {
            newTree = new TreeNode(t2.val);
            recursiveMerge(null, t2.left, newTree.left);
            recursiveMerge(null, t2.right, newTree.right);
        } else if (t2 == null) {
            newTree = new TreeNode(t1.val);
            recursiveMerge(t1.left, null, newTree.left);
            recursiveMerge(t1.right, null, newTree.right);
        } else {
            newTree = new TreeNode(t1.val + t2.val);
            recursiveMerge(t1.left, t2.left, newTree.left);
            recursiveMerge(t1.right, t2.right, newTree.right);
        }
    }
    
    public static void main(final String [] arg) {
        final TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        
        final TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        new MergeBinaryTrees().mergeTrees(t1, t2);
        
    }
}
