package medium;

import java.util.Arrays;
import java.util.Collections;

public class LargestNumber {

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] numsStringArray = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numsStringArray[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(numsStringArray);
		String prev = numsStringArray[0];		
		for (int i = 1; i < numsStringArray.length; i++) {
			StringBuilder result = new StringBuilder();
			int prevLen = prev.length();
			int currLen = numsStringArray[i].length();
			if (currLen == prevLen) {
				result.append(numsStringArray[i]).append(prev);
			}
			if (prevLen > currLen) {
				int diff = numsStringArray[i].compareTo(prev.substring(0, prevLen - currLen));
				if (diff > 0) {
					result.append(numsStringArray[i]).append(prev);
				} else {
					result.append(prev).append(numsStringArray[i]);
				}
			} else {
				int diff = prev.compareTo(numsStringArray[i].substring(0, currLen - prevLen));
				if (diff > 0) {

					result.append(prev).append(numsStringArray[i]);
				} else {
					result.append(numsStringArray[i]).append(prev);
				}
			}
			prev = result.toString();
		}
		return prev;
		
	}
	
	public static void main(String[] arg){
		System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
	}

}
