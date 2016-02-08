package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//O(E+E) //size O(E+V+E)
public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (n == 0 || edges.length == 0) {
			return false;
		}
		Set<Integer> visitedNodes = new HashSet<Integer>();
		Map<Integer, Set<Integer>> adjacencyMap = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			Set<Integer> adjSet = adjacencyMap.get(edges[i][0]);
			if (adjSet == null) {
				adjSet = new HashSet<Integer>();
			}
			adjSet.add(edges[i][1]);
			adjacencyMap.put(edges[i][0], adjSet);
			// add opposite mapping
			adjSet = adjacencyMap.get(edges[i][1]);
			if (adjSet == null) {
				adjSet = new HashSet<Integer>();
			}
			adjSet.add(edges[i][0]);
			adjacencyMap.put(edges[i][1], adjSet);
		}
		Queue<Integer> bfsQueue = new LinkedList<Integer>();
		bfsQueue.add(0);
		while (!bfsQueue.isEmpty()) {
			int curr = bfsQueue.poll();
			if (visitedNodes.contains(curr)) {
				return false;
			}
			visitedNodes.add(curr);
			Set<Integer> adjSet = adjacencyMap.get(curr);
			if (adjSet != null) {
				for (int val : adjSet) {
					Set<Integer> adjSetOfDest = adjacencyMap.get(val);
					adjSetOfDest.remove(curr);
					bfsQueue.add(val);
				}
			}

		}
		if (visitedNodes.size() < n) {
			return false;
		}
		return true;
	}

	public static void main(String[] arg) {
		System.out.println(new GraphValidTree().validTree(5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 2 }, { 0, 4 },{0,3}}));
	}
}
