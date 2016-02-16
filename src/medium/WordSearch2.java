package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<String>();
		for (String word : words) {
			boolean[][] explored = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					boolean found = false;
					if (board[i][j] == word.charAt(0)) {
						explored[i][j] = true;
						found = recursiveFind(word, explored, board, i, j);
					}
					if (found) {
						result.add(word);
					} else {
						explored[i][j] = false;
					}
				}
			}
		}
		List<String> resultList = new ArrayList<String>(result);
		return resultList;
	}

	private boolean recursiveFind(String word, boolean[][] explored, char[][] board, int i, int j) {
		if (word.length() == 1) {
			return (word.charAt(0) == board[i][j]);
		}
		char c = word.charAt(0);
		boolean left = false, right = false, top = false, bottom = false;
		// toLeft
		if (board[i][j] == c) {
			String subWord = word.substring(1);
			if (j > 0 && !explored[i][j - 1]) {
				explored[i][j - 1] = true;
				left = recursiveFind(subWord, explored, board, i, j - 1);
				if (left)
					return true;
				else {
					explored[i][j - 1] = false;
				}
			}
			if (j < explored[0].length - 1 && !explored[i][j + 1]) {
				explored[i][j + 1] = true;
				right = recursiveFind(subWord, explored, board, i, j + 1);
				if (right)
					return true;
				explored[i][j + 1] = false;
			}

			if (i > 0 && !explored[i - 1][j]) {
				explored[i - 1][j] = true;
				top = recursiveFind(subWord, explored, board, i - 1, j);
				if (top)
					return true;
				explored[i - 1][j] = false;
			}

			if (i < board.length - 1 && !explored[i + 1][j]) {
				explored[i + 1][j] = true;
				bottom = recursiveFind(subWord, explored, board, i + 1, j);
				if (bottom)
					return true;
				explored[i + 1][j] = false;
			}
		}
		return false;

	}

	public static void main(String[] arg) {
		WordSearch2 w = new WordSearch2();
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		List<String> words = w.findWords(board, new String[] { "oath", "pea", "eat", "rain" });
		for (String word : words) {
			System.out.println(word);
		}

	}
}
