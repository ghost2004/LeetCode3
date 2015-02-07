/*
 * Given a string s, partition s such that every substring of the
 *  partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be
 produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int len = s.length();
        // Cuts array, cuts[i] stands for minimum cuts from i to end the string for palindrome
        // we need the array for len+1
        
        int cuts[] = new int[len+1];
        // Matrix for palindrome, p[i][j] is true when substring(i,j) is palindrome
        boolean p[][] =  new boolean[len][len];
        
        int i,j;
        // the worst case for minimum cut is cut the string into one character
        // String: a   b   a   b   b   b   a   b   b   a   b   a
        // cuts[i] 12  11  10  9   8   7   6   5   4   3   2   1  0 
        for (i = 0; i < len; i++)
            cuts[i] = len- i;
        
        //Scan i from right to left
        for (i = len-1; i >= 0;i--) {
            // Scan j from left i to right
            for (j = i; j < len;j++) {
                // Only 2 conditions will make p[i][j] true
                // 1. s[i] == s[j] && p[i+1][j-1]  like b (true) --> aba ( true)
                // 2. s[i] == s[j] && j = i +1  like bb(true)
                if ((s.charAt(i) == s.charAt(j)) && ((j - i <2) || p[i+1][j-1] )) {
                    
                    p[i][j] = true;
                    // a   b   a   b   b   b   a   b   b   a   b   a
                    //             i                   j  j+1      n
                    // minimum cuts for i is the minimum cuts for j+1 plus 1
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
                }
                        
            }
        }
        
        return cuts[0]-1;
        
    }

}
