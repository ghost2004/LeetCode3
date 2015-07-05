/*
 * Given a binary search tree, write a function kthSmallest to find the
 *  kth smallest element in it.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need 
to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestBST {
    
    private int findK(TreeNode node, int k, int result[]) {
        if (node == null)
            return 0;
        int left = findK(node.left, k, result);
        if (left >= k)
            return left;
        
        if (left == k -1) {
            result[0] = node.val;
            return k+1;
        }
        int right = findK(node.right, k-left-1, result);
        
        int total = left + right +1;
        
        return total;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int out[] = new int[1];
        findK(root, k, out);
        return out[0];
    }
}
