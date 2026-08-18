package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-the-largest-almost-missing-integer/">Find the Largest Almost Missing Integer</a>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
 * <p>
 * Return the largest almost missing integer from nums. If no such integer exists, return -1.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 50</li>
 *  <li>0 <= nums[i] <= 50</li>
 *  <li>1 <= k <= nums.length</li>
 * </ul>
 */
public interface FindLargestAlmostMissingInteger {

    int largestInteger(int[] nums, int k);

    class FindLargestAlmostMissingIntegerRev1 implements FindLargestAlmostMissingInteger {

        @Override
        public int largestInteger(int[] nums, int k) {
            final var n = nums.length;

            if (k == n) {
                return maxOf(nums);
            }

            final var freqs = new HashMap<Integer, Integer>();
            for (var x : nums) {
                freqs.put(x, freqs.getOrDefault(x, 0) + 1);
            }

            if (k == 1) {
                return maxThatOccursExactlyOnce(freqs);
            }

            final var x = freqs.get(nums[0]);
            final var y = freqs.get(nums[n - 1]);

            if (x == y && x == 1) {
                return Math.max(nums[0], nums[n - 1]);
            }

            if (x == 1 && y > 1) {
                return nums[0];
            }

            if (y == 1 && x > 1) {
                return nums[n - 1];
            }

            return -1;
        }

        private int maxOf(int[] nums) {
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                max = Math.max(max, x);
            }
            return max;
        }

        private int maxThatOccursExactlyOnce(Map<Integer, Integer> freqs) {
            var max = -1;
            for (var entry : freqs.entrySet()) {
                if (entry.getValue() == 1) {
                    max = Math.max(max, entry.getKey());
                }
            }
            return max;
        }
    }
}
