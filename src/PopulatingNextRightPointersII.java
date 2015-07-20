/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        // pointer to parent level node
        TreeLinkNode parent = root;
        // pointer to this level header
        TreeLinkNode head = null;
        // current pointer of this level
        TreeLinkNode cur = null;
        
        while (parent !=  null) {
            // scan parent level
            while (parent != null) {
                // when left child is not null
                if (parent.left != null) {
                    if (head == null) {
                        // didn't setup head of this level yet
                        head = parent.left;
                        cur = head;
                    } else {
                        cur.next = parent.left;
                        cur = cur.next;
                    }
                    
                }
                // when right child is not null
                if (parent.right != null) {
                    if (head == null) {
                        // didn't setup head of this level yet
                        head = parent.right;
                        cur = head;
                    } else {
                        cur.next = parent.right;
                        cur = cur.next;
                    }
                }
                // move to next sibling
                parent = parent.next;
            }
            // move to next level
            parent = head;
            head = null;
        }
        
    }
    
}
