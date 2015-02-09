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
        boolean p[][] = new boolean [len][len];
        
        int max_start = 0;
        int max_end = 1;
        int max_len = 0;
        
        for (int i = len-1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && 
                        ((j-i <2)||(p[i+1][j-1]))){
                    p[i][j] = true;
                    if (j - i > max_len) {
                        max_len = j - i;
                        max_start = i;
                        max_end = j;
                                
                    }
                } else 
                    p[i][j] = false;
            }
        }
        
        return s.substring(max_start, max_end+1);
        
    }

}
