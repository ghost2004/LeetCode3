/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    
    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode fake = new ListNode(0);
        ListNode prev = fake;
        ListNode pLeft = left;
        ListNode pRight = right;
        ListNode next = null;
        
        while (pLeft != null && pRight != null) {
            
            if (pLeft.val < pRight.val) {
                next = pLeft;
                pLeft = pLeft.next;
            }
            else {
                next = pRight;
                pRight = pRight.next;
            }
            prev.next = next;
            prev = next;
            next.next = null;
        }
        
        if (pLeft != null) 
            prev.next = pLeft;
        if (pRight != null)
            prev.next = pRight;
                
        
        return fake.next;
    }
    
    public ListNode mergeSort(ListNode head, int length) {
        if (length == 1)
            return head;
        int half = length/2;
        int steps = 0;
        ListNode h2 = head; 
        ListNode end1 = null;
        
        while (steps < half) {
            end1 = h2;
            h2 = h2.next;
            steps++;
        }
        end1.next = null;
        ListNode s1 = mergeSort(head, half);
        ListNode s2 = mergeSort(h2, length - half);
        return mergeList(s1, s2);
        
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        int steps = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            steps++;
        }
        
        if (steps == 1)
            return head;
        
        return mergeSort(head, steps);
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
        SortList sort = new SortList();
   
        //ListNode.printListNode(sort.sortList(t1));
        ListNode.printListNode(sort.sortList(t2));
        //ListNode.printListNode(sort.sortList(t3));
        //ListNode.printListNode(sort.sortList(t4));
    }
}
