package hard;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		final Set<Character> allPossibleValues = new HashSet<>();
		allPossibleValues.add('1');
		allPossibleValues.add('2');
		allPossibleValues.add('3');
		allPossibleValues.add('4');
		allPossibleValues.add('5');
		allPossibleValues.add('6');
		allPossibleValues.add('7');
		allPossibleValues.add('8');
		allPossibleValues.add('9');
		System.out.println(sudokuSolver(board, 0, 0, allPossibleValues));
	}

	private static boolean sudokuSolver(char[][] board, int fromI, int fromJ, final Set<Character> allPossibleValues) {
		int i = fromI;
		int j = fromJ;
		boolean isEmptyFound = false;
		for (; i < 9; i++) {
			isEmptyFound = false;
			for (; j < 9; j++) {
				if(i==8) {
					System.out.println("asdf");
				}
				if (Character.compare(board[i][j], '.') == 0) {
					isEmptyFound = true;
					break;
				}
			}
			if(isEmptyFound){
				break;
			}
			j=0;
		}
		if (i == 9 && j == 9) {
			return true; // end of matrix.
		}
		
		Set<Character> currPossibleValues = new HashSet<>(allPossibleValues);
		// filter row wise
		for (int col = 0; col < 9; col++) {
			currPossibleValues.remove(board[i][col]);
		}
		for (int row = 0; row < 9; row++) {
			currPossibleValues.remove(board[row][j]);
		}
		int rowBegin = (i/3) * 3;
		int colBegin = (j/3) * 3;
		int rowEnd = rowBegin + 3;
		int colEnd = colBegin + 3;
		for (int r = rowBegin; r < rowEnd; r++) {
			for (int c = colBegin; c < colEnd; c++) {
				currPossibleValues.remove(board[r][c]);
			}
		}
		if (currPossibleValues.size() == 0) {
			return false;
		}
		for (char possibility : currPossibleValues) {
			board[i][j] = possibility;
			int nextI = i;
			int nextJ = j;
			if (j < 8) {
				nextJ = j + 1;
			} else if (j == 8) {
				nextJ = 0;
				nextI = i + 1;
			}
			if (nextI == 9) {
				return true;
			}
			boolean prevResult = sudokuSolver(board, nextI, nextJ, allPossibleValues);
			if (prevResult) {
				return true;
			} else {
				board[i][j] = '.';
				continue;
			}

		}
		return false;

	}
	
	public static void main(String[] arg) {
		char [][] board = new char[][]{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		new SudokuSolver().solveSudoku(board);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println(board);
	}
}
