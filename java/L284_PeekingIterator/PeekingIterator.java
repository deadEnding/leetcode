package L284_PeekingIterator;

/**
 * @author: deadend
 * @date: 12:44 PM 7/27/16
 * @version: 1.0
 * @description: Leetcode 284. Peeking Iterator
 */

interface Iterator<T> {
    boolean hasNext();
    T next();
}


class PeekingIterator implements Iterator<Integer> {

    private Integer cache = null;
    private Iterator<Integer> iter = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext())
            cache = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = cache;
        if (iter.hasNext())
            cache = iter.next();
        else
            cache = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}
