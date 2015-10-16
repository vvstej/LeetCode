package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
    	if(s==null || s.length()<=10){
    		List<String> resultList = new ArrayList<String>();
    		return resultList;
    	}
    	List<String> resultList = new ArrayList<String>();
    	Map<String, Integer> dnaMap = new HashMap<String,Integer>();
    	for(int i=0;i<=s.length()-10;i++){
    		String subStr = s.substring(i, i+10);
    		if(dnaMap.get(subStr) != null){
    			Integer count = dnaMap.get(subStr);
    			if(count==1)
    				resultList.add(subStr);
    			dnaMap.put(subStr, ++count);
    		}else{
    			dnaMap.put(subStr,1);
    		}
    	}
		return resultList;
        
    }
    
    public static void main(String[] arg){
    	List<String> resultList = new RepeatedDNASequence().findRepeatedDnaSequences("AAAAAAAAAAAA");
    	for(String str : resultList){
    		System.out.println(str);
    	}
    }
}
