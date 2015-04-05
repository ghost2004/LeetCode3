/*
 * You are a professional robber planning to rob houses along a street.
 *  Each house has a certain amount of money stashed, the only constraint 
 *  stopping you from robbing each of them is that adjacent houses have
 *   security system connected and it will automatically contact the police
 *    if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each 
house, determine the maximum amount of money you can rob tonight without
 alerting the police.
 */
public class HouseRobber {

    public int rob(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int len = num.length;
        int maxProfit[] = new int [num.length];
        if (len == 1)
            return num[0];
        if (len == 2)
            return Math.max(num[0], num[1]);
        
        maxProfit[len-1] = num[len-1];
        maxProfit[len-2] = Math.max(num[len-1], num[len-2]);
        
        for (int i = len-3; i >= 0;i--) {
            maxProfit[i] = Math.max(num[i]+maxProfit[i+2] , maxProfit[i+1] );
        }

        return maxProfit[0];
        
    }
    
    public int rob2(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        int len = num.length;

        if (len == 1)
            return num[0];
        if (len == 2)
            return Math.max(num[0], num[1]);
        int a = num[len-1];
        int b = Math.max(num[len-1], num[len-2]);
        int c = 0;
        
        for (int i = len-3; i >= 0;i--) {
            c = Math.max(num[i]+a, b);
            a = b;
            b = c;
        }

        return c;
    }
}
