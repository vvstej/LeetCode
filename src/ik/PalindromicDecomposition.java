package ik;

import java.util.HashMap;
import java.util.Set;
import java.util.*;

public class PalindromicDecomposition {

	/*
     * Complete the function below.
     */
    static String[] palindromicDecomposition(String strInput) {
        if(strInput == null) {
            return null;
        }
        if(strInput.length() == 0) {
            return new String[]{};
        }
        Map<String, Set<String>> memMap = new HashMap<String, Set<String>>();
        pdHelper(strInput, memMap);
        Set<String> resultSet = memMap.get(strInput);
        String[] results = new String[resultSet.size()];
        int i=0;
        for(String str : resultSet) {
            results[i++] = str + "|";
        }
        return results;
    }

    static void pdHelper(String input, Map<String, Set<String>> memMap) {
        if(memMap.containsKey(input)) {
            return;
        }
        if(input.length()==1) {
            Set<String> result = new LinkedHashSet<String>();
            result.add(input);
            memMap.put(input, result);
            return;
        }
        Set<String> curr = new LinkedHashSet<String>();
        for(int i=0;i<input.length()-1;i++) {
        	String subString1 = input.substring(0, i+1);
        	String subString2 = input.substring(i+1, input.length());
        	pdHelper(subString1, memMap);
            pdHelper(subString2, memMap);
            
            Set<String> prev1Results = memMap.get(subString1);
            Set<String> prev2Results = memMap.get(subString2);
            
            for(String prev1 : prev1Results) {
            	for(String prev2 : prev2Results) {
                    curr.add(prev1 + "|" + prev2);
                }
            }
        }
        if(input.equals(new StringBuilder(input).reverse().toString())) {
            curr.add(input);
        }
        memMap.put(input, curr);
        return;
    }
    
    public static void main(String[] arg){
    	
    	String[] results = PalindromicDecomposition.palindromicDecomposition("eveaba");
    	for(String result : results) {
    		System.out.println(result);
    	}
    }
}
