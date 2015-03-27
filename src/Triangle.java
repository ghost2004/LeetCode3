/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step 
 * you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n 
is the total number of rows in the triangle.
 */
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty())
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        
        int A[] = new int[triangle.size()];
        int level;
        int idx;
        
        for (level = triangle.size()-1; level >= 0; level--) {
            List<Integer> list = triangle.get(level);
            for (idx = 0; idx < list.size(); idx++) {
                if (level == triangle.size()-1) {
                    A[idx] = list.get(idx);
                } else {
                    A[idx] = list.get(idx) + Math.min(A[idx], A[idx+1]);
                }
            }
        }
        
        return A[0];
        
    }

}
