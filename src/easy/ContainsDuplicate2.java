package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

	public boolean containsNearlyDuplicate(int [] nums, int k){
		Map<Integer,Integer> valueToIndexMap = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			int val = nums[i];
			int index = valueToIndexMap.containsKey(val) ? valueToIndexMap.get(val) : -1;
			if(index >= 0){
				if (Math.abs(i-index) <=k){
					return true;
				}else{
					//replace old index with new
					valueToIndexMap.put(val, i);
				}
			}else{
				valueToIndexMap.put(val, i);
			}
		}
		return false;
	}
	
	public static void main(String[] arg){
		int [] nums = new int[]{1,0,1,1};
		System.out.println(new ContainsDuplicate2().containsNearlyDuplicate(nums, 1));
	}
}
