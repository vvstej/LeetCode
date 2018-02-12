package ik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegexMatcher {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(System.out);
		boolean res;
		String _strText;
		try {
			_strText = in.nextLine();
		} catch (Exception e) {
			_strText = null;
		}

		String _strPattern;
		try {
			_strPattern = in.nextLine();
		} catch (Exception e) {
			_strPattern = null;
		}

		res = isMatch(_strText, _strPattern);
		System.out.println(res);
	}

	static boolean isMatch(String strText, String strPattern) {
		return regexHelper(strText, strPattern, 0, 0);
	}

	static boolean regexHelper(final String str, final String pattern, int si, int pi) {
		// if(si==str.length() && pi == pattern.length()) return true;
		if (si == str.length()) {
			return (pi == pattern.length() || pattern.endsWith("*"));
		}
		if (pi == pattern.length()) {
			return si == str.length();
		}

		if (pi < pattern.length() - 1 && pattern.charAt(pi + 1) == '*') {
			// 0 match
			boolean truth = regexHelper(str, pattern, si, pi + 2);
			// 1 or more matches
			int index = si;
			while (index < str.length() && (str.charAt(index) == pattern.charAt(pi) || pattern.charAt(pi) == '.')) {
				truth = truth || regexHelper(str, pattern, index + 1, pi + 2);
				index++;
			}
			return truth;
		} else if (pattern.charAt(pi) == '.' || str.charAt(si) == pattern.charAt(pi)) {
			return regexHelper(str, pattern, si + 1, pi + 1);
		} else
			return false;

	}
}
