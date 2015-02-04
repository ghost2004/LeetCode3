/*
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end 
should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
    
    public ListNode reverseList(ListNode prev, ListNode tail) {
        // D-1-2-3-4-5-n
        // p l c n tail
        // D-2-1-3-4-5-n
        // p   l c
        ListNode last = prev.next;
        ListNode cur = last.next;
        
        while (cur != tail) {
            last.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = last.next;
        }

        return last;
        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || head.next == null || k ==1)
            return head;
        ListNode first = new ListNode(0);
        first.next = head;
        
        ListNode prev = first;
        ListNode cur = head;
       
        
        int i = 0;
        while (cur != null) {            
            i++;
            if (i % k == 0) {
                prev = reverseList(prev, cur.next);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
            
        }

        return first.next;
        
    }

}
