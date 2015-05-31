import java.util.Arrays;

/*
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place 
for his thievery so that he will not get too much attention. This time, all houses 
at this place are arranged in a circle. That means the first house is the neighbor
 of the last one. Meanwhile, the security system for these houses remain the same as
  for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        else if (length == 2)
            return Math.max(nums[0], nums[1]);
        int maxProfit = 0;
        
        int profit[] = new int[length];
        
        // first find the max profit when rob the last house
        profit[length-1] = nums[length-1];
        profit[length-2] = Math.max(nums[length-2], nums[length-1]);
        
        for (int i = length-3; i > 0 ; i--) {
            profit[i] = Math.max(profit[i+1], profit[i+2] + nums[i]);
        }
        maxProfit = profit[1];
        
        // second, find the max profit when rob the first house
        Arrays.fill(profit, 0);
        
        profit[0] = nums[0];
        profit[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < length-1 ; i++) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        
        // get the bigger number of 2 solutions
        maxProfit = Math.max(maxProfit, profit[length-2]);
         
        return maxProfit;
    }

}
