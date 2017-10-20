package medium;

import easy.ListNode;

public class LinkedListRemoveDuplicates {

	public static ListNode deleteDuplicates(ListNode head) {
        // initialize to dummy node
        ListNode dummyNode = new ListNode(0);
        ListNode prev = dummyNode;
        ListNode curr = head;
        while(curr!=null && curr.next!=null) {
            if(curr.val == curr.next.val) {
               while(curr.next!=null && curr.val==curr.next.val) {
                curr=curr.next;
                }
                curr = curr.next;
                //prev.next = curr.next;
            }else{
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            
        }
        if(curr!=null){
        	prev.next = curr;
        }
        return dummyNode.next;
    }
	
	public static void main(String[] arg) {
		ListNode head = new ListNode(2);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(1);
		ListNode fourth = new ListNode(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		ListNode result = LinkedListRemoveDuplicates.deleteDuplicates(head);
		System.out.println(result.val);
		
	}
}
