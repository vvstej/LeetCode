package hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
	LinkedHashMap<Integer, LRUElement> lookupMap;
	PriorityQueue<LRUElement> lruQueue;
	int capacity = 0;

	public LRUCache(int capacity) {
		lookupMap = new LinkedHashMap<Integer, LRUElement>(capacity,  0.75F, true){
			protected boolean removeEldestEntry(Map.Entry<Integer, LRUElement> element){
				return size() > capacity;
			}
		};
		
		//lruQueue = new PriorityQueue<LRUElement>(capacity);
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
            	elem = new LRUElement(System.currentTimeMillis(), key, value);
            }else{
            	elem = lookupMap.get(key);
            	elem.setValue(value);
            }
            	//lruQueue.add(elem);
                lookupMap.put(key,elem);        
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

class LRUElement implements Comparable<LRUElement> {
	private long timestampEpoch;
	private int key;
	private int value;

	public LRUElement(long time, int key, int value) {
		this.timestampEpoch = time;
		this.key = key;
		this.value = value;
	}

	public long getTimeStampEpoch() {
		return this.timestampEpoch;
	}

	public void setTimeStampEpoch(long time) {
		this.timestampEpoch = time;
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LRUElement other = (LRUElement) obj;
		if (key != other.key)
			return false;
		if (timestampEpoch != other.timestampEpoch)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		result = prime * result
				+ (int) (timestampEpoch ^ (timestampEpoch >>> 32));
		result = prime * result + value;
		return result;
	}

	@Override
	public int compareTo(LRUElement o) {
		LRUElement lruElem2 = (LRUElement) o;
		if (this.timestampEpoch < lruElem2.getTimeStampEpoch()) {
			return -1;
		} else if (this.timestampEpoch == lruElem2.getTimeStampEpoch()) {
			return 0;
		} else
			return 1;
	}

}
