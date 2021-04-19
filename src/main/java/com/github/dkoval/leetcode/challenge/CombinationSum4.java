package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        return combinationSum4(nums, target, memo);
    }

    private int combinationSum4(int[] nums, int target, Map<Integer, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int count = 0;
        for (int num : nums) {
            if (num <= target) {
                count += combinationSum4(nums, target - num, memo);
            }
        }
        memo.put(target, count);
        return count;
    }
}
