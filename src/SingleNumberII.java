/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        int cnt[] = new int[32];
        
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int idx = 0;
            while (t != 0 && idx < 32) {
                cnt[idx] += t & 1;
                idx++;
                t = t >> 1;
            }
        }
        
        for (int i =0; i < 32; i++) {
            result |= (cnt[i] % 3)<<i;
        }
        
        return result;
    }

}
