package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/">Minimize the Maximum Difference of Pairs</a>
 * <p>
 * You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that
 * the maximum difference amongst all the pairs is minimized.
 * Also, ensure no index appears more than once amongst the p pairs.
 * <p>
 * Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|,
 * where |x| represents the absolute value of x.
 * <p>
 * Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>0 <= p <= (nums.length)/2</li>
 * </ul>
 */
public interface MinimizeMaximumDifferenceOfPairs {

    int minimizeMax(int[] nums, int p);

    class MinimizeMaximumDifferenceOfPairsRev1 implements MinimizeMaximumDifferenceOfPairs {

        @Override
        public int minimizeMax(int[] nums, int p) {
            final var n = nums.length;

            Arrays.sort(nums);

            // binary search - "guess" the answer
            // condition: FF...FTT...T
            //                  ^ answer
            var left = 0;
            var right = nums[n - 1] - nums[0];
            while (left < right) {
                final var mid = left + (right - left) / 2;
                if (good(nums, p, mid)) {
                    // mid can be the answer;
                    // check if there's a better option to the left of it
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean good(int[] nums, int p, int target) {
            final var n = nums.length;

            var i = 0;
            var count = 0;
            while (i + 1 < n && count < p) {
                if (nums[i + 1] - nums[i] <= target) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            return count == p;
        }
    }
}