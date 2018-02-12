package ik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {

	private static int[] coinChange(int[] v, int c) {
		int[] dp = new int[c + 1];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int s = 1; s <= c; s++) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < v.length; i++) {
				if (s == v[i]) {
					min = 1;
					break;
				}
				if (s >= v[i] && dp[s - v[i]] != Integer.MAX_VALUE) {
					int count = 1 + dp[s - v[i]];
					min = Math.min(min, count);
				}
			}
			dp[s] = min;
		}
		return dp;
	}
	
	private static void findPaths(int[] v, int[] dp, int sumLeft, int coinsLeft, List<Integer> curr, Set<List<Integer>> res) {
		if(sumLeft==0 && coinsLeft==0) {
			res.add(new ArrayList<>(curr));
			return;
		}
		if(dp[sumLeft] > coinsLeft) {
			return;
		}
		
		for(int i=0;i<v.length;i++) {
			if(v[i] <= sumLeft) {
				curr.add(v[i]);
				findPaths(v,dp,sumLeft-v[i], coinsLeft-1,curr,res);
				curr.remove(curr.size()-1);
			}
		}
	}

	public static void main(String[] arg) {
		int[] dp = coinChange(new int[] { 9,6,5,1 }, 14);
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		findPaths(new int[]{9,6,5,1}, dp, 14, dp[14], curr, res);
		for(List<Integer> s: res) {
			Collections.sort(s);
			for(int v: s) {
				System.out.print(v + " ");
			}
			System.out.println("");
		}
	}
}
