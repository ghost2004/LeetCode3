/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        // max steps so far
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // get the max steps from this point
            max = Math.max(max, i + nums[i]);
            // reach the end of array, return true
            if (max >= nums.length-1)
                return true;
            // the max steps is here, return false
            if (max <= i )
                return false;
            
        }
        
        return false;
        
    }
    
    public static void main(String args[]) {
        JumpGame j = new JumpGame();
        int t1[] = {0};
        System.out.println(j.canJump(t1));
    }

}

class JumpGameFailed {
    public boolean canJump(int nums[], int idx) {
        if (nums[idx] >= nums.length - idx -1)
            return true;
        
        for (int i = nums[idx]; i > 0 ; i--) {
            if (canJump(nums, idx+i))
                return true;
            
        }
        
        return false;
    }
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        return canJump(nums, 0);
    }
}