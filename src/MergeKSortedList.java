/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */
import java.util.*;
public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
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
