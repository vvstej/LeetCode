package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

	private TrieNode root;

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	public Trie() {
		root = new TrieNode('$');
	}

	public void insert(String word) {
		char[] chars = word.toLowerCase().toCharArray();
		TrieNode pointer = this.root;
		for (int i = 0; i < chars.length; i++) {
			TrieNode child = pointer.getChildNodeWithVal(chars[i]);
			if (child == null) {
				child = new TrieNode(chars[i]);
				pointer.addChild(chars[i], child);
			}
			pointer = child;
		}
		pointer.setTerminator(true);
	}

	public boolean search(String word) {
		char[] chars = word.toCharArray();
		TrieNode pointer = this.root;
		for (int i = 0; i < chars.length; i++) {
			TrieNode child = pointer.getChildNodeWithVal(chars[i]);
			if (child == null) {
				return false;
			}
			pointer = child;
		}
		if (pointer.isTerminator)
			return true;
		else
			return false;
	}

	public boolean startsWith(String prefix) {
		char[] chars = prefix.toCharArray();
		TrieNode pointer = this.root;
		for (int i = 0; i < chars.length; i++) {
			TrieNode child = pointer.getChildNodeWithVal(chars[i]);
			if (child == null) {
				return false;
			}
			pointer = child;
		}
		return true;
	}

	public boolean recursiveSearch(String pattern, TrieNode pointer,
			int indexToSearch) {
		if(indexToSearch>pattern.length()-1){
			return false;
		}
		char charToSearch = pattern.charAt(indexToSearch);
		TrieNode child = null;
		if (charToSearch == '.') {
			Map<Character, TrieNode> allChildren = pointer.getAllChildren();
			Set<Character> childrenSet = allChildren.keySet();
			for (Character c : childrenSet) {
				child = allChildren.get(c);
				if(child.isTerminator && (indexToSearch == pattern.length()-1)){
					return true;
				}
				boolean result = recursiveSearch(pattern, child,
						indexToSearch + 1);
				if (result) {
					return true;
				}
			}
			return false;
		} else {
			child = pointer.getChildNodeWithVal(charToSearch);
			if (child == null) {
				return false;
			} else {
				if (indexToSearch == (pattern.length() - 1) && child.isTerminator) {
					return true;
				} else {
					return recursiveSearch(pattern, child, indexToSearch + 1);
				}
			}
		}

	}

	public static void main(String[] arg) {
		Trie trie = new Trie();
		trie.insert("tej");
		trie.insert("teja");
		trie.insert("ad n");
		System.out.println(trie.search("ad n"));

	}
}

class TrieNode {
	char val;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	// determines if there is a word ending here.
	boolean isTerminator;

	public boolean isTerminator() {
		return isTerminator;
	}

	public void setTerminator(boolean isTerminator) {
		this.isTerminator = isTerminator;
	}

	public TrieNode(char c) {
		this.val = c;
	}

	public TrieNode getChildNodeWithVal(char c) {
		return this.children.get(c);
	}

	public Map<Character, TrieNode> getAllChildren() {
		return this.children;
	}

	public void addChild(char c, TrieNode node) {
		this.children.put(c, node);
	}
}
