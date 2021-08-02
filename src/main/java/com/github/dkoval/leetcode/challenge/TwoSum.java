package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3836/">Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^4</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 *  <li>-10^9 <= target <= 10^9</li>
 *  <li>Only one valid answer exists</li>
 * </ul>
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class TwoSum {

    // O(N) time | O(N) space
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }
}
