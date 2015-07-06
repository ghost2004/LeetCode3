/*
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop
 from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by 
using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be 
called on an empty stack).
 */
import java.util.*;
public class MyStackInQueue {
    /* implement queue by stack
    Stack<Integer> incoming = new Stack<Integer>();
    Stack<Integer> outgoing = new Stack<Integer>();
    
    public void push(int x) {
        incoming.push(x);
    }

    public void pop() {
        if (outgoing.isEmpty()) {
            while (!incoming.isEmpty()) {
                outgoing.push(incoming.pop());
            }
        }
        
        outgoing.pop();
    }

    public int top() {
        if (outgoing.isEmpty()) {
            while (!incoming.isEmpty()) {
                outgoing.push(incoming.pop());
            }
        }
        return outgoing.peek();
    }

    public boolean empty() {
        return (incoming.isEmpty() && outgoing.isEmpty());
        
    }
    
    public static void main(String args[]) {
        MyStackInQueue q = new MyStackInQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.top());
    }
    */
    ArrayDeque<Integer> q1 = new ArrayDeque<Integer>();
    ArrayDeque<Integer> q2 = new ArrayDeque<Integer>();
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        
        ArrayDeque<Integer> tmp = q2;
        q2 = q1;
        q1 = tmp;
        
    }
    public void pop() {
        q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
        
    }
}
