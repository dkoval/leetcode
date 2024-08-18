package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return the nth ugly number.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1690
 */
public interface UglyNumber2 {

    int nthUglyNumber(int n);

    class UglyNumber2UsingMinHeap implements UglyNumber2 {

        private static final int[] FACTORS = {2, 3, 5};

        @Override
        public int nthUglyNumber(int n) {
            // generate the sequence of the first n numbers
            Queue<Long> minHeap = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();
            minHeap.offer(1L);
            seen.add(1L);
            int count = 0;
            while (true) {
                long curr = minHeap.poll();
                if (++count == n) {
                    return (int) curr;
                }

                for (int factor : FACTORS) {
                    long next = curr * factor;
                    if (!seen.contains(next)) {
                        minHeap.offer(next);
                        seen.add(next);
                    }
                }
            }
        }
    }
}
