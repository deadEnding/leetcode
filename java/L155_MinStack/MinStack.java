package L155_MinStack;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:35 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 155. Min Stack
 */


public class MinStack {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> mins = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
        mins.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if (x <= mins.getFirst())
            mins.push(x);
        stack.push(x);
    }

    public void pop() {
        if (mins.getFirst().equals(stack.getFirst()))
            mins.pop();
        stack.pop();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return mins.getFirst();
    }
}
