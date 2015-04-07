/*
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.*;
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> out =  new ArrayList<ArrayList<Integer>>();
        out.add(new ArrayList<Integer>());
        
        if (S == null || S.length < 1)
            return out;
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int size = out.size();
            for (int j = 0; j < size;j++) {
                ArrayList<Integer> t = new ArrayList<Integer>(out.get(j));
                t.add(S[i]);
                out.add(t);
            }
        }
        return out;
    }
}
