package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {

	Map<Integer, Map<String,Integer>> sameLengthMap = new HashMap<Integer,Map<String,Integer>>();
	Set<String> presenceSet = new HashSet<String>();
    public ValidWordAbbr(String[] dictionary) {
     for(String s : dictionary){
    	 presenceSet.add(s);
    	 Map<String, Integer> map = sameLengthMap.get(s.length());
    	 String key = new StringBuilder().append(s.charAt(0)).append(s.charAt(s.length()-1)).toString();
    	 if(map==null){
    		 map = new HashMap<String,Integer>();
    	 }
    	 Integer countOfStringsWithSameFirstAndLastChars = map.get(key);
    	 if(countOfStringsWithSameFirstAndLastChars==null){
    		 map.put(key, 1);
    	 }else{
    		 map.put(key, ++countOfStringsWithSameFirstAndLastChars);
    	 }
    	 
    	 sameLengthMap.put(s.length(), map);
     }
    }

    public boolean isUnique(String word) {
    	if(sameLengthMap.size()==0){
            return true;
        }
        	String key = new StringBuilder().append(word.charAt(0)).append(word.charAt(word.length()-1)).toString();
        	Map<String,Integer> map = sameLengthMap.get(word.length());
        	if(map==null){
        		return true;
        	}
        	Integer counter = map.get(key);
        	if(counter==null){
        		return true;
        	}else{
        		if(counter==1 && presenceSet.contains(word)){
        			return true;
        		}else{
        			return false;
        		}
        		
        	}
    }
    
    public static void main(String[] arg){
    	ValidWordAbbr wordAbbr = new ValidWordAbbr(new String[]{"dog"});
    	System.out.println(wordAbbr.isUnique("dig"));
    	System.out.println(wordAbbr.isUnique("dug"));
    	System.out.println(wordAbbr.isUnique("dag"));
    	System.out.println(wordAbbr.isUnique("dog"));
    	System.out.println(wordAbbr.isUnique("doge"));
    }
}
