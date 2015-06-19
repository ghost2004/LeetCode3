/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
import java.util.*;
public class UniqueBSTII {
    // generate the BST from start to end
    public ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> out = new ArrayList<TreeNode>();
        
        if (start == end) {
            TreeNode node = new TreeNode(start);
            out.add(node);
            return out;
        } else if (start > end) {
            out.add(null);
            return out;
        }
        
        for (int i = start; i <= end;i++) {
            ArrayList<TreeNode> leftSub = generateTrees(start, i-1);
            ArrayList<TreeNode> rightSub = generateTrees(i+1, end);
            for (TreeNode left:leftSub) {
                for (TreeNode right:rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    out.add(root);
                }
            }
        }

            
        return out;
    }
    
    public List<TreeNode> generateTrees(int n) {
        
        
        return generateTrees(1, n);
    }
}
