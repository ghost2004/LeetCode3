/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class BTPostorder {
    // Recursive solution
    public void postOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
        
    }
    
    // Iterative solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null)
            return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> val = new Stack<Integer> ();
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            val.push(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            
        }
        
        while (!val.isEmpty()) {
            result.add(val.pop());
        }
        
        return result;
    }
}
