package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0) {
			List<List<Integer>> combList = new ArrayList<List<Integer>>();
			return combList;
		}
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		recursiveFind(candidates, target, 0, 0, result, new ArrayList<Integer>());
		return result;
	}

	public void recursiveFind(int[] candidates, int targetSum,
			int targetIndex, int currentSum, List<List<Integer>> resultList,
			List<Integer> currentList) {
		if (currentSum + candidates[targetIndex] > targetSum) {
			return;
		}
		for (int i = targetIndex; i < candidates.length; i++) {
			if (currentSum + candidates[i] < targetSum) {	
				List<Integer> newList = new ArrayList<Integer>();
				for(int val : currentList){
					newList.add(val);
				}
				newList.add(candidates[i]);
				recursiveFind(candidates, targetSum, i,
						currentSum + candidates[i], resultList, newList);
				
			} else if(currentSum + candidates[i] == targetSum){
				List<Integer> newList = new ArrayList<Integer>();
				for(int val : currentList){
					newList.add(val);
				}
				newList.add(candidates[i]);				
				resultList.add(newList);
				return;
			}
			else {
				return;
			}
		}
	}
	
	public static void main(String[] arg){
		List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{1,2,3,4,5,6,7},7);
		for(List<Integer> resultList : result){
			for(int i: resultList){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
