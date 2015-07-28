/*
 * Given two words word1 and word2, find the minimum number of steps 
 * required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
                
        if (word1 == null && word2 == null) 
            return 0;
        else if (word1 == null)
            return word2.length();
        else if (word2 == null)
            return word1.length();
            
        if (word1.equals(word2))
            return 0;
        
        int m = word1.length();
        int n = word2.length();
        
        int dp[][] = new int[m+1][n+1];
        int i,j;
        
        for (i = 0; i <= m;i++) {
            dp[i][0] = i;
        }
        for (i = 0; i <= n;i++){
            dp[0][i] = i;
        }
        
        for (i = 0; i < m;i++) {
            char c1 = word1.charAt(i);
            for (j = 0; j < n;j++){
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int replace = dp[i][j]+1;
                    int insert = dp[i][j+1] +1;
                    int delete = dp[i+1][j] +1;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                    
                }
            }
        }
        
        return dp[m][n] ;
    }
}
