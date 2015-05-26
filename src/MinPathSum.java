/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left 
 * to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int path[]= new int[n];
        int i, j;
        path[0] = grid[0][0];
        // first row
        for (i = 1; i < n; i++) {
            path[i] = path[i-1] + grid[0][i];
        }
        
        for (i = 1 ; i < m; i++) {
            path[0] +=  grid[i][0];
            for (j = 1; j < n; j++) {
                path[j] = Math.min(path[j-1], path[j]) + grid[i][j];
            }
                
        }
        
        return path[n-1];
    }

}
