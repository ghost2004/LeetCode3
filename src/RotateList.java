/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode p1, prev = null;
        int length = 0;
        
        // get the length of linked list
        p1 = head;
        while (p1 != null) {
            length++;
            prev = p1;
            p1 = p1.next;
        }
        
        prev.next = head;
        
        // 2 pointers with k steps 
        int step =length -  k % length;
        p1 = head;
        for (int i = 0; i < step; i++) {
            prev = p1;
            p1 = p1.next;
        }

        prev.next = null;
        return p1;
    }

}
