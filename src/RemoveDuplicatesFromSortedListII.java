/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode f = new ListNode(0);
        f.next = head;
        
        ListNode prev = f;
        ListNode cur = head;
        ListNode t;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                t = cur.next.next;
                while (t != null && t.val == cur.val)
                    t = t.next;
                prev.next = t;
                cur = t;
            } else {
                prev = cur;
                cur = cur.next;
            }
            
        }
        
        
        
        return f.next;
        
    }
}
