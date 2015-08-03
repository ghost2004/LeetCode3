/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberDigitOne {
    public int countDigitOne(int n) {

        int cnt = 0;
        int target = n;
        // scan the number from right to left
        for (long base = 1; base <= target; base *= 10) {
            // the number before current base -- left side
            long div = target/base;
            // current number
            long reminder = div % 10;
            if (reminder == 1) {
                // current number is 1
                // left side + right side + 1
                cnt += div/10*base+ target%base + 1;
            } else if (reminder == 0) {
                // current number is 0
                // left side
                cnt += div/10*base;
            } else {
                // current number >= 2
                // left side 
                cnt += (div/10+1)*base;
            }
        }
        
        return cnt;
    }

}
