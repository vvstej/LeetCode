package medium;
import easy.ListNode;
public class SwapNodes {

	 public ListNode swapPairs(ListNode head) {
		 if(head==null || head.next==null){
			 return head;
		 }
	        ListNode curr = head;
	        ListNode next = null;
	        ListNode prev = null;
	        while(true){
	        	if(prev!=null){
	        		curr = prev.next;
	        	}
	        	next = curr.next;
	        	if(next==null){
	        		break;
	        	}
	        	curr.next = next.next;
	        	next.next = curr;
	        	if(head==curr){
	        		head = next;
	        	}
	        	if(prev!=null){
	        		prev.next = next;
	        	}
	        	prev = curr;
	        	if(prev.next==null){
	        		break;
	        	}
	        }
	        return head;
	    }
	 
	 public static void main(String [] arg){
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		 ListNode n3 = new ListNode(3);
		 ListNode n4 = new ListNode(4);
		 ListNode n5 = new ListNode(5);
		 ListNode n6 = new ListNode(6);
		 n1.next = n2;
		 n2.next =  n3;
		 n3.next = n4;
		 n4.next = n5;
		 n5.next = n6;
		 ListNode val = new SwapNodes().swapPairs(n1);
		 while(val!=null){
			 System.out.println(val.val);
			 val = val.next;
		 }
	 }
}
