package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-fair-pairs/">Count the Number of Fair Pairs</a>
 * <p>
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 * <p>
 * A pair (i, j) is fair if:
 * <ul>
 *  <li>0 <= i < j < n, and</li>
 *  <li>lower <= nums[i] + nums[j] <= upper</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>nums.length == n</li>
 *  <li>-109 <= nums[i] <= 10^9</li>
 *  <li>-109 <= lower <= upper <= 10^9</li>
 * </ul>
 */
public interface CountNumberOfFairPairs {

    long countFairPairs(int[] nums, int lower, int upper);

    class CountNumberOfFairPairsRev1 implements CountNumberOfFairPairs {

        @Override
        public long countFairPairs(int[] nums, int lower, int upper) {
            int n = nums.length;

            // Idea: fix nums[i] and binary search nums[j] such that
            // condition lower <= nums[i] + nums[j] <= upper is satisfied
            Arrays.sort(nums);

            long count = 0;
            for (int i = 0; i < n - 1; i++) {
                // we are looking for nums[j]
                // lower <= nums[i] + nums[j] <= upper
                // lower - nums[i] <= nums[j] <= upper - nums[i]
                // <=>
                //
                // 1. nums[j] >= lower - nums[i]
                // FF...FTT...T
                //       ^ answer (min number that satisfies the condition)
                //
                // 2. nums[j] <= upper - nums[i]
                // TT...TFF...F
                //      ^ answer (max number that satisfies the condition)
                int left = bisectLeft(nums, lower - nums[i]);
                if (left < 0) {
                    continue;
                }

                // avoid double counting since (nums[i], nums[j]) and (nums[j], nums[i]) pairs  are considered the same
                left = Math.max(left, i + 1);

                int right = bisectRight(nums, upper - nums[i]);
                if (right >= n) {
                    continue;
                }

                if (left <= right) {
                    // for a fixed nums[i], the number of nums[j] to make a valid pair with is  (right - left + 1)
                    count += right - left + 1;
                }
            }
            return count;
        }

        private int bisectLeft(int[] nums, int target) {
            // x >= target
            // FF...FTT...T
            //       ^ answer (min number that satisfies the condition)
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    // mid can't be the answer
                    left = mid + 1;
                } else {
                    // mid may be the answer;
                    // check if there's a better option to the left of mid
                    right = mid;
                }
            }
            return (nums[left] >= target) ? left : -1;
        }

        private int bisectRight(int[] nums, int target) {
            // x <= target
            // TT...TFF...F
            //      ^ answer (max number that satisfies the condition)
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // mid can't be the answer
                    right = mid - 1;
                } else {
                    // mid may be the answer;
                    // check if there's a better option to the right of mid
                    left = mid;
                }
            }
            return (nums[left] <= target) ? left : nums.length;
        }
    }
}
