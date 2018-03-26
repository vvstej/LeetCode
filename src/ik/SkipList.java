package ik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList {
	private ListNode head;
	private int maxLevel;
	private int size;

	private static final double PROB = 0.5;
	private static final Random r = new Random();

	public SkipList() {
		size = 0;
		maxLevel = 1;
		head = new ListNode(Integer.MIN_VALUE);
		head.getNextNodes().add(null);

	}

	public void add(int elem) {
		if (contains(elem))
			return;
		size++;
		int level = 1;
		while (Math.random() < PROB) {
			level++;
		}
		
		while (level > maxLevel) {
			head.getNextNodes().add(null);
			maxLevel++;
		}
		
		ListNode newNode = new ListNode(elem);
		for(int l=level-1;l>=0;l--) {
			newNode.getNextNodes().add(null);
		}
		
		ListNode curr = head;
		// insert the new node into the skip list
		do {
			curr = findNextNode(elem, curr, level-1);
			newNode.getNextNodes().add(level-1, curr.getNextNodes().get(level-1));
			curr.getNextNodes().set(level-1, newNode);
		} while (--level > 1);
		return;
	}

	private ListNode findNextNode(int elem, ListNode curr, int level) {
		ListNode next = curr.getNextNodes().get(level);
		while (next != null) {
			if (elem < next.getVal())
				break;
			curr = next;
			next = (level >= curr.getNextNodes().size()) ? null : curr.getNextNodes().get(level);
		}
		return curr;
	}

	
	public boolean contains(int elem) {
		ListNode curr = this.head;
		for(int i = maxLevel-1;i>=0;i--) {
			for(;curr.getNextNodes().get(i)!=null; curr=curr.getNextNodes().get(i)) {
				if(curr.getNextNodes().get(i).getVal() > elem) break;
				if(curr.getNextNodes().get(i).getVal() == elem) return true;
			}
		}
		return false;
	}

	public static void main(String[] arg) {
		SkipList testList = new SkipList();
		testList.add(4);
		testList.add(45);
		System.out.println(testList.contains(45));
		System.out.println(testList.contains(46));
		System.out.println(testList.contains(4));
	}
}

class ListNode {
	private int val;
	private List<ListNode> nextNodes;
	int level;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public List<ListNode> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(List<ListNode> nextNodes) {
		this.nextNodes = nextNodes;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ListNode(final int val) {
		this.val = val;
		nextNodes = new ArrayList<ListNode>();
	}

}
