package ik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KnightsMoves {
	/*
	 * Complete the function below.
	 */

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		int _rows;
		_rows = Integer.parseInt(in.nextLine().trim());

		int _cols;
		_cols = Integer.parseInt(in.nextLine().trim());

		int _startx;
		_startx = Integer.parseInt(in.nextLine().trim());

		int _starty;
		_starty = Integer.parseInt(in.nextLine().trim());

		int _endx;
		_endx = Integer.parseInt(in.nextLine().trim());

		int _endy;
		_endy = Integer.parseInt(in.nextLine().trim());

		res = minimumMoves(_rows, _cols, _startx, _starty, _endx, _endy);
		System.out.print(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
	}

	static int minimumMoves(int rows, int cols, int startx, int starty, int endx, int endy) {
		Vertex[][] vertexArr = new Vertex[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == startx && j == starty) {
					vertexArr[i][j] = new Vertex(i, j, 0);
				} else {
					vertexArr[i][j] = new Vertex(i, j, Integer.MAX_VALUE);
				}

			}
		}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertexArr[startx][starty]);

		// unweighted shortest path aka dijkstra's algorithm
		while (!queue.isEmpty()) {
			Vertex curr = queue.poll();
			Set<Vertex> adjacentSet = findKnightNeighbours(curr, vertexArr);
			for (Vertex v : adjacentSet) {
				if (v.dist == Integer.MAX_VALUE) {
					v.dist = curr.dist + 1;
					if (v.x == endx && v.y == endy) {
						return v.dist;
					}
					queue.add(v);
				}
			}
		}
		return -1;

	}

	private static Set<Vertex> findKnightNeighbours(Vertex v, Vertex[][] vArr) {
		Set<Vertex> neighbours = new HashSet<Vertex>();
		// 8 neighbours max, check if they dont fall beyond chess board.
		int rows = vArr.length;
		int cols = vArr[0].length;

		int x = v.x + 1;
		int y = v.y + 2;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}
		x = v.x + 2;
		y = v.y + 1;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x + 1;
		y = v.y - 2;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x - 2;
		y = v.y + 1;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x - 1;
		y = v.y + 2;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x + 2;
		y = v.y - 1;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x - 2;
		y = v.y - 1;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		x = v.x - 1;
		y = v.y - 2;

		if (x >= 0 && x < rows && y >= 0 && y < cols) {
			neighbours.add(vArr[x][y]);
		}

		return neighbours;
	}

	static class Vertex {
		int x;
		int y;
		int dist;

		public Vertex(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
