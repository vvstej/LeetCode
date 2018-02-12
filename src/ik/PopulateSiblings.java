package ik;

import java.io.*;
import java.util.*;

public class PopulateSiblings {
	static class Node {
		int val;
		Node left;
		Node right;
		Node next;

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

	/**
	 * Traverse previous level and stitch lower level, Since previous level is
	 * already stitched. Move on to next level.
	 **/
	private static void populateSibilingPtrs(Node root) {
		Node prevLevelPtr = root;
		Node currLevelPtr = new Node(Integer.MIN_VALUE);
		while (prevLevelPtr != null) {
			Node stitchPtr = currLevelPtr;
			while (prevLevelPtr != null) {
				if (prevLevelPtr.left != null) {
					stitchPtr.next = prevLevelPtr.left;
					stitchPtr = stitchPtr.next;
				}
				if (prevLevelPtr.right != null) {
					stitchPtr.next = prevLevelPtr.right;
					stitchPtr = stitchPtr.next;
				}
				prevLevelPtr = prevLevelPtr.next;
			}
			prevLevelPtr = currLevelPtr.next;
			currLevelPtr.next = null;
		}
	}

	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.val + " Next: " + (root.next != null ? root.next.val : "null"));
		printInorder(root.right);
	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
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
		populateSibilingPtrs(n);
		printInorder(n);
	}
}