/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and 
every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
import java.util.*;
public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
        
        q1.offer(root);
        
        while (!q1.isEmpty()) {
            TreeLinkNode prev = null;
            TreeLinkNode cur = q1.poll();
            
            while (cur != null) {
                if (prev != null)
                    prev.next = cur;
                if (cur.left != null) 
                    q2.offer(cur.left);
                if (cur.right != null) 
                    q2.offer(cur.right);
                prev = cur;
                cur = q1.poll();
            }
            
            
            
            q1 =  q2;
            q2 = new LinkedList<TreeLinkNode>();
        }
        
    }
}
