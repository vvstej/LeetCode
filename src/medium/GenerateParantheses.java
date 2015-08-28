package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParantheses {

	public List<String> generateParantheses(int n){
		if(n==0){
			return new ArrayList<String>();
		}
		if(n==1){
			List<String> paranList = new ArrayList<String>();
			paranList.add("()");
			return paranList;
		}
		List<String> parentParans = generateParantheses(n-1);
		Set<String> allCombinationsSet = new HashSet<String>();
		for(String parentParan: parentParans){
			for(int i=0;i<parentParan.length(); i++){
				if(parentParan.charAt(i)=='('){
					StringBuilder leftInsert = new StringBuilder(parentParan);
					leftInsert.insert(i, "()");
					allCombinationsSet.add(leftInsert.toString());
					StringBuilder insideInsert = new StringBuilder(parentParan);
					insideInsert.insert(i+1, "()");
					allCombinationsSet.add(insideInsert.toString());
				}
				else{
					StringBuilder rightInsert = new StringBuilder(parentParan);
					rightInsert.insert(i+1, "()");				
					allCombinationsSet.add(rightInsert.toString());
				}
				
				
			}
		}
		List<String> allCombinationsList = new ArrayList<String>(allCombinationsSet);
		return allCombinationsList;
		
	}
	
	public static void main(String[] arg){
		System.out.println(new GenerateParantheses().generateParantheses(1));
	}
}
