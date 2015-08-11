/*
 
Given an array nums, there is a sliding window of size k which is moving from the very left of the
 array to the very right. You can only see the k numbers in the window. Each time the sliding 
 window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */
import java.util.*;
public class SlidingWindowMax {
    // heap solution
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 1)
            return nums;
        if (k == 0)
            return new int[0];
        // the length of result
        int length = nums.length + 1 - k;
        int res[] = new int[length];
        int idx = 0;
        int i = 0;
        // we need max heap here, to get the max number
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        res[idx++] = heap.peek();
        
        for (i = k; i < nums.length; i++) {
            heap.remove(nums[i-k]);
            heap.add(nums[i]);
            res[idx++] = heap.peek();
        }
        
        return res;
    }
    
    // Deque solution
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 1)
            return nums;
        if (k == 0)
            return new int[0];
        
        // the length of result
        int length = nums.length + 1 - k;
        int res[] = new int[length];
        int idx = 0;
        
        // double linked list for all candidate's index
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            // the sliding window moves left, remove the most left one
            // if it is still in queue
            if (!queue.isEmpty() && queue.peekFirst() == i - k)
                queue.removeFirst();
            // check from the end of the queue
            // if new coming element is greater than it, 
            // it means the element in queue will never be selected.
            // So we just remove them to keep highest one in queue
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.removeLast();
            // add the new element
            queue.addLast(i);
            if (i >= k-1) {
                // add the front of queue into result
                res[idx++] = nums[queue.peekFirst()];
            }
                
        }
        
        return res;
    }
}
