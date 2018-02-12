package ik;

import java.util.Arrays;

public class TextJustification1 {

	static int[] minSpaceCost(String[] strArr, int lineWidth) {
		int[][] dp = new int[strArr.length + 1][strArr.length + 1];
		int[] c = new int[strArr.length + 1];
		int[] track = new int[strArr.length];
		c[0] = 0;

		for (int to = 0; to <= strArr.length; to++) {
			for (int from = 0; from <= strArr.length; from++) {
				if (to == 0 || from == 0) {
					dp[from][to] = 0;
					continue;
				}
				if (from - 1 + to > strArr.length) {
					break;
				}
				String[] rangeArr = Arrays.copyOfRange(strArr, from - 1, from - 1 + to);
				dp[from][from + to - 1] = cost(lineWidth, rangeArr);
			}
		}

		for (int i = 1; i <= strArr.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				int currCost = Integer.MAX_VALUE;
				if (c[j] != Integer.MAX_VALUE && dp[j + 1][i] != Integer.MAX_VALUE) {
					currCost = c[j] + dp[j + 1][i];
				}
				if (currCost < min) {
					min = currCost;
					track[i-1] = j;
				}
			}
			c[i] = min;
		}

		return track;

	}

	private static int cost(int lineWidth, String... words) {
		int totalCost = 0;
		for (String word : words) {
			totalCost += word.length() + 1;
		}
		totalCost--;
		if (totalCost <= lineWidth) {
			return (int) Math.pow((lineWidth - totalCost), 3);
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public static void main(String[] arg) {

		int[] res = minSpaceCost(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
		backTrackDPTable(res, 6, 7);
	}

	private static void backTrackDPTable(int[] res, int index, int prev) {
		if (index < 0)
			return;
		int curr = res[index];
		System.out.println("From: " + curr + " to " + prev);
		backTrackDPTable(res, curr-1, curr);

	}

}
