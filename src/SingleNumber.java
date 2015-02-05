/*
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int t = 0;
        if (A == null)
            return 0;
        for (int i = 0; i < A.length; i++) {
            t ^= A[i];
        }
        return t;
    }

}
