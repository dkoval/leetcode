package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/">Running Sum of 1d Array</a>
 * <p>
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0, ..., nums[i]).
 * <p>
 * Return the running sum of nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  </li>-10^6 <= nums[i] <= 10^6</li>
 * </ul>
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
