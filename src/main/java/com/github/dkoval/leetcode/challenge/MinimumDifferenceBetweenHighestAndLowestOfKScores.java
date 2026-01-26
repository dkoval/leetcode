package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/">Minimum Difference Between Highest and Lowest of K Scores</a>
 * <p>
 * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
 * <p>
 * Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
 * <p>
 * Return the minimum possible difference.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MinimumDifferenceBetweenHighestAndLowestOfKScores {

    int minimumDifference(int[] nums, int k);

    class MinimumDifferenceBetweenHighestAndLowestOfKScoresRev1 implements MinimumDifferenceBetweenHighestAndLowestOfKScores {

        @Override
        public int minimumDifference(int[] nums, int k) {
            final var n = nums.length;

            // to keep the numbers as close to each other as possible
            Arrays.sort(nums);

            // sliding window of size k
            var best = Integer.MAX_VALUE;
            for (var i = 0; i <= n - k; i++) {
                final var diff = nums[i + k - 1] - nums[i];
                best = Math.min(best, diff);
            }
            return best;
        }
    }
}
