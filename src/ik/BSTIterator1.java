package ik;

import java.io.*;
import java.util.*;

public class BSTIterator1 {
	public static void main(String args[]) throws Exception {
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
		BSTIterator iterator = new BSTIterator(n);
		while (iterator.hasNext1()) {
			Node node = iterator.next1();
			System.out.println(node.val);
		}
	}

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

	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	static class BSTIterator implements Iterator<Node> {
		private final Stack<Node> stack = new Stack<Node>();
		private Node prev;

		/**
		 * Initialize the iterator with the root, which involves pushing onto
		 * the stack. And traverse to the left most node of the tree by pushing
		 * nodes onto the stack.
		 **/
		public BSTIterator(Node root) {
			this.prev = null;
			if (root != null) {
				stack.push(root);
				traverseToMin(root);
			}
		}

		/**
		 * Helper function to traverse to the left most node of any given
		 * subtree rooted at 'root'
		 **/
		private void traverseToMin(Node root) {
			while (root.left != null) {
				stack.push(root.left);
				root = root.left;
			}
			prev = null;

		}

		/**
		 * Since we are not popping the current element immediately after
		 * printing it. hasNext() is not as simple as checking for stack
		 * emptiness. We still have the case where the right subtree of a given
		 * node is processed completely but stack has all these elements. So we
		 * detect this case by using the previous pointer and checking if
		 * curr.right == prev and as long as this condition is true we pop the
		 * stack. So we reach to a point where the complete right subtree is
		 * popped out. And if still the stack is not empty, this means there are
		 * unprocessed elements still on stack, else it returns false.
		 **/
		@Override
		public boolean hasNext() {
			if (stack.isEmpty())
				return false;
			Node curr = stack.peek();
			while (prev != null && (curr.right == prev)) {
				prev = stack.pop();
				if (stack.isEmpty())
					break;
				curr = stack.peek();
			}
			return !stack.isEmpty();
		}

		/**
		 * Get the top of the stack and check if the direction of traversal is
		 * 'forward' or 'backward'. Backward traversal cases are traversing from
		 * left or right. If traversing from left to top, current node is not
		 * yet printed, so save it to return , additionally check if a right
		 * node exists for current and set the pointer to the left most node of
		 * that right subtree for the subsequent 'next()' call. If the right
		 * node is null , just pop the top and return it(or print it) If
		 * traversing from right to top, current(or stack top) is already
		 * printed hence pop the top and call next() for the next element.
		 * Checking if traversing from left to top or right to top is achieved
		 * by maintaining a "prev" pointer.
		 **/
		@Override
		public Node next() {
			if (!stack.isEmpty()) {
				Node curr = stack.peek();
				if (prev == null || prev == curr.left) {
					if (curr.right != null) {
						prev = curr;
						stack.push(curr.right);
						traverseToMin(curr.right);
					} else {
						prev = curr;
						stack.pop();
					}
					return curr;
				} else if (prev == curr.right) {
					prev = stack.pop();
					return next();
				}
			}
			return null;
		}
		
		public Node next1() {
			if(!stack.isEmpty()) {
				Node curr = stack.pop();
				if(curr.right!=null) {
					stack.push(curr.right);
					traverseToMin(curr.right);
				}
				return curr;
			}
			return null;
		}
		
		public boolean hasNext1() {
			return !stack.isEmpty();
		}

		@Override
		public void remove() {
			return;
		}
	}

}
