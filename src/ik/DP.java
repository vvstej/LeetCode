package ik;

public class DP {

    public static void main(String[] arg) {
        System.out.print(coinChange(17, new int[] {2, 3, 5, 6}));
    }

    static int coinChange(int sum, int[] d) {
        if (sum == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (sum >= d[i]) {
                int curr = 1 + coinChange(sum - d[i], d);
                min = Math.min(curr, min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    static int dpCoinChange(int sum, int[] d) {
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < d.length; j++) {
                if (i >= d[j]) {
                    int temp = dp[i - d[j]];
                    if (temp == Integer.MAX_VALUE)
                        continue;
                    int curr = 1 + temp;
                    min = Math.min(curr, min);

                }

            }
            dp[i] = min;
        }
        return dp[sum];
    }
}
