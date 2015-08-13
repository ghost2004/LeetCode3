/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] 
 * is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as 
extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    // space O(n) solution
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        if (nums.length == 1)
            return nums;
        int i;
        int len = nums.length;
        
        int out[] = new int[len];
        // array for the product of all elements in left part  
        int left[] = new int[len];
        // array for the product of all elements in right part
        int right[] = new int[len];
        
        // most left element
        left[0] = 1;
        // most right element
        right[len-1] = 1;
        
        // fill up t1 array
        for (i = 0; i < len -1; i++) {
            left[i+1] = left[i] * nums[i];
        }
        
        // fill up t2 array
        for (i = len -1; i > 0; i--) {
            right[i-1] = right[i]* nums[i];
        }
               
        // t1 * t2 is the result
        for (i = 0; i < len; i++) {
            out[i] = left[i] * right[i];
        }
        return out;
    }
    
    // space O(1) solution
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        if (nums.length == 1)
            return nums;
        int i;
        int len = nums.length;
        
        int out[] = new int[len];
        
        out[0] = 1;
        // scan from left to right
        for (i = 0; i < len - 1;i++) {
            out[i+1] = out[i] * nums[i];
        }
        int t = nums[len-1];
        // scan from right to left
        for (i = len-1; i > 0; i--) {
            out[i - 1] *=t;
            t *= nums[i-1];
        }
        
        return out;
    }

}
