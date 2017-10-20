package medium;

import easy.ListNode;

public class LinkedListPalindrome {

	public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        if(head.next == null) return false;
        ListNode dup = head;
        ListNode ret = rp(head, dup);
        return ret!=null;
    }
    
    private static ListNode rp(ListNode backward, ListNode head) {
        if(backward.next == null) {
            return backward.val == head.val ? head.next : null;
        }
        ListNode forward = rp(backward.next, head);
        if(forward==null) return null;
        else{
            return backward.val == forward.val ? (forward.next==null ? forward : forward.next) : null;
        }
        
    }
    
    public static void main(String[] arg){
    	ListNode head = new ListNode(0);
    	ListNode first = new ListNode(1);
    	ListNode second = new ListNode(2);
    	ListNode third = new ListNode(1);
    	ListNode fourth = new ListNode (0);
    	head.next = first;
    	first.next = second;
    	second.next = third;
    	third.next = fourth;
    	System.out.print(new LinkedListPalindrome().isPalindrome(head));
    }
}
