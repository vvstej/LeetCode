package ik;

/**
 * 0-1 because , for every weight you either include an item or exclude it.
 * Use this technique for subset selection problems in general.
 * @author venkata.vepa
 *
 */
public class Knapsack01 {

	// int[i][j] stands for max value that sack can hold where weight <=j with i
	// items.
	private static int knapSack(int W, int[] w, int[] v, int n) {
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][W];

	}
	
	public static void main(String[] arg){
		System.out.print(knapSack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 3));
	}
}
