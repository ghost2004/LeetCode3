/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.*;
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out =  new ArrayList<List<Integer>>();
        if (numRows == 0)
            return out;
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        out.add(row);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> last = out.get(out.size()-1);
            row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 2; j < i; j++) {
                row.add(last.get(j-2)+last.get(j-1));
            }
            row.add(1);
            out.add(row);
        }
        return out;
    }
}
