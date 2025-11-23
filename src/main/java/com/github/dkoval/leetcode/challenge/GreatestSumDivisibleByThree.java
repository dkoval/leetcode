package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/greatest-sum-divisible-by-three/>"Greatest Sum Divisible by Three</a>
 * <p>
 * Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 4 * 10^4</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 * </ul>
 */
public interface GreatestSumDivisibleByThree {

    int maxSumDivThree(int[] nums);

    class GreatestSumDivisibleByThreeRev1 implements GreatestSumDivisibleByThree {

        @Override
        public int maxSumDivThree(int[] nums) {
            final var n = nums.length;

            // idea: DP, take or skip each number while keeping track of the current sum % 3
            final var dp = new Integer[n][3];
            return calc(nums, 0, 0, dp);
        }

        private int calc(int[] nums, int index, int mod, Integer[][] dp) {
            // base case
            if (index == nums.length) {
                return (mod == 0) ? 0 : Integer.MIN_VALUE;
            }

            // already solved?
            if (dp[index][mod] != null) {
                return dp[index][mod];
            }

            // take
            int best = nums[index] + calc(nums, index + 1, (mod + nums[index]) % 3, dp);

            // skip
            best = Math.max(best, calc(nums, index + 1, mod, dp));

            // cache and return
            return dp[index][mod] = best;
        }
    }
}
