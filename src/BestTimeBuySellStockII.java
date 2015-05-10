/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length < 2)
            return max;
       
        int c_idx = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1] ) {
                max += prices[i-1] - prices[c_idx];
                c_idx =i;
            }
        }
        
        if (c_idx != prices.length - 1)
            max += prices[prices.length - 1] - prices[c_idx];
        
        return max;
        
    }
}
