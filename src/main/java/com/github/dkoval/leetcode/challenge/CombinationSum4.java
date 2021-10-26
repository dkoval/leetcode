package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3713/">Combination Sum IV</a>
 * <p>
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 200</li>
 *  <li>1 <= nums[i] <= 1000</li>
 *  <li>All the elements of nums are unique</li>
 *  <li>1 <= target <= 1000</li>
 * </ul>
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new Integer[target + 1]);
    }

    private int combinationSum4(int[] nums, int target, Integer[] memo) {
        // base case
        if (target == 0) {
            return 1;
        }

        // already solved?
        if (memo[target] != null) {
            return memo[target];
        }

        int count = 0;
        for (int num : nums) {
            if (num <= target) {
                count += combinationSum4(nums, target - num, memo);
            }
        }

        // cache solution to a smaller sub-problem
        memo[target] = count;
        return count;
    }
}
