package ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	private static void printMatrix(char[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(" " + Character.toString(matrix[row][col]) + " ");
			}
			System.out.println("");
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print("|--");
			}
			System.out.println("");
		}
	}

	private static void nQueens(int total, int row, List<Integer> curr, List<List<Integer>> res) {
		if (row == total) {
			res.add(new ArrayList<>(curr));
		} else {
			for (int i = 0; i < total; i++) {
				curr.add(i);
				if (isValid(curr)) {
					nQueens(total, row + 1, curr, res);
				}
				curr.remove(curr.size() - 1);
			}
		}

	}

	private static boolean isValid(List<Integer> curr) {
		// get the last row's col val
		int lastRow = curr.get(curr.size() - 1);
		for (int i = 0; i < curr.size() - 1; i++) {
			int diff = Math.abs(lastRow - curr.get(i));
			// diff == 0 checks if the last row's col placement is same as any
			// previous row
			// diff == (lastRow-i) checks if the last row's col placement is in
			// the diagonal path of any previous row
			if (diff == 0 || diff == (curr.size()-1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		int n = 8;
		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		nQueens(n, 0, curr, res);
		for (int sol = 0; sol < res.size(); sol++) {
			char[][] matrix = new char[n][n];
			for (int col = 0; col < res.get(sol).size(); col++) {
				char[] matrixRow = new char[n];
				Arrays.fill(matrixRow, ' ');
				matrixRow[res.get(sol).get(col)] = '*';
				matrix[col] = matrixRow;
			}
			System.out.println("Solution: "+ (sol+1));
			printMatrix(matrix);
		}
	}
}
