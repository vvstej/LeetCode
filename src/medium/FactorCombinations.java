package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorCombinations {
	   public List<List<Integer>> getFactors(int n) {
	        List<List<Integer>> allFactors = new ArrayList<>();
	        List<Integer> currFactors = new ArrayList<>();
	        
	        helper(n, currFactors, allFactors);
	        
	        return allFactors;
	    }
	    
	    public void helper(int n, List<Integer> curr, List<List<Integer>> all){
	        if(n == 1) return;
	        
	        for(int i = 2; i <= Math.sqrt(n); i++){
	            boolean visited = curr.size() > 0 && i < curr.get(curr.size() - 1);
	            if(n % i == 0 && !visited){
	                int dividend = n / i;
	                List<Integer> newCurr = new ArrayList<>(curr);
	                newCurr.add(i);
	                helper(dividend, newCurr, all);
	                newCurr.add(dividend);
	                all.add(newCurr);
	            }
	        }
	    }
	

	public static void main(String[] arg) {
		new FactorCombinations().getFactors(8);
	}
}
