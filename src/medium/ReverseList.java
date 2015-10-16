package medium;

import easy.ListNode;

public class ReverseList {

	public ListNode reverse(ListNode prev, ListNode curr){
		if(curr==null){
			ListNode head = prev;
			return head;
		}
		ListNode head = reverse(curr,curr.next);
		curr.next = prev;
		return head;
	}
	
	public static void main(String[] arg){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;
		ListNode head = n1;
		head = new ReverseList().reverse(null, n1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
