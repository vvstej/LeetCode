package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberDictSort {

	public String largestNumber(int[] nums) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			result.add(Integer.toString(nums[i]));
		}
		Collections.sort(result, Collections.reverseOrder());
		StringBuilder ret = new StringBuilder();
		for (String res : result) {
			ret.append(res);
		}
		return ret.toString();
	}
	
	public static void main(String[] arg) {
		int[] nums = new int[]{3, 30, 34, 5, 9,90};
		System.out.println(new LargestNumberDictSort().largestNumber(nums));
	}
}
