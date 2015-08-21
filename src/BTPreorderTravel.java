/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
 */
import java.util.*;
public class BTPreorderTravel {
    // Recursive solution
    public void preorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    
    // iteratively solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        //preorder(root,out);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return out;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left !=  null)
                stack.push(node.left);
            
        }
        return out;
    }
}
