package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/">Number of Subsequences That Satisfy the Given Sum Condition</a>
 * <p>
 * You are given an array of integers nums and an integer target.
 * <p>
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 *  <li>1 <= target <= 10^6</li>
 * </ul>
 */
public interface NumberOfSubsequencesThatSatisfyGivenSumCondition {

    int MOD = 1_000_000_007;

    int numSubseq(int[] nums, int target);

    class NumberOfSubsequencesThatSatisfyGivenSumConditionRev1 implements NumberOfSubsequencesThatSatisfyGivenSumCondition {

        private static int[] pow2(int n) {
            int[] pow2 = new int[n];
            pow2[0] = 1;
            for (int i = 1; i < n; i++) {
                pow2[i] = pow2[i - 1] * 2;
                pow2[i] %= MOD;
            }
            return pow2;
        }

        @Override
        public int numSubseq(int[] nums, int target) {
            // idea: 2-pointers algorithm
            final var n = nums.length;
            Arrays.sort(nums);

            // pre-compute 2^x to avoid TLE
            int[] pow2 = pow2(n);

            var count = 0;
            var left = 0;
            var right = n - 1;
            while (left <= right) {
                while (left <= right && nums[left] + nums[right] > target) {
                    right--;
                }

                if (left > right) {
                    break;
                }

                // nums[left] is ALWAYS included in a subsequence
                // we can use [nums[left] : nums[right]] numbers
                // there are 2^(right - left) subsequences we can make from [..., nums[right]] numbers
                count += pow2[right - left];
                count %= MOD;
                left++;
            }
            return count;
        }
    }
}
