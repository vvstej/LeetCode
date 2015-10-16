package medium;

import easy.TreeNode;

public class MulthiThreadedTreeTraversal extends Thread{

	TreeNode curr;
	int result;
	String resultString;
	public MulthiThreadedTreeTraversal(TreeNode node) {
		this.curr = node;
	}
	@Override
	public void run(){
		if(curr==null){
			result=-1;
			this.resultString="#";
			return;
		}
		MulthiThreadedTreeTraversal left = new MulthiThreadedTreeTraversal(this.curr.left);
		left.start();
		MulthiThreadedTreeTraversal right = new MulthiThreadedTreeTraversal(this.curr.right);
		right.start();
		try {
			left.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			right.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.resultString = left.resultString + ";" + Integer.toString(curr.val) + ";" + right.resultString;	
	}
	
	public static void main(String[] arg) throws InterruptedException{
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(2);
	    node3.left = node4;
		node1.left = node3;
		node1.right = node2;
		MulthiThreadedTreeTraversal  t = new MulthiThreadedTreeTraversal(node1);
		t.start();
		t.join();
		System.out.println(t.resultString);
	}
}
