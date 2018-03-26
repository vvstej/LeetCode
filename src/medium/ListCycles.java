package medium;

import easy.ListNode;

public class ListCycles {

	private static boolean findCycles(ListNode list) {
		ListNode slow = list;
		ListNode fast = list.next;
		while(fast!=null && fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
			if(fast == slow) {
				countNodes(slow);
				return true;
			}
		}
		return false;

	}

	private static int countNodes(ListNode p1) {
		ListNode p2 = p1;
		p2 = p2.next;
		int count = 1;
		while(p2!=p1) {
			p2 = p2.next;
			count++;
		}
		return count;
		
	}
	
	
}
