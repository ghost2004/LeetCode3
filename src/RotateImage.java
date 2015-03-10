/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int level = matrix.length/2;
        int len = matrix.length;
        
        for (int i = 0; i < level; i++) {
            int first = i;
            int last = len - i - 1;
            for (int j = first; j < last; j++) {
                // get the left-top corner
                int tmp = matrix[first][j];
                int offset = j - first;
                // move left-bottom to left-top
                matrix[first][j] = matrix[last - offset][first];
                // move right-bottom to left-bottom
                matrix[last - offset][first] = matrix[last][last - offset];
                // move right-top to right-bottom
                matrix[last][last - offset] = matrix[j][last];
                // move left-top to right-top
                matrix[j][last] = tmp;
                
            }
            
            
            
        }
        
    }
}
