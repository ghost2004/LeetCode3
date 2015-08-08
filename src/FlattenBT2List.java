/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBT2List {
    
    public void flatten(TreeNode root) {
        // return null
        if (root == null)
            return;
        
        TreeNode node = root.left;
        if (node != null) {
            // get the most right node of left subtree
            while (node.right != null) 
                node = node.right;
            // move right subtree to its right node
            node.right = root.right;
            // move left subtree to right subtree
            root.right = root.left;
            // set left as NULL
            root.left = null;
        } 
        
        flatten(root.right);
    }

}
