package ik;

import java.util.*;

public class GraphsLongestPath {

	static int[] find_longest_path(int dag_nodes, int[] dag_from, int[] dag_to, int[] dag_weight, int from_node,
			int to_node) {
		Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
		for (int i = 0; i < dag_from.length; i++) {
			Vertex v = vertexMap.get(dag_from[i]);
			if (v == null) {
				v = new Vertex(dag_from[i]);
			}
			List<Edge> neighbours = v.neighbours;
			Vertex to = vertexMap.get(dag_to[i]);
			if (to == null) {
				to = new Vertex(dag_to[i]);
			}
			neighbours.add(new Edge(v, to, dag_weight[i]));
			vertexMap.put(dag_from[i], v);
			vertexMap.put(dag_to[i], to);
		}
		List<Vertex> path = new ArrayList<Vertex>();
		Map<Integer, Result> memMap = new HashMap<Integer, Result>();
		path.add(vertexMap.get(from_node));
		Result res = longestPath(vertexMap.get(from_node), vertexMap.get(to_node), path, memMap);
		int[] resPath = new int[res.longestPath.size()];
		int i = 0;
		for (Vertex v : res.longestPath) {
			resPath[i++] = v.val;
		}
		return resPath;
	}

	static Result longestPath(Vertex from, Vertex to, List<Vertex> path, Map<Integer, Result> memMap) {
		if (memMap.containsKey(from.val)) {
			return memMap.get(from.val);
		}
		if (from == to) {
			return new Result(path, 0);
		}
		Result res = null;
		int longest = 0;
		List<Vertex> longestPath = null;
		for (Edge e : from.neighbours) {
			List<Vertex> pathTracker = new ArrayList<>(path);
			pathTracker.add(e.to);
			Result r = longestPath(e.to, to, pathTracker, memMap);
			if (r.weight + e.weight > longest) {
				longest = r.weight + e.weight;
				longestPath = r.longestPath;
			}
		}
		res = new Result(longestPath, longest);
		memMap.put(from.val, res);
		return res;
	}

	static class Result {
		List<Vertex> longestPath;
		int weight;

		public Result(List<Vertex> longestPath, int weight) {
			this.longestPath = longestPath;
			this.weight = weight;
		}
	}

	static class Vertex {
		int val;
		List<Edge> neighbours;
		boolean visited;

		public Vertex(int val) {
			this.val = val;
			this.neighbours = new ArrayList<Edge>();
		}

	}

	static class Edge {
		int weight;
		Vertex to;
		Vertex from;

		public Edge(Vertex from, Vertex to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] arg) {
		find_longest_path(3, new int[] { 2, 2, 3 }, new int[] { 1, 3, 1 }, new int[] { 4, 1, 2 }, 2, 1);
	}
}
