package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/description/">Combination Sum IV</a>
 * <p>
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * <p>
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 200</li>
 *  <li>1 <= nums[i] <= 1000</li>
 *  <li>All the elements of nums are unique</li>
 *  <li>1 <= target <= 1000</li>
 * </ul>
 */
public interface CombinationSum4 {

    int combinationSum4(int[] nums, int target);

    class CombinationSum4DPTopDown implements CombinationSum4 {

        @Override
        public int combinationSum4(int[] nums, int target) {
            return combinationSum4(nums, target, new Integer[target + 1]);
        }

        private int combinationSum4(int[] nums, int target, Integer[] dp) {
            // base case
            if (target == 0) {
                return 1;
            }

            // already solved?
            if (dp[target] != null) {
                return dp[target];
            }

            int count = 0;
            for (int num : nums) {
                if (num <= target) {
                    count += combinationSum4(nums, target - num, dp);
                }
            }

            // cache solution to a smaller sub-problem
            dp[target] = count;
            return count;
        }
    }

    class CombinationSum4DPTopDownEarlyTerminate implements CombinationSum4 {

        @Override
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            return combinationSum4(nums, target, new Integer[target + 1]);
        }

        private int combinationSum4(int[] nums, int target, Integer[] dp) {
            // base case
            if (target == 0) {
                return 1;
            }

            // already solved?
            if (dp[target] != null) {
                return dp[target];
            }

            int count = 0;
            for (int num : nums) {
                if (num > target) {
                    // since nums[] is sorted in ASC order, every number x following num: x >= num
                    break;
                }
                count += combinationSum4(nums, target - num, dp);
            }

            // cache solution to a smaller sub-problem
            dp[target] = count;
            return count;
        }
    }

    class CombinationSumDPBottomUp implements CombinationSum4 {

        @Override
        public int combinationSum4(int[] nums, int target) {
            // dp[i] - number of possible combinations that add up to i
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int sum = 1; sum <= target; sum++) {
                for (int x : nums) {
                    if (x > sum) {
                        continue;
                    }
                    dp[sum] += dp[sum - x];
                }
            }
            return dp[target];
        }
    }
}
