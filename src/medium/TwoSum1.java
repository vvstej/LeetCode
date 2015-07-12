package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum1 {
	public int[] twoSum(int[] nums, int target){
		for(int source=0;source<nums.length;source++){				
				int index = findIndex(target-nums[source],nums,source+1);
				if(index>=0){
					return new int[]{source+1,index+1};
				}
				else{
					continue;
				}
		}
		return new int[]{};
		
	}
	
	public int[] twoSumWithMap(int[] nums, int target){
		
		Map<Integer,List<Integer>> numToIndexMap = new HashMap<Integer, List<Integer>>();
		for(int source=0; source<nums.length;source++){
			List<Integer> indexList = null;
			if(numToIndexMap.get(nums[source])==null){
				indexList = new ArrayList<Integer>();
			}else{
				indexList = numToIndexMap.get(nums[source]);
			}
			indexList.add(source);
			numToIndexMap.put(nums[source], indexList);
		}
		for(int source=0;source<nums.length;source++){
			int remainder = target-nums[source];
			List<Integer> indexList = numToIndexMap.get(remainder);
			if(indexList==null){
				continue;
			}else{
				int index = indexList.get(0);
				if(index==source){
					if(indexList.size()==1){
						continue;
					}else{
						return new int[]{source+1, indexList.get(1)+1};
					}
				}
				return new int[]{source+1, indexList.get(0)+1};
			}
		}
		return new int[]{};
	}
		
	private int findIndex(int toFindElem, int[] nums, int source) {
		for(int i=source;i<nums.length;i++){
			if(nums[i]==toFindElem){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] arg){
		int [] nums = {3,2,4};
		int target = 6;
		int[] result = new TwoSum1().twoSumWithMap(nums, target);
		if (result.length==0){
			System.out.println("No result");
		}
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

}
