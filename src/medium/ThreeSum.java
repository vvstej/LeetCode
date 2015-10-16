package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int []nums){
		if(nums.length==1 || nums.length ==2 || nums.length ==0){
			List<Integer> emptyList = new ArrayList<Integer>();
			List<List<Integer>> emptyPrimaryList = new ArrayList<List<Integer>>();
			emptyPrimaryList.add(emptyList);
			return emptyPrimaryList;
		}
		Arrays.sort(nums);
		if(nums.length==3){
			if(nums[0]+nums[1]+nums[2]==0){
				List<Integer> result1 = new ArrayList<Integer>();
				result1.add(nums[0]);
				result1.add(nums[1]);
				result1.add(nums[2]);
				List<List<Integer>> resultList = new ArrayList<List<Integer>>();
				resultList.add(result1);
				return resultList;
			}
		}
		
		int i = 0;
		int j= nums.length-1;
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		while(i<j){
			int diff = nums[i]+nums[j];
			if(diff<0){
				if(nums[j-1]+diff==0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[j-1]);
					result.add(nums[j]);
					resultList.add(result);
					i++;
					if(nums[j]==nums[j-1]){
						j--;
					}
				}else if(nums[j-1]+diff<0){
					i++;
				}else{
					j--;
				}
			}else if(diff>0){
				if(nums[i+1]+diff==0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[i+1]);
					result.add(nums[j]);
					resultList.add(result);
					j--;
					if(nums[i]==nums[i+1]){
						i++;
					}
				}else if(nums[i+1]+diff<0){
					i++;
				}else{
					j--;
				}
			}else {
				//diff==0
				if(nums[i+1]==0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[i+1]);
					result.add(nums[j]);
					resultList.add(result);
					j--;
				}else if(nums[j-1]==0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[j-1]);
					result.add(nums[j]);
					resultList.add(result);
					i++;
				}else{
					i++;
					j--;
				}
			}
		}
		return resultList;
	}
	
	public static void main(String[] arg){
		System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
}
