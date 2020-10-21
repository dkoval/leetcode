package com.github.dkoval.leetcode.mock;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/moving-average-from-data-stream/">Moving Average from Data Stream</a>
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public abstract class MovingAverageFromDataStream {

    private MovingAverageFromDataStream() { /* prevents instantiation from the outside */}

    static class MovingAverage {
        private final Queue<Integer> window;
        private final int size;
        private int windowSum = 0;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.window = new ArrayDeque<>(size);
            this.size = size;
        }

        public double next(int val) {
            if (!window.isEmpty() && window.size() == size) {
                int first = window.poll();
                windowSum -= first;
            }
            window.add(val);
            windowSum += val;
            return (double) windowSum / window.size();
        }
    }
}
