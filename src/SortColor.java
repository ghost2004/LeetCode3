/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same 
 * color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number 
of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColor {
    // 2 pass solution
    public void sortColors2Pass(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        // counters array for different colors
        int cnt[] = new int[3];
        int i;
        // count the number for different colors
        for (i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int idx = 0;
        // restore the array by counters
        for (i = 0; i < nums.length; i++) {
            while (cnt[idx] == 0)
                idx++;
            nums[i] = idx;
            cnt[idx]--;
        }
        
    }
    
    // 1 pass solution
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        // next index of red element, start from left to right
        int redIdx = 0;
        // next index of blue element, start from right to left
        int blueIdx = nums.length-1;
        // current index
        int idx = 0;
        // stop the loop when current index passed blue index
        while (idx < blueIdx+1) {
            switch (nums[idx]) {
            // red color case
            case 0:
                // swap the current value with red index
                nums[idx] = nums[redIdx];
                nums[redIdx] = 0;
                // move red index to right
                redIdx++;
                // move current index to right
                idx++;
                break;
            // white color case
            case 1:
                // just move the current index to right
                idx++;
                break;
            // blue color case
            case 2:
                // swap the current value with blue idx
                nums[idx] = nums[blueIdx];
                nums[blueIdx] = 2;
                // move blue index to left
                blueIdx--;
                break;
            }
        }
        
    }

}
