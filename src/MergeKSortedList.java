/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */
import java.util.*;
public class MergeKSortedList {
    
    public ListNode mergeListNode(ListNode left, ListNode right) {
        ListNode start = new ListNode(0);
        ListNode cur = start;
        ListNode leftP = left;
        ListNode rightP = right;
        
        while (leftP != null && rightP != null) {
            if (leftP.val < rightP.val) {
                cur.next = leftP;
                leftP = leftP.next;
            } else {
                cur.next = rightP;
                rightP = rightP.next;
            }
            cur = cur.next;
        }
        
        
        if (leftP != null) {
            cur.next = leftP;
        }
        else if (rightP != null) {
            cur.next = rightP;
        }
        return start.next;
    }
    
    public ListNode mergeLists(ArrayList<ListNode> lists, int begin, int end) {
        if (end == begin) {
            return lists.get(begin);
        } else if (end == begin + 1) {
            return mergeListNode(lists.get(begin), lists.get(end));
        }
        int mid = (begin + end)/2;
        ListNode node1 = mergeLists(lists, begin, mid-1);
        ListNode node2 = mergeLists(lists, mid, end);
        
        return mergeListNode(node1, node2);
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        return mergeLists(lists, 0, lists.size()-1);
    }
    
    public ListNode mergeKLists_longtime(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        
        ListNode prev = new ListNode(1);
        ListNode s = prev;
        ListNode cur = null;

        int size = lists.size();


        for (int i = size - 1; i >= 0 ;i--) {
            if (lists.get(i) == null)
                lists.remove(i);
        }

        while (!lists.isEmpty()) {
            size = lists.size();
            int minIdx = 0;
            int minVal = lists.get(0).val;
            for (int i = 1; i < size;i++) {
                if (minVal > lists.get(i).val) {
                    minVal = lists.get(i).val;
                    minIdx = i;
                }
            }
            
            ListNode m = lists.get(minIdx);
            cur = m;
            
            lists.remove(minIdx);
            if (m.next != null)
                lists.add(m.next);
            prev.next = cur;
            prev = prev.next;
            
        }
        
        return s.next;
    }

}
