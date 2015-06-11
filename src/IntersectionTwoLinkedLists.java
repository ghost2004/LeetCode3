/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                                                                   ¨K
                     c1 ¡ú c2 ¡ú c3
                                                                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNodeErr(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode bt = headB;
        
        while (bt.next != null)
            bt = bt.next;
        
        bt.next = headA;
        
        ListNode s1 = headA;
        ListNode s2 = headA;
        
        while (true) {
            if (s2.next == null  || s2.next.next == null) {
                bt.next = null;
                return null;
            }
            s1 = s1.next;
            s2 = s2.next.next;
            
            if (s1 == s2)
                break;
            
        }
        bt.next = null;
        return s1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0;
        int lenB = 0;
        
        ListNode p1 = headA;
        while (p1 != null) {
            p1 = p1.next;
            lenA++;
        }
        ListNode p2 = headB;
        while (p2 != null) {
            p2 = p2.next;
            lenB++;
        }
        int diff = Math.abs(lenB - lenA);
        p1 = headA;
        p2 = headB;
        
        if (lenA < lenB) {
            for (int i = 0; i < diff;i++) {
                p2 = p2.next;
            }
        } else if (lenA >lenB) {
            for (int i = 0; i < diff;i++) {
                p1 = p1.next;
            }
        }
        
        while (p1 != null) {
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return null;
    }
}
