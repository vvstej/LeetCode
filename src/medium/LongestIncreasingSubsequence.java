package medium;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length==1) return 1;
		int currMax = 0;
		int [] dpArray = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			dpArray[i] = 1;
		}
		for (int i = 0; i < nums.length; i++) {
			for(int j=0;j<i;j++){
				if(nums[j] < nums[i]){
					if(dpArray[j]+1 > dpArray[i]){
						dpArray[i] = dpArray[j]+1;
					}
				}
			}
			if(dpArray[i] > currMax){
				currMax = dpArray[i];
			}
		}

		return currMax;
	}

	public static void main(String[] arg) {
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
	}
}
