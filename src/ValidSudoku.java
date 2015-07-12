/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        int i, j, k, idx;
        boolean flag[];
        // check each row
        for (i = 0; i < 9; i++) {
            flag = new boolean[10];
            for (j = 0; j < 9;j++) {
                if (board[i][j] == '.')
                    continue;
                idx = board[i][j]  - '0';
                if (flag[idx])
                    return false;
                flag[idx] = true;
            }
        }
        
        // check each col
        for (i = 0; i < 9; i++) {
            flag = new boolean[10];
            for (j = 0; j < 9;j++) {
                if (board[j][i] == '.')
                    continue;
                idx = board[j][i]  - '0';
                if (flag[idx])
                    return false;
                flag[idx] = true;
            }
        }
        
        // check sub-box
        for (k = 0; k < 9;k++) {
            flag = new boolean[10];
            for (i = k /3*3; i < k/3*3 +3; i++) {
                for (j = k%3 * 3; j < k%3*3+3;j++) {
                    if (board[i][j] == '.')
                        continue;
                    idx = board[i][j]  - '0';
                    if (flag[idx])
                        return false;
                    flag[idx] = true;
                }
            }
        }
        
        return true;
    }
}
