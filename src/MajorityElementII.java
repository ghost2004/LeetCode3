/*
 * Given an integer array of size n, find all elements that appear more than n/3 times 
 * The algorithm should run in linear time and in O(1) space.
 */
import java.util.*;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        int m = 0;
        int n = 0;
        int cm = 0;
        int cn = 0;
        
        int len = nums.length;
        
        // vote algorithm , get the most 2 (if existed)
        for (int i = 0; i < len;i++) {
            // bug here
            // need to check existing value first, otherwise like {8,8,7,7,7}
            // 8 will be wrapped out
            if (m == nums[i]) {
                cm++;
            } else if(n == nums[i]) {
                cn++;
            } else if (cm == 0) {
                m = nums[i];
                cm = 1;
            } else if (cn == 0) {
                n = nums[i];
                cn = 1;
            } else {
                cm--;
                cn--;
            }
        }
        
        // check those 2 are actually majority numbers
        cm = cn = 0;
        
        for (int i = 0; i < len;i++) {
            if (m == nums[i]) {
                cm++;
            } else if (n == nums[i]) {
                cn++;
            }
        }
        
        if (cm > len/3) {
            out.add(m);
        }
        
        if (cn > len/3) {
            out.add(n);
        }
        
        
        return out;
    }
    
    public static void main(String args[]) {
        MajorityElementII m = new MajorityElementII();
        List<Integer> p;
        int test[] = {8,8,7,7,7};
        p = m.majorityElement(test);
        System.out.println(p.size());
    }

}
