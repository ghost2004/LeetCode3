/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean checkSym(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        
        return checkSym(left.left, right.right) && checkSym(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSym(root.left, root.right);
    }
    
}
