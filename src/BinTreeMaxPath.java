/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinTreeMaxPath {
    
    private int findMax(TreeNode node, int max[]) {
        if (node == null)
            return 0;
        int leftValue = findMax(node.left, max);
        int rightValue = findMax(node.right, max);
        int localValue = leftValue + rightValue + node.val;
        int exportValue = Math.max(leftValue, rightValue) + node.val;
        exportValue = Math.max(exportValue, node.val);
        max[0] = Math.max(max[0], localValue);
        max[0] = Math.max(max[0], exportValue);
        return exportValue;
    }
    
    public int maxPathSum(TreeNode root) {
        int max[] = {Integer.MIN_VALUE};
        findMax(root, max);
        
        return max[0];
        
    }

}
