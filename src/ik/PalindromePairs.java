package ik;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromePairs {
    static class Pair<U,V> {
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((x == null) ? 0 : x.hashCode());
            result = prime * result + ((y == null) ? 0 : y.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (x == null) {
                if (other.x != null)
                    return false;
            } else if (!x.equals(other.x))
                return false;
            if (y == null) {
                if (other.y != null)
                    return false;
            } else if (!y.equals(other.y))
                return false;
            return true;
        }
        U x;
        V y;
        public Pair(U u, V v) {
            this.x = u;
            this.y = v;
        }
        
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Set<String> iWords = new HashSet<String>();
        iWords.add("bat");
        iWords.add("tab");
        iWords.add("cat");
        Set<Pair<String,String>> result = palindromePairs(iWords);
        for(Pair<String,String> p : result) {
            System.out.println(p.x + "and " + p.y + " combines to form a palindrome");
        }
        
    }
    
    static boolean isPalindrome(String word) {
        int begin = 0;
        int end = word.length()-1;
        while(begin < end) {
            if(word.charAt(begin++) == word.charAt(end--)) return false;
        }
        return true;
    }
    
    static Set<Pair<String,String>> palindromePairs(Set<String> words) {
        TrieNode t1 = new TrieNode('#');
        TrieNode t2 = new TrieNode('#');
        Set<Pair<String,String>> res = new HashSet<Pair<String,String>>();
        words.stream().forEach((word) -> {
            insert(t1,word);
        });
        words.stream().forEach((word) -> {
            insert(t2,new StringBuilder(word).reverse().toString());
        });
        
        // traverse t1 and find if reverse of the word is present;
        for(String word: words) {
            String rWord = new StringBuilder(word).reverse().toString();
            int matchIndex = matchIndex(t1, rWord);
            if(matchIndex==word.length()) {
                System.out.println(rWord + " " + word);
                res.add(new Pair<String,String>(rWord,word));
            }
            if(matchIndex >= 0 && matchIndex < rWord.length()) {
                if(isPalindrome(word.substring(matchIndex+1,word.length()))){
                    System.out.println(rWord + " " + new StringBuilder(rWord.substring(0,matchIndex+1)).reverse().toString());
                    res.add(new Pair<String,String>(rWord,new StringBuilder(rWord.substring(0,matchIndex+1)).reverse().toString()));
                }
            }
        }
        
        //traverse t2 and find if the word is present;
        for(String word: words) {
            int matchIndex = matchIndex(t2, word);
            if(matchIndex==word.length()) {
                System.out.println(word+" " + new StringBuilder(word).reverse().toString());
                res.add(new Pair<String,String>(word,new StringBuilder(word).reverse().toString()));
            }
            if(matchIndex >=0 && matchIndex < word.length() ) {
                if(isPalindrome(word.substring(matchIndex+1, word.length()))) {
                    System.out.println(word + " " + new StringBuilder(word.substring(0,matchIndex+1)).reverse().toString());
                    res.add(new Pair<String,String>(word, new StringBuilder(word.substring(0,matchIndex+1)).reverse().toString()));
                }
            }
        }
        return res;
    }
    
    static class TrieNode {
    Character val;
    boolean isTerminator;
    Map<Character,TrieNode> children;
    
    public TrieNode(Character val) {
        this.val = val;
        children = new HashMap<Character,TrieNode>();
    }
    
    
}
    private static int matchIndex(TrieNode node, String word) {
        TrieNode prev = null;
        int i=0;
        for(;i<word.length();i++) {
            if(node.children.containsKey(word.charAt(i))) {
                prev = node;
                node = node.children.get(word.charAt(i));
            }else{
                return -1;
            }
            //if(i==word.length()-1) return node.isTerminator;
            if(node.isTerminator && prev.children.isEmpty()) {
                return i;
            }
        }
        return i;
        
    }
    
    private static void insert(TrieNode node, String word) {
        for(int i=0;i<word.length();i++) {
            if(node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            }else{
                TrieNode newNode = new TrieNode(word.charAt(i));
                node.children.put(word.charAt(i), newNode);
                node = newNode;
            }
            if(i==word.length()-1) {
                node.isTerminator = true;
            }
        }
    }
}