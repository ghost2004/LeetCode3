/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 */
public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        
        
        while (lo < hi) {
            int left = lo;
            int right = hi;
            int key = nums[lo];
            while (left < right) {
                while (left < right && nums[right] < key)
                    right--;
                nums[left] = nums[right];
                while(left < right && nums[left] >= key)
                    left++;
                nums[right] = nums[left];
                
            }
            nums[left] = key;
            if (left == k-1)
                return nums[k-1];
            if (left > k-1)
                hi = left - 1;
            else
                lo = left + 1;
        }
        
        return nums[k-1];
        
    }
}
