/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRow = false;
        boolean firstCol = false;
        
        int i, j;
        
        for (i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstCol = true;
                break;
            }
        }
        
        for (i = 1; i < m; i++) {
            for (j = 1; j < n;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (i = 1; i < m; i++) {
            for (j = 1; j < n;j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if (firstRow) {
            for ( i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        
        if (firstCol) {
            for ( i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        
        
    }
    public void setZeroes_mn(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];
        
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (row[i])
                    matrix[i][j] = 0;
                else if (col[j])
                    matrix[i][j] = 0;
            }
        }
        
    }
}
