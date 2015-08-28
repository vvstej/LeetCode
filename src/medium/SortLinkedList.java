package medium;

import easy.ListNode;

public class SortLinkedList {
public ListNode sortList(ListNode head){
	if(head==null || head.next==null){
		return head;
	}
	int count = 0;
	ListNode c = head;
	while(c!=null){
		count++;
		c = c.next;
	}
	ListNode curr = head;
	ListNode next = null;
	while(curr!=null){
		if(curr.next!=null){
			next = curr.next.next;
		}else{
			next = null;
		}
		if(curr.next!=null && (curr.next.val < curr.val)){
			int temp = curr.val;
			curr.val = curr.next.val;
			curr.next.val = temp;
		}
		curr = next;
	}
	// log n merges
	
	for(int i=2;i<count;i*=2){
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		int currCount = 0;
		ListNode ptr2Prev = null;
		while(currCount<i){
			ptr2Prev = ptr2;
			ptr2=ptr2.next;
			currCount++;
		}
		currCount = 0;
		//merge logic
		ListNode ptr1Prev = null;
		head = ptr1;
		while(ptr1!=null && ptr2!=null && ptr1!=ptr2 && currCount < i*2){
			if(ptr1.val > ptr2.val){
				int val2 = ptr2.val;
				ListNode tempNode = null;
				if(ptr2.next!=null){
					tempNode = ptr2.next;
					ptr2.val = ptr2.next.val;
					ptr2.next = ptr2.next.next;
					int val1 = ptr1.val;
					ListNode tempNode2 = ptr1.next;
					ptr1.val = val2;
					tempNode.val = val1;
					ptr1.next = tempNode;
					tempNode.next = tempNode2;					
				}else{
					ptr2.next = ptr1;
					ptr1= ptr2;
					ptr2Prev.next = null;
					if(ptr1Prev==null){
						head = ptr1;
					}
					if(ptr1Prev!=null)
					ptr1Prev.next = ptr1;
					ptr2=null;
				}	
								
				ptr1Prev = ptr1;
				ptr1= ptr1.next; //(since ptr1 now became 2 we move to 5)	
			}else{
				ptr1Prev = ptr1;
				ptr1= ptr1.next;
			}
			currCount++;
			//ptr1Prev = ptr1;
			//ptr2Prev = ptr2;
		}
	}
	
	return head;
	
}
/**
 * 1 - 5 , 2-3
 * In the above example 5 and 2 have to be swapped with no additional memory 
 * The idea is the node with value2 should get 3, the node with 3 gets 2, and that node is unhooked
 * The unhooked node becomes ptr1 and ptr1.next should be node with value 5
 * @param ptr1
 * @param ptr2
 * @param ptr2Prev 
 * @param ptr22 
 */

public static void main(String[] arg){
	ListNode l1 = new ListNode(5);
	SortLinkedList list = new SortLinkedList();
	ListNode result = list.sortList(l1);
	while(result!=null){
		System.out.println(result.val);
		result= result.next;
	}
	ListNode l2 = new ListNode(4);
	l1.next = l2;
	list = new SortLinkedList();
	result = list.sortList(l1);
	while(result!=null){
		System.out.println(result.val);
		result= result.next;
	}
	System.out.println();
	l1 = new ListNode(4);
	l2 = new ListNode(19);
	ListNode l3 = new ListNode(14);
	ListNode l4 = new ListNode(5);
	ListNode l5 = new ListNode(-3);
	ListNode l6 = new ListNode(1);
	ListNode l7 = new ListNode(8);
	ListNode l8 = new ListNode(5);
	ListNode l9 = new ListNode(11);
	ListNode l10 = new ListNode(15);
	l2.next = l3;
	l1.next= l2;
	l3.next = l4;
	l5.next = l6;
	l4.next = l5;
	l6.next = l7;
	l7.next = l8;
	l8.next = l9;
	l9.next = l10;
	list = new SortLinkedList();
	result = list.sortList(l1);
	while(result!=null){
		System.out.println(result.val);
		result= result.next;
	}
}
}
