package easy;

public class IntersectionLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		int lenHeadA = 0;
		int lenHeadb = 0;
		ListNode temp1 = headA;
		ListNode temp2 = headB;
		while(temp1!=null){
			lenHeadA++;
			temp1 = temp1.next;
		}
		while(temp2!=null){
			lenHeadb++;
			temp2 = temp2.next;
		}
		int diff = Math.abs(lenHeadA-lenHeadb);
		if(lenHeadA > lenHeadb){
			for(int i=0;i<diff;i++){
				headA = headA.next;
			}
		}else if(lenHeadb > lenHeadA){
			for(int i=0;i<diff;i++){
				headB = headB.next;
			}
		}
		boolean prevResultFound = false;
		ListNode possibleIntersectionNode = null;
		while(headA!=null && headB!=null){
			if(headA==headB){
				if(!prevResultFound){
					possibleIntersectionNode = headA;
				}
				prevResultFound = true;
			}else{
				if(prevResultFound){
					possibleIntersectionNode = null;
					prevResultFound = false;
				}
				
			}
			headA = headA.next;
			headB = headB.next;
		}
		return possibleIntersectionNode;		
	}
	
	public static void main(String [] arg){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(100);
		ListNode n4 = new ListNode(101);
		ListNode n5 = new ListNode(102);
		ListNode n6 = new ListNode(10);
		ListNode n7 = new ListNode(11);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n6.next = n7;
		n7.next = n3;
		ListNode result = new IntersectionLinkedList().getIntersectionNode(n1, n6);
		if(result!=null){
			System.out.println(result.val);
		}
	}
}
