package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class FlattenNestedListIterator {

    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger();

        /**
         * Return null if this NestedInteger holds a nested list.
         *
         * @return the single integer that this NestedInteger holds, if it holds a single integer.
         */
        Integer getInteger();

        /**
         * Return empty list if this NestedInteger holds a single integer.
         *
         * @return the nested list that this NestedInteger holds, if it holds a nested list.
         *
         */
        List<NestedInteger> getList();
    }

    public static class DefaultNestedInteger implements NestedInteger {
        private final Integer x;
        private final List<NestedInteger> list;

        public DefaultNestedInteger(Integer x) {
            this(requireNonNull(x), Collections.emptyList());
        }

        public DefaultNestedInteger(List<NestedInteger> list) {
            this(null, requireNonNull(list));
        }

        private DefaultNestedInteger(Integer x, List<NestedInteger> list) {
            this.x = x;
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return (x != null);
        }

        @Override
        public Integer getInteger() {
            return x;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {
        private final Iterator<Integer> iter;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iter = flatten(nestedList).iterator();
        }

        private List<Integer> flatten(List<NestedInteger> nestedList) {
            List<Integer> result = new ArrayList<>();
            for (NestedInteger x : nestedList) {
                if (x.isInteger()) {
                    result.add(x.getInteger());
                } else {
                    List<Integer> nested = flatten(x.getList());
                    result.addAll(nested);
                }
            }
            return result;
        }

        @Override
        public Integer next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }
    }
}
