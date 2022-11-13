package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 * <p>
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value and the median is the mean of the two middle values.
 * <ul>
 *  <li>For example, for arr = [2,3,4], the median is 3.</li>
 *  <li>For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.</li>
 * </ul>
 * Implement the MedianFinder class:
 * <ul>
 *  <li>MedianFinder() initializes the MedianFinder object.</li>
 *  <li>void addNum(int num) adds the integer num from the data stream to the data structure.</li>
 *  <li>double findMedian() returns the median of all elements so far. Answers within 10^-5 of the actual answer will be accepted.</li>
 * </ul>
 */
public interface MedianFinder {

    void addNum(int num);

    double findMedian();

    // Resource: https://www.youtube.com/watch?v=EIm2n8iPA4I
    class MedianFinderRev1 implements MedianFinder {
        // Max heap is used to store the 1st half of the data steam
        private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        // Min heap is used to store the 2nd half of the data stream
        private final PriorityQueue<Integer> right = new PriorityQueue<>();

        public MedianFinderRev1() {
            // noop
        }

        // O(logN) time
        @Override
        public void addNum(int num) {
            // Invariant: after adding a `num`, the size of max heap differs by at most element
            left.offer(num);

            int x = left.poll();
            right.offer(x);

            // perform the balancing
            if (left.size() < right.size()) {
                x = right.poll();
                left.offer(x);
            }
        }

        // O(1) time
        @Override
        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            }
            // both max and min heaps are of the same size
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    // Resource: https://www.youtube.com/watch?v=itmhHWaHupI
    class MedianFinderRev2 implements MedianFinder {
        // Invariants to preserve:
        // #1. Every element in "left" (max heap) <= every element in "right" (min heap).
        // #2. "left" and "right" heaps hold roughly N / 2 numbers; if N is odd,
        // either "left" or "right" heap is allowed to hold an extra number, i.e.
        // |size(left) - size(right)| < 2
        private final Queue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        private final Queue<Integer> right = new PriorityQueue<>();

        public MedianFinderRev2() {
            // noop
        }

        @Override
        public void addNum(int num) {
            left.offer(num);

            // invariant #1 - ensure non-decreasing order
            // before: [1, 2, 7] | [3, 4]
            // after:  [1, 2] | [3, 4, 7]
            if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                int x = left.poll(); // max number in "left"
                right.offer(x);
            }

            // invariant #2 - balance sizes of two heaps
            // before: [1, 2, 3, 4] | [5, 6]
            // after:  [1, 2, 3] | [4, 5, 6]
            if (left.size() > right.size() + 1) {
                int x = left.poll(); // max number in "left"
                right.offer(x);
            }

            // before: [1, 2] | [3, 4, 5, 6]
            // after:  [1, 2, 3] | [4, 5, 6]
            if (right.size() > left.size() + 1) {
                int x = right.poll(); // min number in "right"
                left.offer(x);
            }
        }

        @Override
        public double findMedian() {
            if (left.size() > right.size()) {
                // "left" heap holds an extra number
                return left.peek();
            }

            if (right.size() > left.size()) {
                // "right" heap holds an extra number
                return right.peek();
            }

            // "left" and "right" heaps have equal number of items
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
