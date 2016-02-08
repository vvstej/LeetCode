package medium;

import java.util.*;

public class ConnectedComponents1 {

	public int countComponents(int n, int[][] edges) {
		Map<Integer, Set<Integer>> adjMap = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<Integer>();
			set.add(i);
			adjMap.put(i, set);
		}
		for (int i = 0; i < edges.length; i++) {
			Set<Integer> first = adjMap.get(edges[i][0]);
			Set<Integer> second = adjMap.get(edges[i][1]);
			if (first == null) {
				first = new HashSet<Integer>();
			}
			first.add(edges[i][1]);
			adjMap.put(edges[i][0], first);
			if (second == null) {
				second = new HashSet<Integer>();
			}
			second.add(edges[i][0]);
			adjMap.put(edges[i][1], second);
		}
		// bfs

		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			Set<Integer> currSet = adjMap.get(i);
			if (adjMap.get(i) != null) {
				queue.add(i);
			}
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				Set<Integer> set = adjMap.get(curr);
				currSet.add(curr);
				// mark done so that it will not be picked in outer for loop
				adjMap.put(curr, null);
				if (set != null) {
					for (int val : set) {
						if (val != curr)
							queue.add(val);
					}
				}

			}
			adjMap.put(i, currSet);

		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (adjMap.get(i) != null) {
				count++;
			}
		}

		return count;

	}

	public static void main(String[] arg) {
		System.out.println(new ConnectedComponents1().countComponents(10,
				new int[][] { { 5, 8 }, { 3, 5 }, { 1, 9 }, { 4, 5 }, { 0, 2 }, { 1, 9 }, { 7, 8 }, { 4, 9 } }));
	}
}
