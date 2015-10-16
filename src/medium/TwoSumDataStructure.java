package medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TwoSumDataStructure {
	Map<Integer,Integer> presenceMap = new HashMap<Integer,Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	   if(presenceMap.get(number)==null){
	       presenceMap.put(number,1);
	   }else{
	       int val = presenceMap.get(number);
	       presenceMap.put(number,++val);
	   } 
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    Set<Integer> keys = presenceMap.keySet();
	    
	    if(keys!=null){
	        Iterator<Integer> keyIterator = presenceMap.keySet().iterator();
	        if(keys.size()==1 && presenceMap.get(keyIterator.next())==1){
	        return false;
	        }
	        keyIterator = presenceMap.keySet().iterator();
	        while(keyIterator.hasNext()){
	           int num = keyIterator.next();
	           if(presenceMap.get(value-num)!=null){
	               if((value-num)==num){
	                   int count = presenceMap.get(value-num);
	                   if(count > 1){
	                       return true;
	                   }else{
	                       return false;
	                   }
	               }else{
	                   return true;
	               }   
	           }
	        }
	    }
		return false;
	    
	}
		public static void main(String[] arg){
			TwoSumDataStructure sum = new TwoSumDataStructure();
			sum.add(0);
			sum.add(0);
			sum.add(-1);
			sum.add(-1);
			//sum.add(5);
			System.out.println(sum.find(-2));
			System.out.println(sum.find(0));
			System.out.println(sum.find(-1));
			System.out.println(sum.find(1));
		}
}
