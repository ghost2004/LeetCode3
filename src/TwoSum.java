/*
 * Given an array of integers, find two numbers such that they add up to 
 * a specific target number.

The function twoSum should return indices of the two numbers such that they 
add up to the target, where index1 must be less than index2. Please note that 
your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int out[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i, key;
        // create hashtable from value to index
        for (i = 0; i < nums.length; i++) {
            map.put(nums[i], i+1);
        }
        
        
        for (i = 0; i < nums.length; i++) {
            key = target - nums[i];
            Integer r = map.get(key);
            if (r != null && r != i+1) {
                out[0] = i+1;
                out[1] = r;
                break;
            }
        }
        
        return out;
    }
    
    public static void main(String args[]) {
        TwoSum t = new TwoSum();
        int a1[] = {3,2,4};
        int out[] = t.twoSum(a1, 6);
        System.out.println(out[0]+"  "+out[1]);
        
    }

}
