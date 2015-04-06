/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode c = head;
        int t = c.val;
        while (c != null) {
            if (c.next != null) {
                if (c.next.val == t) {
                    ListNode p = c.next.next;
                    while (p != null && p.val == t)
                        p = p.next;
                    c.next = p;
                    if (p != null)
                        t = p.val;
                    
                } else {
                    t = c.next.val;
                    
                }
                
            }
           
            c = c.next;
        }
        
        return head;
    }
}
