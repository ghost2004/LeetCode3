/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        RandomListNode cur = head;
        
        //double the node in this list
        while (cur != null) {
            RandomListNode n = new RandomListNode(cur.label);
            n.next = cur.next;
            cur.next = n;
            cur = n.next;
        }
        
        // copy the random pointer
        cur = head;
        while (cur != null) {
            RandomListNode n = cur.next;
            if (cur.random != null)
                n.random = cur.random.next;
            cur = n.next;
        }
        
        // split the list
        RandomListNode copy = head.next;
        cur = head;
        RandomListNode next = cur.next;
        while (cur != null) {
            cur.next = next.next;
            cur = cur.next;
            if (cur != null) 
                next.next = cur.next;
            next = next.next;
        }
        
        return copy;
        
    }
}
