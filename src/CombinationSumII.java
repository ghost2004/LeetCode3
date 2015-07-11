/*
 * Given a collection of candidate numbers (C) and a target number (T), find
 *  all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */
import java.util.*;
public class CombinationSumII {
    public void findComb(int[] candidates, int target, int idx, ArrayList<Integer> list, ArrayList<List<Integer>> result) {
        if (idx >= candidates.length)
            return;
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] == target) {
                ArrayList<Integer> t = new ArrayList<Integer>(list);
                t.add(candidates[i]);
                result.add(t);
                break;
            }
            else if (candidates[i] > target)
                break;
            
            list.add(candidates[i]);
            findComb(candidates, target-candidates[i], i+1, list, result);
            list.remove(list.size()-1);
            //skip the duplicate solution
            while (i < candidates.length-1 && candidates[i] == candidates[i+1])
                i++;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>> ();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        findComb(candidates, target, 0, list, out);

        return out;
    }
}
