package hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import easy.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length==0){
    		return null;
    	}
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        ListNode result = null;
        ListNode finalResult = result;
        for(ListNode list: lists){
            minHeap.offer(list);
        }     
        while(!minHeap.isEmpty()){
        	ListNode nextLeast = minHeap.poll();
        	if(result==null){
        		result = new ListNode(nextLeast.val);
        		finalResult = result;
        	}
        	else{
        		result.next = new ListNode(nextLeast.val);
        		result = result.next;
        	}
            if(nextLeast.next!=null){
                minHeap.offer(nextLeast.next);   
            }
            else{
                if(minHeap.isEmpty()){
                    break;
                }
                while(true){
                    nextLeast = minHeap.poll();
                    if(nextLeast!=null || minHeap.isEmpty()) break;
                }
                if(nextLeast!=null){
                    result.next = new ListNode(nextLeast.val);
                    result = result.next;
                    if(nextLeast.next!=null){
                        minHeap.offer(nextLeast.next);
                    }
                }
              }
        }
		return finalResult;       
    }
    
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists==null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, (l1, l2) -> l1.val - l2.val);
        for(int i=0;i<lists.length;i++) {
            minHeap.offer(lists[i]);
        }
        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            result.next = min;
            result = result.next;
            if(result.next==null) continue;
            else{
                minHeap.offer(result.next);
            }
        }
		return dummy.next;
    }
    
    public static void main(String[] arg){
    	ListNode l1 = new ListNode(30);
    	ListNode l2 = new ListNode(60);
    	l1.next = l2;
    	l2.next = new ListNode(80);
    	ListNode l3 = new ListNode(20);
    	ListNode l4 = new ListNode(40);
    	l3.next = l4;
    	ListNode l5 = new ListNode(10);
    	ListNode l6 = new ListNode(50);
    	l5.next = l6;
    	l6.next = new ListNode(70);
    	ListNode [] lists = new ListNode[]{l1,l3,l5,new ListNode(1)};
    	ListNode list = new MergeKLists().mergeKLists1(lists);
    	while(list!=null){
    		System.out.println(list.val);
    		list = list.next;
    	}
    }
}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode l1, ListNode l2 ){
        if(l1==null && l2==null){
            return 0;
        }else if(l1==null){
            return -1;
        }else if(l2 == null){
            return 1;
        }else if(l1==l2){
            return 0;
        }else{
            if(l1.val == l2.val){
                return 0;
            }else if(l1.val < l2.val){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
