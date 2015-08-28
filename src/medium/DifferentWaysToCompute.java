package medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToCompute {

	//private static final List<Character> OPERATORS = new char[]{'+','*','-'};
	public List<Integer> diffWaysToCompute(String input){
		if(input==null || input.length()==0 ){
			return new ArrayList<Integer>();
		}
		if(input.length()==1){
			
		}
		for(int i=0;i<input.length();i++){
			if(input.charAt(0)=='+' || input.charAt(0)=='*' || input.charAt(0)=='-'){
				i++;
			}
			List<Integer> left = diffWaysToCompute(input.substring(0, i+1));
			List<Integer> right = diffWaysToCompute(input.substring(i+2));
			
		}
		return null;
	}
}
