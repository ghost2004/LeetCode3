/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRoof2Leaf {
    private int getNumbers(TreeNode node, int val) {
        int t = 10*val+node.val;
        int v = 0;
        if (node.left == null && node.right == null) {
            return t;
        }
        
        if (node.left != null)
            v+=getNumbers(node.left, t);
        if (node.right != null)
            v+=getNumbers(node.right, t);
        
        return v;
        
    }
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        
        return getNumbers(root,0);
    }
}
