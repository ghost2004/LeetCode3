/*
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class SortList2BST {
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null)
            return null;
        // only one node, just return it
        if (head.next == null)
            return new TreeNode(head.val);
        // end point of left side
        ListNode prev = null;
        // middle pointer
        ListNode slow = head;
        // fast pointer to reach the end of the list
        ListNode fast = head.next;
        
        while (fast != null) {
            // slow pointer moves one node per time
            prev = slow;
            slow = slow.next;
            // fast pointer moves two nodes per time
            if (fast.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
        }
        // cut the list into half here
        prev.next = null;
        
        TreeNode r = new TreeNode(slow.val);
        r.left = sortedListToBST(head);
        r.right = sortedListToBST(slow.next);
        
        
        return r;
        
    }
}
