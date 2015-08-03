/*
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        // first node as previous sorted node
        ListNode sorted = head;
        // start with the second node in the list
        ListNode cur = head.next;
        
        while (cur != null) {
            
            if (cur.val >= sorted.val) {
                // already sorted, go to next node
                sorted = cur;
                cur = cur.next;
                continue;
            }
            ListNode next = cur.next;
            
            ListNode prev = fake;
            ListNode pointer = fake.next;
            // scan from left to cur node
            while (pointer != cur) {
                if (cur.val < pointer.val) {
                    // found the place to insert
                    prev.next = cur;
                    cur.next = pointer;
                    break;
                }
                
                prev = pointer;
                pointer = pointer.next;
            }
            sorted.next = next;
            cur = next;
        }
        
        
        return fake.next;
    }
    
    public static void main(String[] arg) {
        int[] array1 = {2, 1}; 
        int[] array2 = {3, 4, 1};
        int[] array3 = {1, 1};
        int[] array4 = {3, 2, 1};
        ListNode t1 = ListNode.initFromArray(array1);
        ListNode t2 = ListNode.initFromArray(array2);
        ListNode t3 = ListNode.initFromArray(array3);
        ListNode t4 = ListNode.initFromArray(array4);
        InsertionSortList insert = new InsertionSortList();
   
        ListNode.printListNode(insert.insertionSortList(t1));
        ListNode.printListNode(insert.insertionSortList(t2));
        ListNode.printListNode(insert.insertionSortList(t3));
        ListNode.printListNode(insert.insertionSortList(t4));
    }

}
