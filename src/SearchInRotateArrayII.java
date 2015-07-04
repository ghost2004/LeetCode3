/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
public class SearchInRotateArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) /2;
            if (nums[mid] ==  target || nums[left] ==  target || nums[right] ==  target)
                return true;
            if (nums[left] < nums[mid]) {
                // left part sorted
                if (target > nums[left] && target < nums[mid] ) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]){
                // right part sorted
                if (target < nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        
        return false;
    }

}
