package ik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubstring {

	static class TrieNode {
		Map<Character, TrieNode> children;
		Character c;
		int index;
		boolean isTerminator;

		public TrieNode(Character c, int index) {
			this.c = c;
			this.index = index;
			this.children = new HashMap<Character, TrieNode>();
		}

		public TrieNode(Character c) {
			this(c, -1);
		}

	}

	static class Trie {
		TrieNode root;

		public Trie(TrieNode root) {
			this.root = root;
		}

		public void insert(String word) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				TrieNode child = curr.children.get(word.charAt(i));
				if (child == null) {
					child = new TrieNode(word.charAt(i));
					curr.children.put(word.charAt(i), child);
				}
				if (i == word.length() - 1) {
					child.isTerminator = true;
				}
				curr = child;
			}
		}

		public void print(TrieNode r, List<Character> s, List<List<Character>> res) {
			TrieNode curr = r;
			s.add(curr.c);
			if(curr.isTerminator) {
				res.add(new ArrayList<>(s));
			}
			for (TrieNode child : curr.children.values()) {
				print(child,s,res);
			}
			s.remove(s.size()-1);
			return;

		}

	}

	static class Result {
		TrieNode node;
		int len;

		public Result(int len, TrieNode node) {
			this.node = node;
			this.len = len;
		}
	}

	private static Result lrs(int len, TrieNode node) {
		if (node.isTerminator) {
			return new Result(0, node);
		}
		int currMax = 0;
		TrieNode currMaxChild = null;
		for (char c : node.children.keySet()) {
			TrieNode child = node.children.get(c);
			Result childLrs = lrs(len + 1, child);
			if (childLrs.len >= currMax) {
				currMax = childLrs.len;
				currMaxChild = child;
			}

		}
		if (node.children.size() > 1 || (node.isTerminator && node.children.size()>=1)) {
			if (len > currMax) {
				return new Result(len, node);
			}
		}
		return new Result(currMax, currMaxChild);

	}
	
	private static String lrs(StringBuilder sb, TrieNode node) {
		if(node.c!='$')
			sb.append(node.c);
		int max = 0;
		String longestSubstr = null;
		for (TrieNode child : node.children.values()) {
			String val = lrs(sb, child);
			if (val.length() > max) {
				longestSubstr = val;
				max = longestSubstr.length();
			}
		}
		String ret = sb.toString();
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}

		if (max > 0) {
			return longestSubstr;
		}
		if (node.children.size() > 1 || (node.isTerminator && node.children.size() >= 1)) {
			return ret;
		} else {
			return "";
		}
	}

	private static Set<String> getSuffixes(String word) {
		Set<String> suffixes = new HashSet<String>();
		for (int i = 0; i < word.length(); i++) {
			suffixes.add(word.substring(i, word.length()));
		}
		return suffixes;
	}

	static String LRS(String iString) {
		Set<String> suffixes = getSuffixes(iString);
		TrieNode root = new TrieNode('$');
		Trie t = new Trie(root);
		for (String s : suffixes) {
			t.insert(s);
		}
//		List<List<Character>> res = new ArrayList<List<Character>>();
//		List<Character> r = new ArrayList<Character>();
//		t.print(root,new ArrayList<Character>(), res);
//		for(List<Character> s : res) {
//			System.out.println(s.stream().map((elem) -> elem.toString()).collect(Collectors.joining(",")));
//		}
		return lrs(new StringBuilder(""), root);
	}
	
	public static void main(String[] arg) {
		System.out.println(LRS("abcpqrabpqpq"));
	}

}
