package easy.com.sfdc.test;
import java.util.*;

// The Friendship class
//
// Feel free to modify it however you want to implement the 3-4 methods and make them work.
// 
public class Friendship {
	
    Map<String,Set<String>> friendMap = new HashMap<String,Set<String>>();
    // constructor
    public Friendship() {   	
    }

    // This is for you to implement
    //
    // This method takes 2 String parameters and
    // makes them "friend" of each other.  
    //
    // Note: The order of names does not matter
    // Note: Don't forget to write tests to have good test coverage for this method
    public void makeFriend(String name1, String name2) throws Exception{  
    	if(name1==null || name2==null){
    		throw new Exception("Names cannot be null"); 
    	}
    	Set<String> friends = friendMap.get(name1);
    	if(friends==null){
    		friends = new HashSet<String>();
    	}
    	Set<String> friends2 = friendMap.get(name2);
    	if(friends2==null){
    		friends2 = new HashSet<String>();
    	}
    	friends.add(name2);
    	friends2.add(name1);
    	friendMap.put(name1, friends);
    	friendMap.put(name2, friends2);
    }
    
    // This is for you to implement
    //
    // This method takes 2 String parameters and
    // makes them no longer friends of each other.  
    //
    // Note: The order of names does not matter
    // Note: Don't forget to write tests to have good test coverage for this method
    public void unmakeFriend(String name1, String name2) throws Exception { 
    	if(name1==null || name2==null){
    		throw new Exception("Names cannot be null"); 
    	}
    	Set<String> friends = friendMap.get(name1);
    	Set<String> friends2 = friendMap.get(name2);
    	if(friends!=null){
    		friends.remove(name2);
    	}
    	if(friends2!=null)
    		friends.remove(name2);
    	//friendMap.put(name1, friends);
    }
    
    // This is for you to implement
    //
    // This method takes a single argument (name) and 
    // returns all the immediate "friends" of that name
    //
    // For example, A & B are friends, B & C are friends and C & D are friends.
    // getDirectFriends(B) would return A and C
    // getDirectFriends(D) would return C
    //
    // Note: It should not return duplicate names
    // Note: Don't forget to write tests to have good test coverage for this method
    public List<String> getDirectFriends(String name) {
    	Set<String> friends = friendMap.get(name);
    	List<String> listOfFriends =  new ArrayList<String>();
    	if(friends!=null)
    		listOfFriends.addAll(friends);
    	return listOfFriends;
    }
    
    // This is for you to implement
    //
    // This method takes a single argument (name) and 
    // returns all the indirect "friends" of that name
    //
    // For example, A & B are friends, B & C are friends and C & D are friends.
    // getInirectFriends(A) would return C and D
	//
    // Note: It should not return duplicate names
    // Note: Don't forget to write tests to have good test coverage for this method
    public List<String> getIndirectFriends(String name) {
        LinkedList<String> queue = new LinkedList<String>();
        List<String> result = new ArrayList<String>();
        Set<String> visitedSet = new HashSet<String>();
        if(!friendMap.containsKey(name)) return null;
        queue.add(name);
        while(!queue.isEmpty()){
        	String sourceName = queue.poll();
        	result.add(sourceName);
        	visitedSet.add(sourceName);
        	Set<String> friends = friendMap.get(sourceName);
        	for(String friend : friends){
        		if(!visitedSet.contains(friend)){
        			queue.add(friend);
        		}
        	}
        }
        return result;
    }
}
