package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSetGeneration {

	public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            List<List<Integer>> finalList = new ArrayList<List<Integer>>();
            return finalList;
        }
        if(nums.length==1){
        	List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        	List<Integer> list1 = new ArrayList<Integer>();
        	List<Integer> list2 = new ArrayList<Integer>();
        	list1.add(nums[0]);
        	finalList.add(list1);
        	finalList.add(list2);
        	return finalList;
        }
        Arrays.sort(nums);
        List<List<Integer>> finalList = recursiveSubset(nums);
        List<Integer> emptyList = new ArrayList<Integer>();
        finalList.add(emptyList);
		return finalList;
    }
    
    public List<List<Integer>> recursiveSubset(int [] nums){
        if(nums.length==2){
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(nums[0]);
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(nums[1]);
            List<Integer> list3 = new ArrayList<Integer>();
            list3.add(nums[0]);
            list3.add(nums[1]);
            List<List<Integer>> finalList = new ArrayList<List<Integer>>();
            finalList.add(list1);
            finalList.add(list2);
            finalList.add(list3);
            return finalList;
        }
        int [] newNums = Arrays.copyOfRange(nums,1,nums.length);
        List<List<Integer>> subList = recursiveSubset(newNums);
        List<List<Integer>> newSubList = new ArrayList<List<Integer>>(subList.size());
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for(List<Integer> subsubList : subList){
        	List<Integer> intermediateNewList = new ArrayList<Integer>();
        	for(Integer val : subsubList){
        		intermediateNewList.add(val);
        	}
        	newSubList.add(intermediateNewList);
        }
        for(List<Integer> subsubList : newSubList){
            subsubList.add(0,nums[0]);
            finalList.add(subsubList);
        }
        List<Integer> listWith0thVal = new ArrayList<Integer>();
        listWith0thVal.add(nums[0]);
        finalList.add(listWith0thVal);
        finalList.addAll(subList);
        return finalList;
    }
	
	public static void main(String[] arg){
		System.out.println(new SubSetGeneration().subsets(new int[]{1,2,3,1,5}));
	}
}
