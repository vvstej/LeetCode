package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSum {
	public int[] twoSum(int[] nums, int target){
		List<Integer> sortedNums = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			sortedNums.add(nums[i]);
		}
		Collections.sort(sortedNums);
		for(int source=0;source<sortedNums.size();source++){
			if(sortedNums.get(source) <= target){
				int index = search(sortedNums,source+1,sortedNums.size()-1, target-sortedNums.get(source));
				if(index>=0){
					return new int[]{source,index};
				}
				else{
					continue;
				}
			}
			else{
				return new int[]{};
			}
		}
		return new int[]{};
		
	}

	private int search(List<Integer> sortedNums, int begin, int end, int target) {
		int midPoint = (begin+end)/2;
		if(begin==end && sortedNums.get(midPoint)!=target){
			return -1;
		}
		if(target == sortedNums.get(midPoint)){
			return midPoint;
		}
		else if(target < sortedNums.get(midPoint)){
			return search(sortedNums, begin, midPoint-1, target);
		}
		else{
			return search(sortedNums, midPoint+1, end, target);
		}
	}
	
	public static void main(String[] arg){
		int [] nums = {4,2,3,9,6};
		int target = 12;
		int[] result = new TwoSum().twoSum(nums, target);
		if (result.length==0){
			System.out.println("No result");
		}
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

}
