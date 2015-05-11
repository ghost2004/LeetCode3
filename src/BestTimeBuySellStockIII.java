/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length < 2)
            return max;
        int size = prices.length;
        
        int profitLeft[] = new int[size];
        int profitRight = 0;
        
        int i;
        int curMin = prices[0];
        int curMax = prices[size-1];
        profitLeft[0] = 0;

        for (i = 1; i < size; i++) {
            curMin = Math.min(curMin, prices[i]);
            profitLeft[i] = Math.max(profitLeft[i-1], prices[i] - curMin);
        }
        
        max = profitLeft[size-1];
        
        for (i = size-2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            profitRight = Math.max(profitRight, curMax - prices[i]);
            max = Math.max(max, profitLeft[i] + profitRight);
            
        }
        
        return max;
    }
}
