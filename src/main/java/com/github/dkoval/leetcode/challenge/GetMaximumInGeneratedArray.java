package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/">Get Maximum in Generated Array</a>
 * <p>
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * <ul>
 * <li>nums[0] = 0</li>
 * <li>nums[1] = 1</li>
 * <li>nums[2 * i] = nums[i] when 2 <= 2 * i <= n</li>
 * <li>nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n</li>
 * </ul>
 * Return the maximum integer in the array nums.
 */
public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 1; i <= (n - 1) / 2; i++) {
            nums[2 * i] = nums[i];
            nums[2 * i + 1] = nums[i] + nums[i + 1];
            max = Math.max(max, nums[2 * i]);
            max = Math.max(max, nums[2 * i + 1]);
        }
        return max;
    }
}
