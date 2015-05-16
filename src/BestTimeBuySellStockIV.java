/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIV {
    private int maxP(int[] prices) {
        int max = 0;
        int i;
        for (i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        
        return max;
    }
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) 
            return 0;
        int len = prices.length;
        if (k >= len) 
            return maxP(prices);
        int local[][] = new int[len][k+1];
        int global[][] = new int[len][k+1];

        
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++){
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
                
                
    }
}
