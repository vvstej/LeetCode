package medium;

import easy.ListNode;

public class ReverseList {

	ListNode head = null;
	public ListNode reverse(ListNode prev, ListNode curr){
		if(curr==null){
			ListNode head = prev;
			return head;
		}
		ListNode head = reverse(curr,curr.next);
		curr.next = prev;
		return head;
	}
	
	public ListNode reverse1(ListNode node){
		if(node.next==null){
			head = node;
			return node;
		}
		ListNode curr = node;
		ListNode prev = reverse1(node.next);
		//curr.next = curr;
		prev.next = curr;
		curr.next = null;
		return curr;
	}
	
	public ListNode reverse2(ListNode node){
		ListNode prev = null;
		ListNode curr = node;
		ListNode head = null;
		while(curr!=null){
			if(curr.next==null) {
				head = curr;
			}
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr= temp;
		}
		return head;
	}
	
	public ListNode reverse3(ListNode n){
		  if (n != null && n.next != null) {
			  ListNode head = reverse3(n.next);
		        n.next.next = n;
		        n.next = null;
		        return head;
		    }
		    return n;
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
//		head = new ReverseList().reverse(null, n1);
//		while(head!=null){
//			System.out.println(head.val);
//			head = head.next;
//		}
		ListNode result = new ReverseList().reverse(null,n1);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
		//System.out.println(result.val);
	}
}
class ResultNode {
	ListNode head;
	ListNode curr;
	
}
