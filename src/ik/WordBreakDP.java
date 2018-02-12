package ik;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDP {

	static String[] wordBreak(String strWord, String[] strDict) {
		Set<String> dict = new HashSet<>();
		for (int i = 0; i < strDict.length; i++) {
			dict.add(strDict[i]);
		}
		Set<String> words = wordBreak(strWord, dict);
		return words.toArray(new String[] {});

	}

	private static Set<String> wordBreak(final String word, final Set<String> dict) {
		int n = word.length();
		List<List<Set<String>>> dp = new ArrayList<List<Set<String>>>(n);
		for (int i = 0; i < n; i++) {
			dp.add(new ArrayList<Set<String>>(n + 1));
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n + 1; j++) {
				dp.get(i).add(new HashSet<String>());
			}
		}
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len <= n; ++i) {
				Set<String> res = new HashSet<String>();
				if (len == 1) {
					if (dict.contains(Character.toString(word.charAt(i)))) {
						res.add(Character.toString(word.charAt(i)));
					}
				} else {
					if (dict.contains(word.substring(i, i + len))) {
						res.add(word.substring(i, i + len));
					}
					for (int k = 1; k <= len - 1; ++k) {
						Set<String> p1 = dp.get(i).get(k);
						Set<String> p2 = dp.get(k).get(len - k);
						if (p1.isEmpty() || p2.isEmpty()) {
							continue;
						}
						for (String w1 : p1) {
							for (String w2 : p2) {
								res.add(w1 + " " + w2);
							}
						}
					}

				}
				dp.get(i).set(len, res);
			}
		}
		return dp.get(0).get(n);
	}

	public static void main(String[] arg) {
		String[] res = wordBreak("applepie", new String[] { "app", "apple", "let", "pie" });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
