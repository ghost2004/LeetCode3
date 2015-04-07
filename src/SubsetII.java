/*
 * Given a collection of integers that might contain duplicates, S, 
 * return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
import java.util.*;
public class SubsetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        out.add(new ArrayList<Integer>());
        
        Arrays.sort(num);
        
        int start = 0;
        for (int i = 0; i < num.length;i++) {
            int size = out.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> n = new ArrayList<Integer>(out.get(j));
                n.add(num[i]);
                out.add(n);
            }
            
            if (i < num.length-1 && num[i] == num[i+1])
                start = size;
            else 
                start = 0;
        }
        
        return out;
        
    }
}
