package easy;

public class DeleteNode {

	public void deleteNode(ListNode node){
		if(node.next==null){
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String [] arg){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		new DeleteNode().deleteNode(n2);
		ListNode head = n1;
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
