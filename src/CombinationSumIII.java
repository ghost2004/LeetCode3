/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 *  used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.*;
public class CombinationSumIII {
    public void findComb(int k, int n, int idx, ArrayList<Integer> list, ArrayList<List<Integer>> result) {
        for (int i = idx; i < 10; i++) {
            if (k == 1 && i == n) {
                ArrayList<Integer> t = new ArrayList<Integer>(list);
                t.add(i);
                result.add(t);
                break;
            } else if (i > n) {
                break;
            }
            list.add(i);
            findComb(k-1, n-i, i+1, list, result);
            list.remove(list.size()-1);
                
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>>  out = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        findComb(k, n, 1, list, out);
        return out;        
    }
}
