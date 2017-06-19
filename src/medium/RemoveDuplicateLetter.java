package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetter {
	 public String removeDuplicateLetters(String s) {
	        Map<Character,Integer> presenceMap = new HashMap<Character,Integer>();
	        if(s==null || s.equals("")) return "";
	        char[] arr = s.toCharArray();
	        for(char a : arr){
	            Integer val = presenceMap.get(a);
	            if(val==null) val=1;
	            else val++;
	            presenceMap.put(a,val);
	        }
	        Arrays.sort(arr);
	        StringBuilder result = new StringBuilder();
	        for(int i=0;i<arr.length;){
	            char c = arr[i];
	            int count = presenceMap.get(c);
	            i+=count;
	            result.append(c);
	        }
	        return result.toString();
	    }
	 
	 public static void main(String[] arg){
		 System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters("cbacdcbc"));
	 }
}
