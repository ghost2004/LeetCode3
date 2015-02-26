/*
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST
 */
public class SortedArray2BST {
    private TreeNode convert(int[] num, int begin, int end) {
        if (begin > end)
            return null;
        if (begin == end)
            return new TreeNode(num[begin]);
        
        int mid = (begin + end)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convert(num, begin, mid-1);
        node.right = convert(num, mid+1, end);
        return node;
        
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
        return convert(num, 0, num.length-1);
    }

}
