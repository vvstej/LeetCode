package ik;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BSTtoLL {
	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int value) {
			this.val = value;
		}
	}

	static Node createTree(String data) {
		if (data == null || data.length() == 0)
			return null;
		StringTokenizer st = new StringTokenizer(data, " ");
		return deserialize(st);
	}

	static Node deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens())
			return null;
		String s = st.nextToken();
		if (s.equals("#"))
			return null;
		Node root = new Node(Integer.valueOf(s));
		root.left = deserialize(st);
		root.right = deserialize(st);

		return root;
	}

	/*
	 * Complete the function below.
	 */

	static void BSTtoLL(Node root) {
		Node dummyHead = new Node(Integer.MIN_VALUE);
		Node dummyTail = new Node(Integer.MAX_VALUE);
		BSTtoLLHelper(root, dummyHead, dummyTail);
		Node head = dummyHead.right;
		Node tail = dummyTail.left;
		head.left = tail;
		tail.left = head;
		Node ptr = head;
		while(ptr!=tail) {
			System.out.print(ptr.val + " ");
			ptr = ptr.right;
		}
	}

	private static void BSTtoLLHelper(Node root, Node pLeft, Node pRight) {
		if (root == null)
			return;
		Node left = root.left;
		Node right = root.right;
		if (root.left == null) {
			root.left = pLeft;
			pLeft.right = root;
		} else {
			BSTtoLLHelper(left, pLeft, root);
		}
		if (root.right == null) {
			root.right = pRight;
			pRight.left = root;
		} else {
			BSTtoLLHelper(right, root, pRight);
		}
		return;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _size;
		_size = Integer.parseInt(in.nextLine().trim());

		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}

		Node n = createTree(_str);
		BSTtoLL(n);

	}
}