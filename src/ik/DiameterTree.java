package ik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import easy.TreeNode;

public class DiameterTree {
	
	public void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
		
	}
	public void preOrder1(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(node!=null) {
			stack.push(node);
		}
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.println(curr.val);
			if(curr.right!=null) {
				stack.push(curr.right);
			}
			if(curr.left!=null) {
				stack.push(curr.left);
			}
			
		}
		
	}
	
	public void inOrder(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(node==null){
			return;
		}
		stack.push(node);
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(curr.right==null && curr.left == null) {
				stack.pop();
			}
			if(curr.right!=null) {
				stack.pop();
				stack.push(curr.right);
				stack.push(curr);
			}
			if(curr.left!=null){
				stack.push(curr.left);
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		Node node10 = new Node(10, null);
		Node node9 = new Node(9, null);
		Node node8 = new Node(8, null);
		Node node7 = new Node(7, null);
		Node node6 = new Node(6, null);
		Node node5 = new Node(5, null);

		Edge e1 = new Edge(9, node10);
		Edge e2 = new Edge(10, node9);
		Edge e3 = new Edge(8, node8);
		Edge e4 = new Edge(9, node7);
		Edge e5 = new Edge(7, node6);
		Edge e6 = new Edge(8, node5);

		List<Edge> node4Edges = new ArrayList<Edge>();
		node4Edges.add(e1);
		node4Edges.add(e2);
		Node node4 = new Node(4, node4Edges);
		Edge e7 = new Edge(5, node4);

		List<Edge> node3Edges = new ArrayList<Edge>();
		node3Edges.add(e3);
		node3Edges.add(e4);
		Node node3 = new Node(3, node3Edges);
		Edge e8 = new Edge(5, node3);

		List<Edge> node2Edges = new ArrayList<Edge>();
		node2Edges.add(e5);
		node2Edges.add(e6);
		Node node2 = new Node(2, node2Edges);
		Edge e9 = new Edge(5, node2);

		List<Edge> node1Edges = new ArrayList<Edge>();
		node1Edges.add(e7);
		node1Edges.add(e8);
		node1Edges.add(e9);

		Node node1 = new Node(1, node1Edges);
		System.out.println(diameter(node1));
	}

	private static int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int maxDiameterChild = 0;
		if (node.edges != null) {
			for (Edge e : node.edges) {
				int prev = diameter(e.destination);
				if (prev > maxDiameterChild) {
					maxDiameterChild = prev;
				}
			}
		}
		int maxWeightedHeight1 = 0;
		int maxWeightedHeight2 = 0;
		if (node.edges != null) {
			for (Edge e : node.edges) {
				int prev = weightedHeight(e.destination);
				if (prev >= maxWeightedHeight1) {
					maxWeightedHeight1 = prev + e.weight;
				} else if (prev >= maxWeightedHeight2) {
					maxWeightedHeight2 = prev + e.weight;
				}
			}
		}
		return Math.max(maxDiameterChild, (maxWeightedHeight1 + maxWeightedHeight2));
	}

	private static int weightedHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int max = 0;
		if (node.edges != null) {
			for (Edge e : node.edges) {
				int prev = weightedHeight(e.destination);
				int curr = e.weight + prev;
				if (curr > max) {
					max = curr;
				}
			}
		}
		return max;
	}
}

class Node {
	List<Edge> edges;
	int id;

	Node(int id, List<Edge> edges) {
		this.id = id;
		this.edges = edges;
	}
}

class Edge {
	int weight;
	Node destination;

	Edge(int weight, Node destination) {
		this.weight = weight;
		this.destination = destination;
	}
}