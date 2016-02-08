package medium;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    public List<List<Integer>> permute(int[] nums) {
    	if(nums.length==0){
    		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
    		return finalList;
    	}
    	if(nums.length==1){
    		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(nums[0]);
            finalList.add(list1);
            return finalList;
    	}
        if(nums.length==2){
            List<List<Integer>> finalList = new ArrayList<List<Integer>>();
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(nums[0]);
            list1.add(nums[1]);
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(nums[1]);
            list2.add(nums[0]);
            finalList.add(list1);
            finalList.add(list2);
            return finalList;
        }
        int currLength = nums.length;
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int[] first = new int[currLength-1];
            //int[] second = new int[currLength-(i+1)];
            System.arraycopy(nums,0,first,0,(i-0));
            System.arraycopy(nums,i+1,first,i,currLength-(i+1));
            List<List<Integer>> prevList = permute(first);
            
            for(List<Integer> subList : prevList){
                List<Integer> newSubList = new ArrayList<Integer>();
                newSubList.add(nums[i]);
                newSubList.addAll(subList);
                newList.add(newSubList);
            }
        }
        return newList;
    }
    
    public static void main(String[] arg){
    	List<List<Integer>> newList = new ArrayPermutations().permute(new int[]{1,2,3});
    	for(List<Integer> list : newList){
    		for(int i : list){
    			System.out.print(i);
    		}
    		System.out.println();
    	}
    	System.out.println(newList.size());
    }
}
