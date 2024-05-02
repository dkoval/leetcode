package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/">Largest Positive Integer That Exists With Its Negative</a>
 * <p>
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also
 * exists in the array.
 * <p>
 * Return the positive integer k. If there is no such integer, return -1.
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>-1000 <= nums[i] <= 1000</li>
 *  <li>nums[i] != 0</li>
 * </ul>
 */
public interface LargestPositiveIntegerThatExistsWithItsNegative {

    int findMaxK(int[] nums);

    class LargestPositiveIntegerThatExistsWithItsNegativeRev1 implements LargestPositiveIntegerThatExistsWithItsNegative {

        @Override
        public int findMaxK(int[] nums) {
            Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
            Set<Integer> negative = new HashSet<>();
            for (int x : nums) {
                if (x > 0) {
                    q.offer(x);
                } else {
                    negative.add(x);
                }
            }

            while (!q.isEmpty()) {
                int x = q.poll();
                if (negative.contains(-x)) {
                    return x;
                }
            }
            return -1;
        }
    }
}
