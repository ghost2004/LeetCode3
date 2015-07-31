/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
import java.util.Stack;
public class MaximalRect {
    public int getMaxinRow(int height[]) {
        int max = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        while (idx < height.length) {
            if (stack.isEmpty() || height[idx] >= height[stack.peek()]) {
                stack.push(idx);
                idx++;
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? idx : idx - stack.peek() -1;
                max = Math.max(max, h*w);
            }
                
        }
        
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return max;
        int m = matrix.length;
        int n = matrix[0].length;
        int height[][] = new int[m][n];
        // create height bar for each row
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    height[i][j] = 0;
                else {
                    if (i > 0)
                        height[i][j] =  height[i-1][j] +1;
                    else 
                        height[i][j] = 1;
                }
                
            }
        }
        // get max area for each row
        for (int i = 0; i < m;i++) {
            int area = getMaxinRow(height[i]);
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    public static void main(String args[]) {
        MaximalRect m = new MaximalRect();
        char t1[][] = new char[1][1];
        t1[0][0] = '0';
        System.out.println(m.maximalRectangle(t1));
    }
}
