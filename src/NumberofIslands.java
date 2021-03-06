/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water 
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid 
 * are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
public class NumberofIslands {
    int m;
    int n;
    public void mergeGrid(char[][] grid, boolean[][] flag, int x, int y) {
        if (grid[x][y] == '0' || flag[x][y] == true )
            return;
        flag[x][y] = true;
        if (x > 0) 
            mergeGrid(grid,flag, x-1, y);
        if (x < m-1)
            mergeGrid(grid,flag, x+1, y);
        if (y > 0)
            mergeGrid(grid, flag, x, y-1);
        if (y < n-1)
            mergeGrid(grid, flag, x, y+1);
        
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int cnt = 0;
        m = grid.length;
        n = grid[0].length;
        boolean flag[][] = new boolean[m][n];
        
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n ;j++) {
                if (grid[i][j] == '1' && flag[i][j] == false) {
                    cnt++;
                    mergeGrid(grid, flag, i, j);
                }
                
            }
        }
        
        return cnt;
    }

}
