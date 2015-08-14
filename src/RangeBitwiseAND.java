/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise 
 * AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
 */
public class RangeBitwiseAND {
    public int rangeBitwiseAndTimeEx(int m, int n) {
        if (m == n)
            return m;
        if (m == 0)
            return 0;
        int out  = m &(m+1);
        for (int i = m+2; i <=n;i++) {
            out = out & i;
        }
        return out;
    }
    
    public int rangeBitwiseAnd2(int m, int n) {
        while (n > m) {
            n = n&(n-1);
        }
        
        return m&n;
    }
    
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (n != m) {
            n  = n >> 1 ;
            m = m >> 1;
            cnt++;
        }
        
        return m << cnt;
    }
}
