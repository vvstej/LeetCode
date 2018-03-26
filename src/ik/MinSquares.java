package ik;

import java.util.Arrays;

public class MinSquares {

	public static int numSquares(int n) {
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int diff = 1;
		int diff1 = 1;
		int nextSquare = 1;
		for (int i = 1; i <= n; ++i) {
			if (i == nextSquare) {
				dp[i] = 1;
				diff += 2;
				nextSquare = i + diff;
				continue;
			}
			diff1 = 1;
			for (int j = 1; j <= i / 2; diff1 += 2, j += diff1) {
				int first = dp[j];
				int second = dp[i - j];
				if (first != Integer.MAX_VALUE && second != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], first + second);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] arg) {
		System.out.println(numSquares(711));
	}
}
