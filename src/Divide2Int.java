/*
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
public class Divide2Int {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        // Only for OJ cases
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
     
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        int ret = 0;
        while (p >= q) {
            int cnt = 0;
            while (p >= (q << cnt)) {
                cnt++;
            }
            ret += 1<<(cnt-1);
            p -= q<<(cnt-1);
            
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ret;
        else
            return -ret;

    }

}
