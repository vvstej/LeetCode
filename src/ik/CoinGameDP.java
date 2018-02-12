package ik;

public class CoinGameDP {

	static int maxWin(int[] intCoins) {
        int[][] dp = new int[intCoins.length][intCoins.length];
        for(int i=0;i<intCoins.length;i++) {
            dp[i][i] = intCoins[i];
        }
        for(int i=0;i<intCoins.length-1;i++) {
            dp[i][i+1] = Math.max(intCoins[i], intCoins[i+1]);
        }
        
        for(int len=3;len<=intCoins.length; ++len) {
            for(int i=intCoins.length-len;i>=0;--i) {
                int end = i+len-1;
                dp[i][end] = Math.max(dp[i][i] + Math.min(dp[i+2][end],dp[i+1][end-1]),
                                      dp[end][end] + Math.min(dp[i][end-2], dp[i+1][end-1]));
            }
        }
        
        return dp[0][intCoins.length-1];
        
    }
	
	public static void main(String[] arg) {
		System.out.println(maxWin(new int[]{149,154,63,242,12,72,65}));
	}
}
