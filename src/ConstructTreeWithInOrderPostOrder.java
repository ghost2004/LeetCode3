/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructTreeWithInOrderPostOrder {

    private int postOrder[];
    private int inOrder[];
    private int findIdx(int array[], int key, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }
    
    
    private TreeNode build(int ib, int ie, int pb, int pe) {
        if (ib == ie)
            return new TreeNode(inOrder[ib]);
        else if (ib > ie)
            return null;
        
        TreeNode node = new TreeNode(postOrder[pe]);
        
        int idx = findIdx(inOrder, postOrder[pe], ib, ie);
        
        if (idx == -1)
            return null;
        int pIdx = pb + idx - ib;
        node.left = build(ib, idx-1, pb, pIdx-1);
        node.right = build(idx+1, ie, pIdx, pe-1);
        
        
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        
        postOrder = postorder;
        inOrder = inorder;
        TreeNode root;
        
        root = build(0, length-1, 0, length-1);
        
        return root;
    }
}
