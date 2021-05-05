package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3731/">Non-decreasing Array</a>
 * <p>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 10^4</li>
 * <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        // Idea of the algorithm
        // 1. Invariant to keep nums[] sorted in non-decreasing order: nums[i - 1] <= nums[i] <= nums[i + 1]
        // 2. It's allowed to "fix" at most 1 element in nums[].
        boolean changedOneElement = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (changedOneElement) {
                    return false;
                }
                // [..., 3, 4, 2, ...] -> [..., 3, 4, 4, ...]
                //       |  ^  |                |  ^  |
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                changedOneElement = true;
            }
        }
        return true;
    }
}
