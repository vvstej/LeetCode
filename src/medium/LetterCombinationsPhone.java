package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhone {

	private static Map<Character,List<String>> mapping = new HashMap<Character,List<String>>();
	static{
		mapping.put('2', Arrays.asList(new String[]{"a","b","c"}));
		mapping.put('3', Arrays.asList(new String[]{"d","e","f"}));
		mapping.put('4', Arrays.asList(new String[]{"g","h","i"}));
		mapping.put('5', Arrays.asList(new String[]{"j","k","l"}));
		mapping.put('6', Arrays.asList(new String[]{"m","n","o"}));
		mapping.put('7', Arrays.asList(new String[]{"p","q","r","s"}));
		mapping.put('8', Arrays.asList(new String[]{"t","u","v"}));
		mapping.put('9', Arrays.asList(new String[]{"w","x","y","z"}));
//		mapping.put('4', Arrays.asList(new String[]{"g","h","i"}));
	}
	public List<String> letterCombinations(String digits){
		if(digits==null || digits.length()==0){
			return new ArrayList<String>();
		}
		if(digits.length()==1){
			return mapping.get(digits.charAt(0));
		}
		List<String> prevList = letterCombinations(digits.substring(0,digits.length()-1));
		List<String> currCharList = mapping.get(digits.charAt(digits.length()-1));
		List<String> currList = new ArrayList<String>();
		for(String prev : prevList){
			for(String curr: currCharList){
				currList.add(new StringBuilder(prev).append(curr).toString());
			}
		}
		return currList;
	}
	
	public static void main(String[] arg){
		List<String> results = new LetterCombinationsPhone().letterCombinations("234");
		for(String result : results){
			System.out.println(result);
		}
	}
}
