/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

    private boolean checkBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val >= max || node.val <= min)
            return false;
        
        return checkBST(node.left, min, node.val) &&
                checkBST(node.right, node.val, max);
        
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return checkBST(root.left, Long.MIN_VALUE, root.val) &&
                checkBST(root.right, root.val, Long.MAX_VALUE);
    }
    
    public static void main(String args[]) {
        TreeNode t = TreeNode.deserialize("0");
        ValidateBST v = new ValidateBST();
        System.out.println(v.isValidBST(t));
    }

}
