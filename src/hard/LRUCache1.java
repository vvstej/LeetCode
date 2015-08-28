package hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache1 {
	Map<Integer, LRUElement> lookupMap;
	
	Deque<LRUElement> lruQueue;
	int capacity = 0;

	public LRUCache1(int capacity) {
		lookupMap = new HashMap<Integer, LRUElement>(capacity);
		
		lruQueue = new LinkedList<LRUElement>();
		this.capacity = capacity;
	}

	public int get(int key) {
		boolean hasKey = lookupMap.containsKey(key);
		if (hasKey) {
			LRUElement elem = lookupMap.get(key);
//			lruQueue.remove();
//			elem.setTimeStampEpoch(System.currentTimeMillis());
//			lruQueue.add(elem);
			return elem.getValue();
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {     
            boolean hasKey = lookupMap.containsKey(key);
            LRUElement elem = null;
            if(!hasKey){
            	if(lruQueue.size()==capacity){
            		lruQueue.poll();
            	}
            	elem = new LRUElement(System.currentTimeMillis(), key, value);
            	lruQueue.offer(elem);
                lookupMap.put(key,elem);  
            }else{
            	elem = lookupMap.get(key);
            	elem.setValue(value);
            	
            }
            	      
    }
	
	public static void main(String[] arg){
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 2);
		System.out.println(cache.get(2));
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.println(cache.get(2));
	}
}
