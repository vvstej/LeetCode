package ik;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	static String MinWindow(String input, String target) {
		if (target.length() > input.length())
			return "";
		Map<Character, Integer> cMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		int missing = target.length();
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			Integer curr = tMap.get(c);
			if (curr == null) {
				tMap.put(c, 1);
				cMap.put(c, 0);
			} else {
				tMap.put(c, curr + 1);
			}
		}
		int i = 0;
		int j = -1;
		int min = Integer.MAX_VALUE;
		int minI = 0;
		int minJ = 0;
		while (i < input.length() && j < input.length()) {
			// expansion phase..
			do {
				if(j==input.length()-1) {
					j++;
					break;
				}
				char c = input.charAt(++j);
				if (tMap.get(c) != null) {
					if (cMap.get(c) < tMap.get(c)) {
						--missing;
					}
					cMap.put(c, cMap.get(c) + 1);
				}
			} while (missing > 0 && j < input.length());
			if( j == input.length()) break;
			// compression phase..
			do {
				char c = input.charAt(i);
				Integer curr = cMap.get(c);
				if (tMap.get(c) != null) {
					if (curr - 1 < tMap.get(c)) {
						missing++;
					}
					cMap.put(c, curr - 1);
				}

				i++;
			} while (missing == 0 && i < input.length());
			if (missing > 0 && cMap.get(input.charAt(i - 1)) != null) {
				--i;
				cMap.put(input.charAt(i), cMap.get(input.charAt(i)) + 1);
				missing--;
			}
			if (min >= j - i + 1) {
				min = j - i + 1;
				minI = i;
				minJ = j;
			}
		}
		if (missing > 0)
			return "";
		return input.substring(minI, minJ + 1);

	}

	public static void main(String[] arg) {
		System.out.println(MinWindow("babb", "baba"));
	}
}
