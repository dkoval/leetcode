package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3810/">Find Median from Data Stream</a>
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
public interface FindMedianFromDataStream {

    // Resource: https://www.youtube.com/watch?v=EIm2n8iPA4I
    class MedianFinder {
        // Max heap is used to store the 1st half of the data steam
        private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        // Min heap is used to store the 2nd half of the data stream
        private final PriorityQueue<Integer> right = new PriorityQueue<>();

        public MedianFinder() {
            // noop
        }

        // O(logN) time
        public void addNum(int num) {
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
        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            }
            // `left` and `right` are of the same size
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
