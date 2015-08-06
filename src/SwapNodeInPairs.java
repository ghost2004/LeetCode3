/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values 
in the list, only nodes itself can be changed.
 */
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        
        while (p1 != null && p2 != null) {
            ListNode p1n = p2.next;
            p2.next = p1;
            p1.next = p1n;
            prev.next = p2;
            prev = p1;
            p1 = p1n;
            if (p1n != null)
                p2 = p1n.next;
        }
        
        
        return newHead.next;
    }
}
