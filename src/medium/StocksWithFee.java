package medium;

public class StocksWithFee {

    public int maxProfit(int[] prices, int fee) {
        if(prices.length==0) return 0;
        int[] profit = new int[prices.length];
        profit[0] = 0;
        for(int i=1;i<prices.length;i++) {
            int maxProfit = Integer.MIN_VALUE;
            for(int j=0;j<i;j++) {
                int diff = prices[i] - prices[j] - fee;
                if(diff > 0) {
                    maxProfit = Math.max(maxProfit, profit[j] + diff);
                }
            }
            if(maxProfit!=Integer.MIN_VALUE) {
            	profit[i] = Math.max(maxProfit, profit[i-1]);
            }               
            else profit[i] = profit[i-1];
        }
        return profit[prices.length-1];
    }
}
