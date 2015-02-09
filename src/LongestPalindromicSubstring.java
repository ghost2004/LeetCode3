/*
 * Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000, and there 
 *  exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 2) 
            return s;
        int len = s.length();
        // Matrix for palindrome, p[i][j] is true when substring(i,j) is palindrome
        boolean p[][] = new boolean [len][len];
        // variables for longest substring
        int max_start = 0;
        int max_end = 1;
        int max_len = 0;
        
        for (int i = len-1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                // Only 2 conditions will make p[i][j] true
                // 1. s[i] == s[j] && p[i+1][j-1]  like b (true) --> aba ( true)
                // 2. s[i] == s[j] && j = i +1  like bb(true)
                if (s.charAt(i) == s.charAt(j) && 
                        ((j-i <2)||(p[i+1][j-1]))){
                    p[i][j] = true;
                    // found larger palindromic substring 
                    if (j - i > max_len) {
                        max_len = j - i;
                        max_start = i;
                        max_end = j;
                                
                    }
                } else 
                    p[i][j] = false;
            }
        }
        
        // need to add 1 for end, because substring returns [i,j)
        return s.substring(max_start, max_end+1);
        
    }

}
