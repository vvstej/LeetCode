package medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		Map<Integer, Integer> lcmMap = new HashMap<Integer, Integer>();
		lcmMap.put(0, 0);
		return coinChange(coins, amount, lcmMap);
	}

	public int coinChange(int[] coins, int amount, Map<Integer, Integer> lcmMap) {
		if (amount == 0)
			return 0;
		int currLeast = -1;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount) {
				Integer currLeastSubAmount = lcmMap.get(amount - coins[i]);
				if (currLeastSubAmount == null) {
					currLeastSubAmount = coinChange(coins, amount - coins[i], lcmMap);
				}
				if (currLeastSubAmount == -1)
					continue;
				Integer curr = lcmMap.get(amount);
				if (curr == null) {
					currLeast = currLeastSubAmount + 1;
				} else {
					currLeast = currLeastSubAmount + 1 < curr ? currLeastSubAmount + 1 : curr;
				}
				lcmMap.put(amount, currLeast);
			}
		}
		return lcmMap.get(amount) == null ? currLeast : lcmMap.get(amount);
	}

	public int coinChange2(int[] coins, int amount) {
		int[] lcm = new int[amount + 1];
		lcm[0] = 0;
		for (int i = 1; i <= amount; i++) {
			lcm[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int s = lcm[i - coins[j]];
					if (s != Integer.MAX_VALUE) {
						lcm[i] = Math.min(lcm[i], 1 + lcm[i - coins[j]]);
					}

				}
			}
		}
		return lcm[amount]==Integer.MAX_VALUE?-1:lcm[amount];
	}

	public static void main(String[] arg) {
		System.out.println(new CoinChange().coinChange2(new int[] { 186, 419, 83, 408 }, 6249));
	}
}
