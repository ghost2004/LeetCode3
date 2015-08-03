/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 */
public class RecoverBST {
    // previous node of Inorder
    TreeNode prev =  null;
    // First wrong node
    TreeNode first = null;
    // Second wrong node
    TreeNode second = null;
    
    public void inOrder(TreeNode node) {

        if (node.left != null)
            inOrder(node.left);
        // found the mistake
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                // for the first time, record the 2 nodes
                first = prev;
                second = node;
            } else {
                // for the rest of it, just change the 2nd one
                second = node;
            }
        }
        prev = node;
        if (node.right != null) {
            inOrder(node.right);
        }
    }
    
    public void recoverTree(TreeNode root) {
        // search the BST inorder
        inOrder(root);
        
        // swap the mistake values
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
