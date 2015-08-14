/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class Add2Nums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode out = new ListNode(0);
        ListNode prev = out;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = null;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int num = 0;
            if (p1 != null) {
                num += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                num += p2.val;
                p2 = p2.next;
            }
            num += carry;
            
            cur = new ListNode(num%10);
            prev.next = cur;
            prev = cur;
            carry = num/10;
            
        }
        return out.next;
    }
}
