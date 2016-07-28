package L232_ImplementQueueUsingStacks;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:28 AM 7/24/16
 * @version: 1.0
 * @description: Leetcode 232. Implement Queue using Stacks
 */


/* 保证最先加入队列的元素始终在栈顶 */
class MyQueue {
    LinkedList<Integer> s1 = new LinkedList<>();
    LinkedList<Integer> s2 = new LinkedList<>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        s1.pop();
    }

    // Get the front element.
    public int peek() {
        return s1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
    }
}
