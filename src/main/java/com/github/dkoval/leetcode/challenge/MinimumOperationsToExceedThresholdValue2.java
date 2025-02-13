package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/">Minimum Operations to Exceed Threshold Value II</a>
 * <p>
 * You are given a 0-indexed integer array nums, and an integer k.
 * <p>
 * You are allowed to perform some operations on nums, where in a single operation, you can:
 * <ul>
 *  <li>Select the two smallest integers x and y from nums.</li>
 *  <li>Remove x and y from nums.</li>
 *  <li>Insert (min(x, y) * 2 + max(x, y)) at any position in the array.</li>
 * </ul>
 * Note that you can only apply the described operation if nums contains at least two elements.
 * <p>
 * Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 */
public interface MinimumOperationsToExceedThresholdValue2 {

    int minOperations(int[] nums, int k);

    class MinimumOperationsToExceedThresholdValue2Rev1 implements MinimumOperationsToExceedThresholdValue2 {

        @Override
        public int minOperations(int[] nums, int k) {
            final var q = new PriorityQueue<Long>();
            for (var x : nums) {
                q.offer((long) x);
            }

            var count = 0;
            while (q.size() >= 2 && q.peek() < k) {
                // x < y
                var x = q.poll();
                var y = q.poll();
                // Insert: min(x, y) * 2 + max(x, y)
                q.offer(2 * x + y);
                count++;
            }
            return count;
        }
    }
}
