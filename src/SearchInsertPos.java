/*
 * Given a sorted array and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0
 */
public class SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (nums[0] >= target ) 
            return 0;
        else if (nums[len-1] < target)
            return len;
        
        int left = 0;
        int right = len - 1;
        
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else 
                right = mid -1;
        }
        
        return left;
    }
}
