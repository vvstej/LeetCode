package hard;

import java.util.*;

public class WordBreak2 {

	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (wordDict == null || wordDict.size() == 0)
			return res;
		List<List<List<String>>> dp = new ArrayList<List<List<String>>>();
		for (int i = 0; i <= s.length(); i++) {
			dp.add(new ArrayList<List<String>>());
		}
		for (int i = 0; i < dp.size(); i++) {
			for (int j = 0; j <= s.length(); ++j) {
				dp.get(i).add(new ArrayList<String>());
			}
		}
		for(int len=1;len<=s.length();len++) {
			for(int i=1;i+len <=s.length();++i) {
				
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i; j >= 1; --j) {
				List<String> curr = dp.get(j).get(i);
				if (wordDict.contains(s.substring(j - 1, i))) {
					curr.add(s.substring(j - 1, i));
				}
				for (int k = j + 1; k <= i; ++k) {
					List<String> words1 = dp.get(j).get(k - 1);
					List<String> words2 = dp.get(k).get(i);
					for (String word1 : words1) {
						for (String word2 : words2) {
							if (!curr.contains(word1 + " " + word2))
								curr.add(word1 + " " + word2);
						}
					}
				}
			}
		}
		return dp.get(1).get(s.length());

	}

	public static void main(String[] arg) {
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> res = wordBreak("catsanddog", dict);
		for (String w : res) {
			System.out.println(w);
		}
	}
}
