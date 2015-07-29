package easy;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head){
		ListNode tail = head;
		Result result = recursiveFind(tail,head);
		return (result.result)?true:false;
	}

	private Result recursiveFind(ListNode tail, ListNode head) {
		if(tail==null){
			return new Result(head,true);
		}
		Result result = recursiveFind(tail.next, head);
		if(result.isTerminated){
			return result;
		}else{
			if(tail==result.modifiedHead || tail.next==result.modifiedHead){
				result.isTerminated = true;
				return result;
			}
			if(result.result){
				if(tail.val!=result.modifiedHead.val){
					result.modifiedHead = null;
					result.result = false;
					result.isTerminated = true;
					return result;
				}else{
					result.modifiedHead = result.modifiedHead.next;
					result.result = true;
					result.isTerminated = false;
					return result;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] arg){
		ListNode l1 = new ListNode(10);
		ListNode l2 = new ListNode(20);
		ListNode l3 = new ListNode(20);
		ListNode l4 = new ListNode(10);
		ListNode l5 = new ListNode(30);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(new PalindromeLinkedList().isPalindrome(l1));
	}
}

class Result{
	public Result(ListNode head, boolean b) {
		this.modifiedHead = head;
		this.result = b;
	}
	ListNode modifiedHead;
	boolean result;
	boolean isTerminated;
	
}