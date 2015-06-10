/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
import java.util.HashSet;
public class LongestConsecutiveSequence {
    
    private int findInSet(HashSet<Integer> set, int k, int dir) {
        int cnt = 0;
        int key = k;
              
        while (set.contains(key)) {
            cnt++;
            set.remove(key);
            key += dir;
        }
        
        return cnt;
        
    }
    
    public int longestConsecutive(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;
        int out = 1;
        int i;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int key:nums) {
            out = Math.max(out, findInSet(set, key, 1)+ findInSet(set, key-1, -1) );
        }
        return out;
         
    }
}
