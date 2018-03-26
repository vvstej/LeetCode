package ik;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SubsetPartition {

	//Queue q = new ConcurrentLinkedQueue<>();
	private static boolean subsetPartition(int[] arr) {
		int count = 0;
		for (int val : arr) {
			count += val;
		}
		if (count % 2 != 0)
			return false;
		int target = count / 2;
		boolean dp[][] = new boolean[arr.length + 1][target];
		dp[0][0] = true;

		for (int j = 1; j < dp[0].length; ++j) {
			dp[0][j] = false;
		}

		for (int i = 1; i < dp.length; ++i) {
			dp[i][0] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; ++j) {
				dp[i][j] = dp[i - 1][j];
				if (j >= arr[i - 1]) {
					dp[i][j] = (dp[i][j] || dp[i - 1][j - arr[i - 1]]);
				}
			}
		}
		List<Integer> subset = new ArrayList<>();
		int x = arr.length;
		int y = target;
		for (int i = 1; i <= arr.length; i++) {
			int curr = arr[i - 1];
			if (y == 0)
				break;
			if (dp[x - 1][y - curr]) {
				x = x - 1;
				y = y - curr;
				subset.add(curr);
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];

	}
	
	private static void recursiveFind(List<Integer> subset, int[] arr, int index, int[][] dp, int[] dpIndex) {
		int curr = arr[index];
		
	}

	public static void main(String[] arg) {
		System.out.println(subsetPartition(new int[] { 1, 23 }));
	}
}
