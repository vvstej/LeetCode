package medium;

import easy.TreeNode;

public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	       if(root == null) {
	           return null;
	       }
			return recursiveLCA(root, p, q).lca;
		}
	    
	    private Status recursiveLCA(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null) {
	            return new Status(false,false,null);
	        }
	        Status fromLeft = recursiveLCA(root.left, p, q);
	        if(fromLeft.isPFound && fromLeft.isQFound) {
	            return fromLeft;
	        }
	        if(root==p){
	            if(fromLeft.isQFound) {
	                return new Status(true, true, root);
	            }
	        }else if(root == q) {
	            if(fromLeft.isPFound) {
	                return new Status(true, true, root);
	            }
	        }
	        Status fromRight = recursiveLCA(root.right, p,q);
	        if(fromRight.isPFound && fromRight.isQFound) {
	            return fromRight;
	        }
	        if(root==p){
	            if(fromRight.isQFound) {
	                return new Status(true, true, root);
	            }
	        }else if(root == q) {
	            if(fromRight.isPFound) {
	                return new Status(true, true, root);
	            }
	        }
	        if((fromLeft.isPFound && fromRight.isQFound) || (fromLeft.isQFound && fromRight.isPFound)) {
	            return new Status(true, true, root);
	        }
	        boolean isPFound = fromLeft.isPFound || fromRight.isPFound || root==p;
	        boolean isQFound = fromRight.isQFound || fromRight.isQFound || root==q;
	        return new Status(isPFound, isQFound, null);
	    }
	    
	    public static void main(String [] arg){
	    	TreeNode root = new TreeNode(1);
	    	TreeNode two = new TreeNode(2);
	    	TreeNode three = new TreeNode(3);
	    	TreeNode four = new TreeNode(4);
	    	root.left = two;
	    	root.right = three;
	    	two.left = null;
	    	two.right = four;
	    	System.out.println(new LCA().lowestCommonAncestor(root, four, root).val);
	    }
}
class Status {
    boolean isPFound;
    boolean isQFound;
    TreeNode lca;
    Status(boolean isPFound, boolean isQFound, TreeNode lca) {
        this.isPFound = isPFound;
        this.isQFound = isQFound;
        this.lca = lca;
    }
}
