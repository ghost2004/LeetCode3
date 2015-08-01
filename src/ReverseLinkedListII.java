/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        int idx = 1;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        ListNode cur = head;
        ListNode tmp;
        // find the m node
        while (idx < m) {
            prev = cur;
            cur = cur.next;
            idx++;
        }

        ListNode start = cur;
        ListNode next = cur.next;
        
        // reverse m-n nodes
        while (next != null && idx < n) {
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
            idx++;
        }
        
        prev.next = cur;
        start.next = next;
        
        return fake.next;
    }
}
