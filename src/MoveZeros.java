/*
 * Given an array nums, write a function to move all 0's to the end of it while
 *  maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums 
should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int zeroCnt = 0;
        int nextIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (nextIdx == -1)
                    nextIdx = i;
                zeroCnt++;
            }  else if (nextIdx != -1) {
                nums[nextIdx] = nums[i];
                nextIdx++;
            }
        }
        if (zeroCnt == nums.length)
            return;
        for (int i = nums.length -zeroCnt; i <nums.length; i++ )
            nums[i] = 0;
    }

}
