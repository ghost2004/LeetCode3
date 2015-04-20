/*
 * The n-queens puzzle is the problem of placing n queens on an n×n 
 * chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
import java.util.*;
public class NQueens {
    ArrayList<String[]> out ;
    
    private boolean isValid(int pos[], int row) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == pos[row] || Math.abs(pos[row] - pos[i]) == row - i) {
                return false;
            }
        }
        
        return true;
    }
    public void findSol(int pos[], int row) {
        if (row >= pos.length) {
            String p[] = new String[pos.length];
            char t[] = new char[pos.length];
            Arrays.fill(t, '.');
            for (int i = 0; i < pos.length;i++) {
                t[pos[i]] = 'Q';
                p[i] = new String(t);
                t[pos[i]] = '.';
            }
            out.add(p);
            return;
        }
        for (int i = 0; i < pos.length; i++) {
            pos[row] = i;
            if (isValid(pos, row)) {
                findSol(pos, row+1);
            }
        }
        return;
    }
    public ArrayList<String[]> solveNQueens(int n) {
        out = new ArrayList<String[]>();
        int pos[] = new int[n];

        findSol(pos, 0);
        
        return out;
    }
}
