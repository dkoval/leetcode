package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.function.BiFunction;

/**
 * <a href="https://leetcode.com/problems/trionic-array-ii/">Trionic Array II (Hard)</a>
 * <p>
 * You are given an integer array nums of length n.
 * <p>
 * A trionic subarray is a contiguous subarray nums[l...r] (with 0 <= l < r < n) for which there exist indices l < p < q < r such that:
 * <ul>
 *  <li>nums[l...p] is strictly increasing,</li>
 *  <li>nums[p...q] is strictly decreasing,</li>
 *  <li>nums[q...r] is strictly increasing.</li>
 * </ul>
 * Return the maximum sum of any trionic subarray in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>4 <= n = nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 *  <li>It is guaranteed that at least one trionic subarray exists.</li>
 * </ul>
 */
public interface TrionicArray2 {

    long maxSumTrionic(int[] nums);

    class TrionicArray2Rev1 implements TrionicArray2 {

        @Override
        public long maxSumTrionic(int[] nums) {
            final var n = nums.length;

            // step 1: find decreasing chunks
            final var decreasing = new ArrayList<Interval>();
            var start = -1;
            var sum = 0L;
            for (var i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (start < 0) {
                        start = i;
                    }
                    sum += nums[i];
                } else {
                    if (start >= 0) {
                        sum += nums[i];
                        decreasing.add(new Interval(start, i, sum));
                        start = -1;
                        sum = 0;
                    }
                }
            }

            // step 2: find increasing chunks to the left and to the right of a decreasing one
            var best = Long.MIN_VALUE;
            for (var interval : decreasing) {
                if (interval.start == 0 || interval.end == n - 1) {
                    continue;
                }

                var leftSum = maxSumOfIncreasing(nums, interval.start, -1, (a, b) -> a > b);
                var rightSum = maxSumOfIncreasing(nums, interval.end, 1, (a, b) -> a < b);
                best = Math.max(best, interval.sum + leftSum + rightSum);
            }
            return best;
        }

        private long maxSumOfIncreasing(int[] nums, int start, int step, BiFunction<Integer, Integer, Boolean> comparator) {
            var i = start;
            var total = 0L;
            var best = Long.MIN_VALUE;
            while (i > 0 && i < nums.length - 1 && comparator.apply(nums[i], nums[i + step])) {
                i += step;
                total += nums[i];
                best = Math.max(best, total);
            }
            return best;
        }

        record Interval(int start, int end, long sum) {
        }
    }
}
