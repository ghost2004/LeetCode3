/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. 
 The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean dfs(char[][] board, int x, int y, String word,int idx) {
        int m = board.length;
        int n = board[0].length;
        // sanity check first
        if (x < 0 || y < 0 || x >= m || y >= n)
            return false;
        // current character matches
        if (board[x][y] == word.charAt(idx)) {
            // return true if it is the last character in the string
            if (idx == word.length() - 1)
                return true;
            char tmp = board[x][y];
            // marked this spot as visited
            board[x][y] = '#';
            // search next spot in 4 possible directions
            if (dfs(board, x-1, y, word, idx+1) ||
                dfs(board, x, y-1, word, idx+1) ||
                dfs(board, x+1, y, word, idx+1) ||
                dfs(board, x, y+1, word, idx+1)) {
                board[x][y] = tmp;
                return true;
            }
            
            // restore the spot
            board[x][y] = tmp;
        }
        
        
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        // search from every point in the matrix
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
}
