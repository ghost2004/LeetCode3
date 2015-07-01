/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinInRotate {
    
    public int findMin3(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.min(nums[0],nums[1]);
        
        int start = 0;
        int end = nums.length - 1;
        int min = nums[0];
        while (start < end-1) {
            int mid = (start + end)/2;
            if (nums[start] < nums[mid]) {
                // left side sorted
                min = Math.min(min, nums[start]);
                // search in right side
                start = mid + 1;
            } else if (nums[start] > nums[mid]) {
                // right side sorted
                min = Math.min(min, nums[mid]);
                end = mid -1;
            }

            
        }
        
        min = Math.min(min, nums[start]);
        min = Math.min(min, nums[end]);
        return min;
    }
    
    public int findMinRange(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        if (left == right - 1)
            return Math.min(nums[left], nums[right]);
        
        int mid = (left+right) / 2;
        if (nums[left] < nums[mid]) {
            // left side sorted
            return Math.min(nums[left], findMinRange(nums, mid+1,right));
        } else {
            // right side sorted
            return Math.min(nums[mid], findMinRange(nums, left, mid-1));
        }
        
    }
    
    public int findMin(int[] nums) {
        return findMinRange(nums, 0, nums.length-1);
    }

}
