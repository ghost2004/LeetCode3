/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveListEle {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                ListNode n = cur.next;
                cur.next = null;
                cur = n;
            } else {
                prev = cur;
                cur = cur.next;
            }
            
            
        }
        
        return fake.next;
    }
}
