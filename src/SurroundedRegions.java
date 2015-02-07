import java.util.Arrays;

/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
import java.util.*;
public class SurroundedRegions {
    private char[][] board;
    private int m,n;
    
    // DFS solution 
    
    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x > m-1 || y > n-1 || board[x][y] != 'O')
            return;
        board[x][y] = 'L';
        if (x > 0 && board[x-1][y] =='O')
            dfs(x-1, y);
        if (x < m-1 && board[x+1][y] == 'O')
            dfs(x+1,y);
        if (y < n-1 && board[x][y+1] == 'O')
            dfs(x,y+1);
        if (y > 0 && board[x][y-1] == 'O')
            dfs(x,y-1);        
    }
    
    public void solveDFS(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)
            return;
        this.board = board;
        m = board.length;
        n = board[0].length;

        int i,j;
        
        for (i = 0; i < n; i++) {
            dfs(0, i);
            dfs(m-1, i);
        }
        
        for (i = 1; i< m-1;i++) {
            dfs(i,0);
            dfs(i,n-1);
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 'L')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
                
            }
        }
    }
    
    // BFS solution
    Queue<Integer> queueX;
    Queue<Integer> queueY;
    
    public void fill(int x, int y) {
        if (x < 0 || y < 0 || x > m-1 || y > n-1 || board[x][y] != 'O')
            return;
        board[x][y] = 'L';
        queueX.offer(x);
        queueY.offer(y);
    }
    
    public void bfs(int x, int y) {
        
        fill(x,y);
        
        while (!queueX.isEmpty()) {
            int i = queueX.poll();
            int j = queueY.poll();
            
            if (i > 0 && board[i-1][j] =='O')
                fill(i-1, j);
            if (i < m-1 && board[i+1][j] == 'O')
                fill(i+1,j);
            if (j < n-1 && board[i][j+1] == 'O')
                fill(i,j+1);
            if (j > 0 && board[i][j-1] == 'O')
                fill(i,j-1);
        }
        
        
        
    }
    
    public void solve(char[][] board) {
        queueX = new LinkedList<Integer>();
        queueY = new LinkedList<Integer>();
        if (board == null || board.length < 3 || board[0].length < 3)
            return;
        this.board = board;
        m = board.length;
        n = board[0].length;

        int i,j;
        
        for (i = 0; i < n; i++) {
            bfs(0, i);
            bfs(m-1, i);
        }
        
        for (i = 1; i< m-1;i++) {
            bfs(i,0);
            bfs(i,n-1);
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 'L')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
                
            }
        }
        
    }
}
