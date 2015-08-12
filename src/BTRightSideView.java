/*
 * Given a binary tree, imagine yourself standing on the right side of it,
 *  return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
import java.util.*;
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        LinkedList<TreeNode> q1 = new  LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new  LinkedList<TreeNode>();
        
        q1.add(root); 
        
        while (!q1.isEmpty()) {
            list.add(q1.getLast().val);
            while (!q1.isEmpty()) {
                TreeNode node = q1.removeFirst();
                if (node.left != null)
                    q2.add(node.left);
                if (node.right != null)
                    q2.add(node.right);
            }
            q1 = q2;
            q2 = new  LinkedList<TreeNode>();
        }
        
        
        return list;
    }
}
