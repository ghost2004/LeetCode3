/*
 * Given s1, s2, s3, find whether s3 is formed
 *  by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
        
public class InterleavingString {

    
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = (s1 == null)?0:s1.length();
        int len2 = (s2 == null)?0:s2.length();
        int len3 = (s3 == null)?0:s3.length();
        
        if (len1 + len2 != len3)
            return false;
        
        boolean matched[][] = new boolean[len1+1][len2+1];
        
        int i,j;
        
        matched[0][0] = true;
        
        for (i = 0;i < len1;i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                matched[i+1][0] = true;
            } else {
                break;
            }
        }
        
        for (i = 0; i < len2;i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                matched[0][i+1] = true;
            } else {
                break;
            }
        }
        
        for (i = 1; i <= len1; i++) {
            for (j = 1; j <= len2;j++) {
                if ((s1.charAt(i-1) == s3.charAt(i+j-1) && matched[i-1][j] ) ||
                    (s2.charAt(j-1) == s3.charAt(i+j-1) && matched[i][j-1]))
                {
                    matched[i][j] = true;
                }
                
            }
        }
        
        
        return matched[len1][len2];
        
        
    }
    

}
