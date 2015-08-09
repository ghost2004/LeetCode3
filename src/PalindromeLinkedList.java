/*
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
import java.util.*;
public class PalindromeLinkedList {
    // Space O(n) solution, with stack
    public boolean isPalindromeV1(ListNode head) {
        if (head == null || head.next == null)
            return true;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        
        node = head;
        while (node != null) {
            int val = stack.pop();
            if (val != node.val)
                return false;
            node = node.next;
        }
        return true;
    }
    
    // Space O(1) solution
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // slow pointer
        ListNode slow = head;
        // fast pointer
        ListNode fast = head.next;
        
        while (fast.next != null && fast.next.next != null) {
            // slow pointer moves one node per time 
            slow = slow.next;
            // fast pointer moves 2 nodes per time
            fast = fast.next.next;
        }
        
        // the start pointer of 2nd part
        ListNode sec = slow.next;
        // cut the linked list into half
        slow.next = null;
        
        // reverse the 2nd part 
        ListNode p1 = sec;
        ListNode p2 = sec.next;
        ListNode p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        
        sec.next = null;
        
        p2 = head;
        // compare 1st part with 2nd part
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        
        return true;
    }

}
