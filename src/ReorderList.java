/*
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
            
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;        
        slow.next = null;
        ListNode prev = null;
        
        while (head2 != null) {
            ListNode tmp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = tmp;
        }
        
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p1 != null && p2 !=null) {
            ListNode p3 = p1.next;
            ListNode p4 = p2.next;
            p1.next = p2;
            if (p3 != null)
                p2.next = p3;
            p1 = p3;
            p2 = p4;
        }
        
        
    }
    
    public static void main(String args[]) {
        ReorderList r = new ReorderList();
        int a1[] = {1,2,3};
        ListNode h1 = ListNode.initFromArray(a1);
        r.reorderList(h1);
        ListNode.printListNode(h1);
    }

}
