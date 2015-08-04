package easy;

public class MergeLists {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode newListPtr = null;
	        ListNode head = null;
	        if(l1 == null && l2 == null){
	            return null;
	        }else if(l1 == null){
	            return l2;
	        }else if(l2 == null){
	            return l1;
	        }else{
	            while(l1 !=null && l2!=null){
	                int valToCopy = -1;
	                if(l1.val <= l2.val){
	                    valToCopy = l1.val;
	                    l1 = l1.next;
	                }else if(l1.val > l2.val){
	                    valToCopy = l2.val;
	                    l2=l2.next;
	                }
	                ListNode newNode = new ListNode(valToCopy);
	                if(newListPtr==null){
	                    newListPtr = newNode;
	                    head = newListPtr;
	                }else{
	                    newListPtr.next = newNode;
	                    newListPtr = newListPtr.next;
	                }
	            }
	            ListNode remainingList = (l1==null)?l2:l1;
	            if(remainingList==null){
	                return head;
	            }else{
	                while(remainingList!=null){
	                    newListPtr.next = new ListNode(remainingList.val);
	                    newListPtr = newListPtr.next;
	                    remainingList = remainingList.next;
	                }
	            }
	            return head;
	        }
	    }
	 
	 public static void main(String[] arg){
		 ListNode l1 = new ListNode(98);
		 l1.next = new ListNode(100);
		 ListNode l2 = new ListNode(97);
		 l2.next = new ListNode(99);
		 l1.next.next = new ListNode(101);
		 ListNode result = new MergeLists().mergeTwoLists(l1, l2);
		 while(result!=null){
			 System.out.println(result.val);
			 result = result.next;
		 }
			 
	 }
}
