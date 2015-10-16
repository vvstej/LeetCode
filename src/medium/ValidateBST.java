package medium;

import easy.TreeNode;

public class ValidateBST {
	
	class Result{
		boolean isValid;
		int smallestNode;
		int largestNode;
	}
	
	public Result isValidBST1(TreeNode root){
		if(root==null){
			Result r = new Result();
			r.isValid = true;
			r.smallestNode = Integer.MAX_VALUE;
			r.largestNode = Integer.MIN_VALUE;
            return r;
        }
        if(root.left==null && root.right==null){
        	Result r = new Result();
			r.isValid = true;
			r.smallestNode = root.val;
			r.largestNode = root.val;
            return r;
        }
        Result isLeftValidBST = isValidBST1(root.left);
        Result isRightValidBST = isValidBST1(root.right);
        boolean isLeftValid = true;
        boolean isRightValid = true;
        if(isLeftValidBST.isValid){
            if(root.left!=null){
                if(root.val > root.left.val && root.val > isLeftValidBST.largestNode){
                    isLeftValid = true;
                }else{
                    isLeftValid = false;
                }
            }
        }else{
        	isLeftValid = false;
        }
        if(isRightValidBST.isValid){
             if(root.right!=null){
                if(root.val < root.right.val && root.val > isLeftValidBST.smallestNode){
                    isRightValid = true;
                }else{
                    isRightValid =  false;
                }
            }
        }else{
        	isRightValid =  false;
        }
        
        if(!isLeftValid || !isRightValid){
        	Result r = new Result();
        	r.isValid = false;
			r.smallestNode = Integer.MAX_VALUE;
			r.largestNode = Integer.MIN_VALUE;
        }
		return isRightValidBST;
        
        
		
	}

    public boolean isValidBST(TreeNode root) {
		return false;
    	
        
    }
    public static void main(String[] arg){
    	TreeNode root = new TreeNode(10);
    	TreeNode l1 = new TreeNode(5);
    	TreeNode l2 = new TreeNode(15);
    	l1.left=null;
    	l1.right=null;
    	
    	TreeNode l4 = new TreeNode(3);
    }
}
