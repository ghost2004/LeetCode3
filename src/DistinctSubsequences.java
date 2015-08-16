/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0)
            return 0;
        if (t == null || t.length() == 0)
            return 1;
        
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen < tLen)
            return 0;
        
        // dp[i][j] means the number of subsequence of t(0,j) in s(0,i)
        int dp[][] = new int[sLen+1][tLen+1];
        
        /*
         * take above as an example
         * 
         *      r a b b b i t  --> i in String s
         j    1 1 1 1 1 1 1 1
         |  r 0 1 1 1 1 1 1 1   
         |  a 0 0 1 1 1 1 1 1
         v  b 0 0 0 1 2 3 3 3
            b 0 0 0 0 1 3 3 3
            i 0 0 0 0 0 0 3 3
            t 0 0 0 0 0 0 0 3  
            
            
         */
        
        // when t is empty, there is 1 subsequence
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                /*    before now
                 *       |   |
                 *       V   V
                 * 0 .. i-1, i  --> S
                 * substring in s increased but t is not changed yet
                 * so at least we have the same number before
                 */
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // matched character
                    /*
                     *              r a b b b i t  --> i in String s
                             j    1 1 1 1 1 1 1 1
                             |  r 0 1 1 1 1 1 1 1   
                             v  a 0 0 1 1 1 1 1 1
                         So here is the case:
                           i = 1, j = 1, the letter 'r' matched here
                         we need to add dp[0][0] to dp[1][1]
                      
                                    r a b b b i t  --> i in String s
                             j    1 1 1 1 1 1 1 1
                             |  r 0 1 1 1 1 1 1 1   
                             |  a 0 0 1 1 1 1 1 1
                             v  b 0 0 0 1 2 3 3 3
                         Another case i = 3 - 5, j = 3, letter b matched 3 times
                         the subsequence number of "rab" is keeping increase in "rabbb" 
                          
                     */
                    
                    
                    dp[i][j] += dp[i-1][j-1];
                } 
            }
        }
        
        return dp[sLen][tLen];
        
    }
    
    public static void main(String args[]) {
        DistinctSubsequences d = new DistinctSubsequences();
        System.out.println(d.numDistinct("sssss","t"));
        
    }

}
