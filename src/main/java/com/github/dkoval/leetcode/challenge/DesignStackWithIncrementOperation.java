package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation/">Design a Stack With Increment Operation</a>
 * <p>
 * Design a stack that supports increment operations on its elements.
 * <p>
 * Implement the CustomStack class:
 * <ul>
 *  <li>CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.</li>
 *  <li>void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.</li>
 *  <li>int pop() Pops and returns the top of the stack or -1 if the stack is empty.</li>
 *  <li>void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= maxSize, x, k <= 1000</li>
 *  <li>0 <= val <= 100</li>
 *  <li>At most 1000 calls will be made to each method of increment, push and pop each separately.</li>
 * </ul>
 */
public interface DesignStackWithIncrementOperation {

    abstract class CustomStack {
        protected final int maxSize;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        abstract public void push(int x);

        abstract public int pop();

        abstract void increment(int k, int val);
    }

    final class CustomStackRev1 extends CustomStack {
        // dummy head and tail nodes
        private final Node head = new Node(Integer.MIN_VALUE);
        private final Node tail = new Node(Integer.MAX_VALUE);

        private int size = 0;

        public CustomStackRev1(int maxSize) {
            super(maxSize);
            head.next = tail;
            tail.prev = head;
        }

        @Override
        public void push(int x) {
            if (size == maxSize) {
                return;
            }

            Node newNode = new Node(x);
            Node last = tail.prev;

            last.next = newNode;
            newNode.prev = last;
            newNode.next = tail;
            tail.prev = newNode;

            size++;
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;

            size--;
            return last.x;
        }

        @Override
        public void increment(int k, int val) {
            if (isEmpty()) {
                return;
            }

            k = Math.min(k, size);
            Node curr = head.next;
            while (k-- > 0) {
                curr.x += val;
                curr = curr.next;
            }
        }

        private boolean isEmpty() {
            return head.next == tail;
        }

        // a node of a doubly-linked list
        private static class Node {
            Node prev;
            Node next;
            private int x;

            Node(int x) {
                this.x = x;
            }
        }
    }

    final class CustomStackRev2 extends CustomStack {
        private final int[] items;
        // index of the last element in the stack
        private int index = -1;

        public CustomStackRev2(int maxSize) {
            super(maxSize);
            this.items = new int[maxSize];
        }

        @Override
        public void push(int x) {
            if (isFull()) {
                return;
            }
            items[++index] = x;
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return items[index--];
        }

        @Override
        public void increment(int k, int val) {
            for (int i = 0; i <= Math.min(index, k - 1); i++) {
                items[i] += val;
            }
        }

        private boolean isFull() {
            return index == maxSize - 1;
        }

        private boolean isEmpty() {
            return index < 0;
        }
    }
}
