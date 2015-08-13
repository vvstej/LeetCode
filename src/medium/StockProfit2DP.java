package medium;

public class StockProfit2DP {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int[] profit = new int[prices.length];
		int maxProfitTillNow = 0;
		int maxProfit = 0;
		int lastBought = 0;
		profit[0] = 0;
		profit[1] = (prices[0] < prices[1]) ? (prices[1] - prices[0]) : 0;
		if (profit[1] > 0) {
			maxProfit = profit[1];
		} else {
			lastBought = 1;
		}
		for (int i = 2; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				profit[i] = prices[i] - prices[lastBought];
				if (profit[i] > maxProfit) {
					maxProfit = profit[i];

				}
			} else {
				profit[i] = 0;
				maxProfitTillNow+=profit[i - 1];
				maxProfit=0;
				lastBought = i;
			}
		}
		if(maxProfit > 0){
			maxProfitTillNow+=maxProfit;
		}
		return maxProfitTillNow;
	}

	public static void main(String[] arg) {
		int[] stocks = new int[] { 3,2,6,5,0,3 };
		System.out.println(new StockProfit2DP().maxProfit(stocks));
	}
}
