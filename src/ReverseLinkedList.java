/*
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) 
            return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
                
    }

}
