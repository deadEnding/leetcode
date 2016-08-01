package L341_FlattenNestedListIterator;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:06 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 341. Flatten Nested List Iterator
 */


interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

interface Iterator<T> {
    public Integer next();
    public boolean hasNext();
}

public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            stack = new LinkedList<>();
        } else {
            stack = new LinkedList<>(nestedList);
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--)
                stack.push(list.get(i));
        }
        return !stack.isEmpty();
    }
}
