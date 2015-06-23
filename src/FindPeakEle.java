/*
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Ş.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakEle {
    public int findPeakElement_v1(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
            
        if (nums[0] > nums[1])
            return 0;
        
        
        for (int i = 1; i < nums.length-1 ; i++) {
            if (nums[i] > nums[i+1] && nums[i] > nums[i-1]) 
                return i;
        }
            
        return nums.length-1;
    }
    
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        
        int start = 0;
        int end = nums.length - 1;
        
        int mid = 0;
        while (start <= end) {
            mid = (end + start)/2;
            if ((mid == 0 || nums[mid-1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid] >= nums[mid+1] ))
                return mid;
            if (mid > 0 && nums[mid-1] >= nums[mid] )
                end = mid - 1;
            else 
                start = mid+1;
        }
        
        return mid;
    }
}
