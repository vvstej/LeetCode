package hard;

public class BurstBalloons {

	public static int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] nums2 = new int[nums.length + 2];
		nums2[0] = 1;
		nums2[nums2.length - 1] = 1;
		for (int i = 1; i < nums2.length - 1; i++) {
			nums2[i] = nums[i - 1];
		}
		int[][] dp = new int[nums2.length][nums2.length];
		dp[0][0] = 0;
		dp[nums2.length - 1][nums2.length - 1] = 0;

		for (int i = 1; i < nums2.length - 1; i++) {
			for (int j = i; j >= 1; --j) {
				for (int k = j; k <= i; k++) {
					dp[j][i] = Math.max(dp[j][i],
							dp[j][k - 1] + dp[k + 1][i] + (nums2[j - 1] * nums2[k] * nums2[i + 1]));
				}
			}
		}

		return dp[1][nums2.length - 2];
	}

	public static void main(String[] arg) {
		System.out.println(maxCoins(new int[] { 3, 1, 5, 8 }));
	}
}
