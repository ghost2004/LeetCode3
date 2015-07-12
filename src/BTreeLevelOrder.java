/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.*;
public class BTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
        if (root == null)
            return out;
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        cur.add(root);
        
        while (!cur.isEmpty()) {
            TreeNode node = cur.remove();
            if (node.left != null)
                next.add(node.left);
            if (node.right != null)
                next.add(node.right);
            
            level.add(node.val);
            if (cur.isEmpty()) {
                out.add(level);
                level = new ArrayList<Integer>();
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        
        return out;
    }
}
