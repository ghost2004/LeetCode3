/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways
 can you climb to the top?
 */
public class ClimbingStairs {
    // Typical Fibonacci numbers 
    public int climbStairs(int n) {
        // For 1 stair, 1 way
        // For 2 stairs, 2 ways 1+1
        if ( n < 2)
            return n;
        int a = 1;
        int b = 2;
        // S[n] = S[n-2] + S[n-1]
        for (int i = 3; i <= n;i++) {
            int c = b;
            b += a;
            a = c;
        }
                
        return b;
    }
}
