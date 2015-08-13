package medium;

public class WordDictionary {
	Trie trie;

	public WordDictionary(){
		trie = new Trie();
	}
	
	public void addWord(String word){
		this.trie.insert(word);
	}
	
	public boolean search(String word){
		return this.trie.recursiveSearch(word, this.trie.getRoot(), 0);
	}
	
	public static void main(String[] arg){
		WordDictionary word = new WordDictionary();
		word.addWord("tej");
		word.addWord("tyy");
		System.out.println(word.search("..."));
	}
	
}
