/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.*;
public class BTZigzagLevel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int t = 1;
        if (root == null)
            return result;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            level.add(cur.val);
            if (t % 2 == 1) {
                if (cur.left != null)
                    stack.push(cur.left);
                if (cur.right != null)
                    stack.push(cur.right);
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
            
            
            if (queue.isEmpty()) {
                result.add(level);
                level = new ArrayList<Integer>();
                t++;
                while (!stack.isEmpty()) 
                    queue.offer(stack.pop());
            }
            
        }
        
        return result;
        
    }

}
