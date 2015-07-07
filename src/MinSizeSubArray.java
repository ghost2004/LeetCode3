/*
 * Given an array of n positive integers and a positive integer s, find the
 *  minimal length of a subarray of which the sum ¡Ý s. If there isn't one, 
 *  return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int out = nums.length + 1;
        int left = 0;   // left pointer
        int right = 0;  // right pointer
        int sum = 0;
        while ( right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                // one element will match the result , return 1
                if (right  == left) 
                    return 1;
                // check the minimal length
                out = Math.min(out, right-left+1);
                // move the left pointer
                sum -= nums[left];
                left++;
            }
            // move the right pointer
            right++;
        }

        if (out > nums.length)
            return 0;
        return out;
    }

}
