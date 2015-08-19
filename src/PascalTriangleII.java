/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.*;
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        
        if (rowIndex < 0)
            return row;
        
        row.add(1);
        if (rowIndex == 0)
            return row;
        row.add(1);
        if (rowIndex == 1)
            return row;
        for (int i = 2; i <= rowIndex; i++) {
            int last = 1;
            for (int j = 1; j < i-1;j++) {
                int prev = row.get(j);
                row.set(j, prev+last);
                last = prev;
            }
                
            
            row.add(1);
        }
        
        
        return row;
        
    }
}
