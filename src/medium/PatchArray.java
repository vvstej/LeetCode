package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PatchArray {
	public int minPatches(int[] nums, int n) {

		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int minPatches = 0;
		Set<Integer> cache = new HashSet<Integer>();
		for (int sum = n; sum >= 0; sum--) {
			int remainingSum = sum;
			for (int i = numsList.size() - 1; i >= 0; i--) {
				if(cache.contains(remainingSum)) break;
				if (remainingSum >= numsList.get(i)) {
					remainingSum -= numsList.get(i);
				}
			}
			if (remainingSum > 0) {
				numsList.add(remainingSum);
				System.out.println(remainingSum);
				Collections.sort(numsList);
				minPatches++;
			}
			cache.add(sum);
		}
		
		return minPatches;

	}
	
	public static void main(String[] arg){
		int [] nums = new int[]{1,2,31,33};
		System.out.println(new PatchArray().minPatches(nums,99));
	}
}
