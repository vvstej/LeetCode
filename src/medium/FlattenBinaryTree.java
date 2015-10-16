package medium;

import easy.TreeNode;

public class FlattenBinaryTree {
	public void flatten(TreeNode root) {
		if(root==null){
			return;
		}
        recursiveFlatten(root);
    }
    
    public void recursiveFlatten(TreeNode node){
        if(isLeaf(node)){
            return;
        }
        if(node.right!=null && isLeaf(node.right) && node.left==null){
            return;
        }
        if(node.left!=null && isLeaf(node.left) && node.right==null){
            node.right = node.left;
            node.left = null;
            return;
        }
        if(node.left!=null && isLeaf(node.left) && node.right!=null && isLeaf(node.right)){
            node.left.right = node.right;
            node.right = node.left;
            node.left = null;
            return;
        }
        if(node.left!=null){
        	recursiveFlatten(node.left);
        }
        
        if(node.right!=null){
        	recursiveFlatten(node.right);
        }
        
        TreeNode temp  = node.left;
        if(temp!=null){
        	while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
    }

	private boolean isLeaf(TreeNode node) {
		if(node!=null && node.left==null && node.right==null){
			return true;
		}
		return false;
	}
	
	public static void main(String[] arg){
		TreeNode node  = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		node.left = n1;
		TreeNode n2 = new TreeNode(3);
		n1.right = n2;
		TreeNode n3 = new TreeNode(4);
		n2.left  = n3;
		FlattenBinaryTree bTree = new FlattenBinaryTree();
		bTree.flatten(node);
		while(node!=null){
			System.out.println(node.val);
			node = node.right;
		}
		
	}
}
