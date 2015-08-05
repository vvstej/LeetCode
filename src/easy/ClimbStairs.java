package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
	 public long climbStairs(int n) {
		 Map<Integer,Long> memoryMap = new HashMap<Integer,Long>();
		 memoryMap.put(0, (long) 0);
		 memoryMap.put(1, 1L);
		 memoryMap.put(2, 2L);
		 return climbStairsWithMemoization(n, memoryMap);
	        
	    }
	 
	 public long climbStairsWithMemoization(int n, Map<Integer,Long> memoryMap){
		 if(memoryMap.containsKey(n)){
			 return memoryMap.get(n);
		 }else{
			 long a = memoryMap.containsKey(n-1)?memoryMap.get(n-1):climbStairsWithMemoization(n-1, memoryMap);
			 memoryMap.put(n-1, a);
			 Long b = memoryMap.containsKey(n-2)?memoryMap.get(n-2):climbStairsWithMemoization(n-2, memoryMap);
			 memoryMap.put(n-2, b);	
			 return a+b;
		 }
	 }
	 
	 public static void main(String[] arg){
		 System.out.println(new ClimbStairs().climbStairs(100));
	 }
}
