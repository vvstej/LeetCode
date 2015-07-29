package easy;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head){
		if(head==null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		ListNode temp = null;
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while(curr!=null){
			prev = curr;
			curr = curr.next;
			if(curr==null){
				prev.next = temp;
				temp = prev;
				continue;
			}
			next = curr.next;
			curr.next = prev;
			prev.next = temp;
			temp = curr;
			curr = next;
		}
		return temp;
		
	}
	
	public static void main(String[] arg){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode l2 = head.next;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		ListNode l6 = new ListNode(12);
		l5.next = l6;
		ListNode reverseList = new ReverseLinkedList().reverseList(head);
		while(reverseList!=null){
			System.out.println(reverseList.val);
			reverseList = reverseList.next;
		}
	}
	
}


