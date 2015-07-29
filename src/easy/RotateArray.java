package easy;

import java.util.HashMap;
import java.util.Map;

public class RotateArray {

	public void rotate(int [] nums, int k){
		if(k<0) return;
		Map<Integer,Integer> indexToNumMap = new HashMap<Integer,Integer>();
		int length = nums.length;
		for(int i=0;i<length;i++){
			int netCycle = (k > length) ? k-length : k;
			int postRotationElem = (length-netCycle+i) % length;
			indexToNumMap.put(i, nums[postRotationElem]);
		}
		
		for(Integer index : indexToNumMap.keySet()){
			nums[index] = indexToNumMap.get(index);
		}
		
	}
	
	public static void main(String[] arg){
		int [] nums = new int[]{1,2,3,4,5,6,7};
		new RotateArray().rotate(nums, 10);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+",");
		}
		
	}
}
