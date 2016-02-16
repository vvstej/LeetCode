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
                if(root.val < root.right.val && root.val < isRightValidBST.smallestNode){
                    isRightValid = true;
                }else{
                    isRightValid =  false;
                }
            }
        }else{
        	isRightValid =  false;
        }
        Result r = new Result();
        if(!isLeftValid || !isRightValid){     	
        	r.isValid = false;
			r.smallestNode = Integer.MAX_VALUE;
			r.largestNode = Integer.MIN_VALUE;
        }
        else{
        	r.isValid = true;
        	r.smallestNode = isLeftValidBST.smallestNode;
        	r.largestNode = isRightValidBST.largestNode;
        }
		return r;
        
        
		
	}

    public boolean isValidBST(TreeNode root) {
		return isValidBST1(root).isValid;
    	
        
    }
    public static void main(String[] arg){
    	TreeNode root = new TreeNode(10);
    	TreeNode n1 = new TreeNode(5);
    	TreeNode n2 = new TreeNode(15);
    	TreeNode n3 = new TreeNode(1);
    	TreeNode n4 = new TreeNode(8);
    	TreeNode n5 = new TreeNode(7);
    	root.left = n1;
    	root.right = n2;
    	n1.left = n3;
    	n1.right = n4;
    	n2.left = n5;
    	System.out.println(new ValidateBST().isValidBST(root));
    }
}
