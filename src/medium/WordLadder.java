package medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    	if(wordDict.size()==0 || beginWord==null || endWord==null || beginWord.length()!=endWord.length()){
    		return 0;
    	}
    	if(beginWord.equals(endWord)){
    		return 0;
    	}
        Map<String,GraphNode<String>> graphNodes = new HashMap<String,GraphNode<String>>();
        Iterator<String> it = wordDict.iterator();
        while(it.hasNext()){
        	String word = it.next();
        	graphNodes.put(word, new GraphNode<String>(word));
        }
        Iterator<String> it1 = wordDict.iterator();
        Queue<String> bfsQueue = new LinkedList<String>();
        while(it1.hasNext()){
            String word1 = it1.next();
            
            Iterator<String> it2 = wordDict.iterator();
            while(it2.hasNext()){
                String word2 = it2.next();
                
                if(!word1.equals(word2)){
                    boolean isAdjacent = isAdjacent(word1,word2);
                    if(isAdjacent){
                        GraphNode<String> word1Node = graphNodes.get(word1);
                        List<GraphNode<String>> word1AdjacencyList = word1Node.adjList;
                        if(word1AdjacencyList==null){
                            word1AdjacencyList = new ArrayList<GraphNode<String>>();
                        }
                        GraphNode<String> word2Node = graphNodes.get(word2)!=null ? graphNodes.get(word2) : new GraphNode<String>(word2);
                        word1AdjacencyList.add(word2Node);   
                        word1Node.adjList = word1AdjacencyList;
                        graphNodes.put(word1,word1Node);
                     }
                }
            }
        }
        it1 = wordDict.iterator();
        while(it1.hasNext()){
        	GraphNode<String> word1Node = graphNodes.get(it1.next());
        	if(isAdjacent(word1Node.value,beginWord)){
        		word1Node.length++;
                bfsQueue.offer(word1Node.value);
            }
        }
         while(!bfsQueue.isEmpty()){
             String adjWord = bfsQueue.poll();
             GraphNode<String> adjWordNode = graphNodes.get(adjWord);
             adjWordNode.visited = true;
             if(isAdjacent(adjWord, endWord)){
            	 return adjWordNode.length+1;
             }else if(adjWord.equals(endWord)){
            	 return adjWordNode.length;
             }
             List<GraphNode<String>> adjNodes = adjWordNode.adjList;
             for(GraphNode<String> node : adjNodes){
                 if(!node.visited){
                     node.length = adjWordNode.length+1;
                     node.visited = true;
                     bfsQueue.offer(node.value);
                 }
             }
         }
         
         return 0;
        
    }
    
    public static boolean isAdjacent(String word1, String word2){
        int diff = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                diff++;
            }
        }
        return (diff==1) ? true : false;
    }
    
    public static void main(String[] arg){
    	WordLadder wordLadder = new WordLadder();
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	System.out.println(wordLadder.ladderLength("hit", "cog", dict));
    }
}

class GraphNode<T>{
    T value;
    int length;
    boolean visited;
    List<GraphNode<T>> adjList;
    
    public GraphNode(T value){
        this.value = value;
        this.length = 0;
        this.visited = false;
    }
}