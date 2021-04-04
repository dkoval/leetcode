package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3696/">Design Circular Queue</a>
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations
 * are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position
 * to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space
 * in front of the queue. But using the circular queue, we can use the space to store new values.
 */
public class DesignCircularQueue {

    public static class MyCircularQueue {
        private final int[] ringBuffer;
        private int front = 0;
        private int rear = -1;
        private int size = 0;

        /**
         * Initializes the object with the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.ringBuffer = new int[k];
        }

        /**
         * Inserts an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % ringBuffer.length;
            ringBuffer[rear] = value;
            size++;
            return true;
        }

        /**
         * Deletes an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % ringBuffer.length;
            size--;
            return true;
        }

        /**
         * Gets the front item from the queue. If the queue is empty, return -1.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return ringBuffer[front];
        }

        /**
         * Gets the last item from the queue. If the queue is empty, return -1.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return ringBuffer[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == ringBuffer.length;
        }
    }
}
