/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in
 *  C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
import java.util.*;
public class CombinationSum {
    public void search(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> result) {
        if (idx >= candidates.length)
            return;
        
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] == target) {
                ArrayList<Integer> t = new ArrayList<Integer>(list);
                t.add(candidates[i] );
                result.add(t);
                break;
            } else if (candidates[i] > target) {
                break;
            }
            
            list.add(candidates[i]);
            search(candidates, i, target-candidates[i], list, result);
            list.remove(list.size()-1);

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        List<Integer> cand = new ArrayList<Integer>();
        Arrays.sort(candidates);
        search(candidates, 0, target, cand, out);
        
        return out;
        
    }
    
    public static void main(String args[]) {
        CombinationSum comb = new CombinationSum();
        int[] c = {1};
        comb.combinationSum(c, 2);
    }
}
