/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.
 */
public class IsBalanceTree {
    
    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = getDepth(node.left);
        if (left == -1)
            return -1;
        int right = getDepth(node.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        
        return 1+Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        
        if (depth == -1)
            return false;
        
        return true;
    }
}
