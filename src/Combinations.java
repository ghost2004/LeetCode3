/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
import java.util.*;
public class Combinations {

    public void findComb(int n, int k,int idx, ArrayList <Integer> list, List<List<Integer>> result) {
        for (int i = idx+1; i <= n; i++) {
            list.add(i);
            if (k == 1) {
                ArrayList <Integer> t = new ArrayList <Integer>(list);
                result.add(t);
            } else {
                findComb(n, k-1, i, list, result);
            }
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        ArrayList <Integer> list = new ArrayList <Integer>();
        findComb(n, k, 0, list, out);
        return out;
    }
}
