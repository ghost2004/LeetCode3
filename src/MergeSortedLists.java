/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes
 *  of the first two lists.
 */
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        ListNode left = l1;
        ListNode right = l2;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                cur = left;
                left = left.next;
            } else {
                cur.next = right;
                cur = right;
                right =  right.next;
            }
        }
        
        if (left != null) 
            cur.next = left;
        if (right != null)
            cur.next = right;
        
        return fake.next;
    }
}
