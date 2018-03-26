package ik;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSortLL {
	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
		if (head == null) {
			head = new LinkedListNode(val);
			tail = head;
		} else {
			tail.next = new LinkedListNode(val);
			tail = tail.next;
		}
		return tail;
	}

	static LinkedListNode mergeSortList(LinkedListNode pList) {
		int startCount = 1;
		;
		LinkedListNode temp = pList;
		LinkedListNode ret = new LinkedListNode(Integer.MAX_VALUE);
		int totalCount = 0;
		while (temp != null) {
			temp = temp.next;
			++totalCount;
		}

		while (startCount <= totalCount) {
			temp = pList;
			List<LinkedListNode> markerNodes = new ArrayList<>();
			int currCount = 0;
			while (temp != null) {
				if (currCount % startCount == 0) {
					markerNodes.add(temp);
				}
				temp = temp.next;
				++currCount;
			}
			for (int i = 1; i < markerNodes.size(); i += 2) {
				merge(markerNodes.get(i - 1), i >= markerNodes.size() ? null : markerNodes.get(i), ret, startCount);
			}
			startCount *= 2;


		}
		return ret.next;
	}

	private static void merge(LinkedListNode l1, LinkedListNode l2, LinkedListNode ret, int startCount) {
		LinkedListNode l2Temp = l2;
		int currCount = 0;
		while (currCount < startCount && l2 != null) {
			if (l1.val <= l2.val) {
				ret.next = l1;
				l1 = l1.next;

			} else {
				ret.next = l2;
				l2 = l2.next;
			}
			ret = ret.next;
			currCount++;
		}
		while (currCount != startCount) {
			ret.next = l1;
			l1 = l1.next;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		LinkedListNode res;

		int _pList_size = 0;
		_pList_size = Integer.parseInt(in.nextLine());
		int _pList_i;
		int _pList_item;
		LinkedListNode _pList = null;
		LinkedListNode _pList_tail = null;
		for (_pList_i = 0; _pList_i < _pList_size; _pList_i++) {
			_pList_item = Integer.parseInt(in.nextLine().trim());
			if (_pList_i == 0) {
				_pList = _insert_node_into_singlylinkedlist(_pList, _pList_tail, _pList_item);
				_pList_tail = _pList;
			} else {
				_pList_tail = _insert_node_into_singlylinkedlist(_pList, _pList_tail, _pList_item);
			}
		}

		res = mergeSortList(_pList);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
}