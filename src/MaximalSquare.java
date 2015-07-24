/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m][n];
        // first row
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                max = 1;
                dp[0][i] = 1;
            } else 
                dp[0][i] = 0;
        }
        // first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                max = 1;
                dp[i][0] = 1;
            } else 
                dp[i][0] = 0;
        }
        
        
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    int d = Math.min(dp[i-1][j-1] , dp[i][j-1]);
                    d = Math.min(d, dp[i-1][j])+1;
                    dp[i][j] = d;
                    max = Math.max(d, max);
                }
            }
        }
        
        return max*max;
        
    }
}
