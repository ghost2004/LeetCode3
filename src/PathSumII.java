/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.*;
public class PathSumII {
    private ArrayList<ArrayList<Integer>> out;
    private void findSum(TreeNode node, ArrayList<Integer> t, int target) {
        if (node == null)
            return;
        
        t.add(node.val);
        
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                out.add(new ArrayList<Integer>(t));
            }
                
        } else {
            findSum(node.left, t, target - node.val);
            findSum(node.right, t, target - node.val);
        }
        
        t.remove(t.size()-1);
        
        return;
        
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        out = new ArrayList<ArrayList<Integer>>();
        
        if (root == null)
            return out;
        
        ArrayList<Integer> t = new ArrayList<Integer>();
        
        findSum(root,t,sum);
        return out;
    }
}
