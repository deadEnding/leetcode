package L225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 11:01 AM 7/24/16
 * @version: 1.0
 * @description: Leetcode 225. Implement Stack using Queues
 */


/* 保证最后压入栈的元素始终在队列的头部 */
class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Retrue empty queue or not according to `isEmpty`
    private Queue<Integer> getEmptyQueueOrNot(boolean isEmpty) {
        return q1.isEmpty() == isEmpty ? q1 : q2;
    }

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> eq = getEmptyQueueOrNot(true);
        Queue<Integer> neq = getEmptyQueueOrNot(false);
        eq.offer(x);
        while (!neq.isEmpty())
            eq.offer(neq.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        getEmptyQueueOrNot(false).poll();
    }

    // Get the top element.
    public int top() {
        return getEmptyQueueOrNot(false).peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
    }
}
