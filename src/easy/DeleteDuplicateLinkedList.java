package easy;

public class DeleteDuplicateLinkedList {

	public ListNode deleteDuplicates(ListNode head){
		ListNode result = head;
		while(head!=null){
			ListNode curr = head;
			while(curr.next!=null && curr.val==curr.next.val){
				curr.next= curr.next.next;
			}
			head= head.next;
		}
		return result;
	}
	
	public static void main(String[] arg){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);		
		ListNode n5 = new ListNode(1);
		
		n1.next = n2;
		n1.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode result = new DeleteDuplicateLinkedList().deleteDuplicates(n1);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
