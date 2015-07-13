
import java.util.*;
public class ContainsDuplicate {
    /*
     * Given an array of integers, find if the array contains any duplicates. Your function should 
     * return true if any value appears at least twice in the array, and it should return false if
     *  every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length;i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        
        return false;
    }
    /*
     * Given an array of integers and an integer k, find out whether there there are two distinct 
     * indices i and j in the array such that nums[i] = nums[j] and the difference between i and j
     *  is at most k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null)
            return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx == null) {
                map.put(nums[i], i);
            } else {
                if (i - idx <= k)
                    return true;
                map.put(nums[i], i);
            }
        }
        
        
        return false;
    }
    
    /*
     * Given an array of integers, find out whether there are two distinct indices i and j in the array 
     * such that the difference between nums[i] and nums[j] is at most t and the difference between i and
     *  j is at most k.
     * 
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || t< 0 || k < 1)
            return false;
        TreeSet<Integer> set  = new TreeSet<Integer>();
        
        for (int i =0; i < nums.length;i++) {
            Integer ceil = set.ceiling(nums[i]);
            Integer floor = set.floor(nums[i]);
            if (ceil != null && nums[i] + t >= ceil)
                return true;
            if (floor != null && nums[i] - t <= floor)
                return true;
                
            set.add(nums[i]);
            if (i - k >= 0) {
                set.remove(nums[i-k]);
                
            }
        }
        return false;
    }

}
