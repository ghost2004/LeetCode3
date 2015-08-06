/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int result = nums[0];
        // Maximal production of left side
        int prevMax = nums[0];
        // Minimal production of left side
        int prevMin = nums[0];
        
        for (int i=1; i < nums.length; i++) {
            // we can use either min value or max value
            // if min value is negative one, it could be positive this time
            int maxP = nums[i]*prevMax;
            int minP = nums[i]*prevMin;
            
            if (maxP < minP) {
                int tmp = maxP;
                maxP = minP;
                minP = tmp;
            }
            
            // this node can be used or not
            result = Math.max(result,  Math.max(nums[i], maxP));
            // update the max value
            prevMax = Math.max(nums[i], maxP);
            // update the min value
            prevMin = Math.min(nums[i], minP);
        }
        
        return result;
    }
}
