package easy;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode node){
		boolean result = false;
		if(node==null){
			result =  true;
		}else{
			result = calculateBalance(node).isBalanced;
		}
		return result;
		
	}

	private TreeBalanceResult calculateBalance(TreeNode node) {
		if(node.left == null && node.right == null){
			return new TreeBalanceResult(true,0);
		}else{
			int lheight = 0;
			int rheight = 0;
			int currHeight = 0;
			boolean isLeftBalanced = false;
			boolean isRightBalanced = false;
			TreeBalanceResult r = null;
			if(node.left==null){
				r = calculateBalance(node.right);
				isLeftBalanced = true;
				isRightBalanced = r.isBalanced;
				rheight = r.height + 1;
			}else if(node.right==null){
				r = calculateBalance(node.left);
				isRightBalanced = true;
				isLeftBalanced = r.isBalanced;
				lheight = r.height + 1;
			}else{
				r = calculateBalance(node.left);
				lheight = r.height + 1;
				isLeftBalanced = r.isBalanced;
				r = calculateBalance(node.right);
				rheight = r.height + 1;				
				isRightBalanced = r.isBalanced;
			}
			currHeight = (rheight > lheight) ? rheight : lheight;
			r.height = currHeight;
			if(isLeftBalanced && isRightBalanced){
				if(Math.abs(lheight-rheight) <=1 ){
					r.isBalanced = true;
				}else{
					r.isBalanced = false;
				}
			}else{
				r.isBalanced = false;
			}
			return r;
			
		}
	}
	
	public static void main(String[] arg){
		TreeNode node1 = new TreeNode(10);
		node1.left = new TreeNode(20);
		node1.left.left = new TreeNode(30);
		node1.right = new TreeNode(40);
		System.out.println(new BalancedBinaryTree().isBalanced(node1));
	}
	
}

class TreeBalanceResult{
	public TreeBalanceResult(boolean b, int i) {
		this.height = i;
		this.isBalanced = b;
	}
	boolean isBalanced;
	int height;
}
