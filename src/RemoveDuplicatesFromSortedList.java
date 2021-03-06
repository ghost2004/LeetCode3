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
        ListNode cur = head;
        ListNode p;

        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                p = cur.next.next;
                while (p != null && p.val == cur.val)
                    p = p.next;
                cur.next = p;
               
            } 
           
            cur = cur.next;
        }
        
        return head;
    }
}
