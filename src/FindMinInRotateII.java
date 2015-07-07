/*
 * Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinInRotateII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] >= nums[right]) {
            int mid = (left+right)/2;
            if (nums[left] < nums[mid]) {
                left = mid+1;
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left++;
            }
        }
        
        return nums[left];
    }
}
