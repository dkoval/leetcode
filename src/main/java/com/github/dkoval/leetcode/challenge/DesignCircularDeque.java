package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/design-circular-deque/">Design Circular Deque</a>
 * <p>
 * Design your implementation of the circular double-ended queue (deque).
 * <p>
 * Implement the MyCircularDeque class:
 * <ul>
 *  <li>MyCircularDeque(int k) Initializes the deque with a maximum size of k.</li>
 *  <li>boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.</li>
 *  <li>boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.</li>
 *  <li>boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.</li>
 *  <li>boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.</li>
 *  <li>int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.</li>
 *  <li>int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.</li>
 *  <li>boolean isEmpty() Returns true if the deque is empty, or false otherwise.</li>
 *  <li>boolean isFull() Returns true if the deque is full, or false otherwise.</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= 1000</li>
 *  <li>0 <= value <= 1000</li>
 *  <li>At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.</li>
 * </ul>
 */
public interface DesignCircularDeque {

    abstract class MyCircularDeque {
        protected final int k;

        public MyCircularDeque(int k) {
            this.k = k;
        }

        public abstract boolean insertFront(int value);

        public abstract boolean insertLast(int value);

        public abstract boolean deleteFront();

        public abstract boolean deleteLast();

        public abstract int getFront();

        public abstract int getRear();

        public abstract boolean isEmpty();

        public abstract boolean isFull();
    }

    final class MyCircularDequeRev1 extends MyCircularDeque {
        private Node head;
        private Node tail;
        private int size = 0;

        public MyCircularDequeRev1(int k) {
            super(k);
        }

        @Override
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            Node newNode = new Node(value);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            size++;
            return true;
        }

        @Override
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            Node newNode = new Node(value);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            size++;
            return true;
        }

        @Override
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }

            size--;
            return true;
        }


        @Override
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
            }

            size--;
            return true;
        }

        @Override
        public int getFront() {
            return isEmpty() ? -1 : head.value;
        }

        @Override
        public int getRear() {
            return isEmpty() ? -1 : tail.value;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean isFull() {
            return size == k;
        }

        // node of a doubly-linked list
        private static class Node {
            int value;
            Node prev;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }
    }
}
