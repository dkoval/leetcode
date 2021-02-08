package com.github.dkoval.leetcode.challenge;

import java.util.Iterator;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3633/">Peeking Iterator</a>
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation - it essentially peek() at the element that will be returned by the next call to next().
 */
public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer next;
    private Boolean lastCalledNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (lastCalledNext == null || lastCalledNext == Boolean.TRUE) {
            next = iterator.next();
        }
        lastCalledNext = Boolean.FALSE;
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = (lastCalledNext == Boolean.FALSE) ? next : iterator.next();
        lastCalledNext = Boolean.TRUE;
        return result;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || lastCalledNext == Boolean.FALSE;
    }
}
