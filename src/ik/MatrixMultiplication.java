package ik;

public class MatrixMultiplication {

	static int minMultiplicationCost(int[] mtxSizes) {
		if (mtxSizes.length < 3)
			return 0;
		int[][] mtx = new int[mtxSizes.length - 1][2];
		for (int i = 1; i < mtxSizes.length; ++i) {
			mtx[i - 1][0] = mtxSizes[i - 1];
			mtx[i - 1][1] = mtxSizes[i];
		}

		int[][] dp = new int[mtx.length][mtx.length];

		for (int j = 1; j < mtx.length; j++) {
			for (int i = 0; i < mtx.length - j; i++) {
				int min = Integer.MAX_VALUE;
				for (int k = i + j - 1; k >= i; --k) {
					int sum1 = dp[i][k];
					int sum2 = dp[k + 1][i + j];
					int total = sum1 + sum2 + (mtx[i][0] * mtx[i + j][1] * mtx[k][1]);
					min = Math.min(min, total);
				}
				dp[i][i + j] = min;
			}
		}
		return dp[0][mtx.length-1];
	}

	public static void main(String[] arg) {
		System.out.print(minMultiplicationCost(new int[] { 40, 20, 30, 10, 30 }));
	}
}
