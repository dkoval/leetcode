package com.github.dkoval.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/target-sum/">Target Sum</a>
 * <p>
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 20</li>
 *  <li>0 <= nums[i] <= 1000</li>
 *  <li>0 <= sum(nums[i]) <= 1000</li>
 *  <li>-1000 <= target <= 1000</li>
 * </ul>
 */
public interface TargetSum {

    int findTargetSumWays(int[] nums, int target);

    class TargetSumDPTopDown implements TargetSum {

        @Override
        public int findTargetSumWays(int[] nums, int target) {
            Map<String, Integer> memo = new HashMap<>();
            return doFindTargetSumWays(nums, 0, 0, target, memo);
        }

        // Sub-problem definition:
        // Returns the number of combinations of adding and subtracting numbers after index idx (including idx),
        // where the sum of those numbers equals to (target - sum)
        // ---
        // Complexity analysis:
        // idx: 0 .. (N - 1)
        // sum: -sumOf(nums) .. +sumOf(nums)
        // O(N * sumOf(nums)) time | O(N * sumOf(nums)) space
        private int doFindTargetSumWays(int[] nums, int idx, int sum, int target, Map<String, Integer> memo) {
            if (idx == nums.length) {
                return (sum == target) ? 1 : 0;
            }

            String key = idx + "|" + sum;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int count = 0;

            // option #1: + nums[idx]
            count += doFindTargetSumWays(nums, idx + 1, sum + nums[idx], target, memo);

            // option #2: - nums[idx]
            count += doFindTargetSumWays(nums, idx + 1, sum - nums[idx], target, memo);

            memo.put(key, count);
            return count;
        }
    }
}
