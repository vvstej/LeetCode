package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public List<String> anagrams(String[] strs) {
        List<String> results = new ArrayList<String>();
        if(strs.length==0){
            return results;
        }
        Map<String,List<String>> anagramMap = new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);
            if(anagramMap.get(sortedString)!=null){
                List<String> list = anagramMap.get(sortedString);
                list.add(s);
                anagramMap.put(sortedString,list);
            }
            else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                anagramMap.put(sortedString,list);
            }
        }
        for(String s : anagramMap.keySet()){
        	List<String> result = anagramMap.get(s);
        	if(result.size() > 1)
        		results.addAll(anagramMap.get(s));
        }
        return results;
    }
    
    
    public static void main(String [] arg){
    	String [] strs = new String[] {"abc"};
    	List<String> results = new Anagrams().anagrams(strs);
    	for(String s: results){
    		System.out.println(s);
    	}
    	
    }
}
