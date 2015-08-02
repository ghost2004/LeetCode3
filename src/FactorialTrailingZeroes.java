/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        int t = n;
        for (long i = 5; t >= i; i*=5) {
            cnt+=t/i;
            
        }
        return cnt;
    }

}
