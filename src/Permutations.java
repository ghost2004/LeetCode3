/*
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
import java.util.*;
public class Permutations {
    // Iteration solution
    public  List<List<Integer>>  permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // add an empty list first
        List<Integer> first = new ArrayList<Integer>();
        result.add(first);
        
        for (int i =0; i < num.length; i++) {
            // container for this round
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for (List<Integer> list:result) {
                // for each candidate in current solution
                for (int j = 0; j <= list.size(); j++) {
                    // insert the element into all possible position
                    list.add(j, num[i]);
                    List<Integer> t = new ArrayList<Integer>(list);
                    cur.add(t);
                    list.remove(j);
                }
            }
            
            result = cur;
        }
        
        return result;
    }
    
    // Recursive solution
    public  List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        perm(num, 0 , result);
        return result;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void perm(int[] num, int start, List<List<Integer>> result) {
        if (start >= num.length) {
            List<Integer> item = new ArrayList<Integer>();
            for (int i: num) {
                item.add(i);
            }
            result.add(item);
            return;
        }
        
        for (int i = start; i <num.length; i++) {
            swap(num, start, i);
            perm(num, start+1, result);
            swap(num, start, i);
        }
    }
    
    public static void main(String args[]) {
        Permutations p = new Permutations();
        int a[] = {1};
        p.permute(a);
    }
    

}
