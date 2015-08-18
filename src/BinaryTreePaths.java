/*
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
import java.util.*;
public class BinaryTreePaths {
    public void getPath(TreeNode node, ArrayList<TreeNode> stack, List<String> out) {
        int size = stack.size();
        if (node.left == null && node.right == null) {
            String p = new String();
            for (int i = 0; i < size; i++) {
                p+=String.valueOf(stack.get(i).val) +"->";
            }
            p += String.valueOf(node.val);
            out.add(p);
            return;
        }
        
        stack.add(node);
        if (node.left != null)
            getPath(node.left, stack, out);
        if (node.right != null)
            getPath(node.right, stack, out);
        
        stack.remove(size);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList<String>();
        if (root == null)
            return out;

        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        getPath(root, stack, out);
        return out;
    }
}
