package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603/">Minimum Operations to Reduce X to Zero</a>
 * <p>
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost
 * or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 */
public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int targetSum = -x;
        for (int num : nums) {
            targetSum += num;
        }
        if (targetSum == 0) {
            return nums.length;
        }
        int length = maxSumSubarrayLength(nums, targetSum);
        return (length > 0) ? nums.length - length : -1;
    }

    private int maxSumSubarrayLength(int[] nums, int sum) {
        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int targetSum = prefixSum - sum;
            if (map.containsKey(targetSum)) {
                int currLength = i - map.get(targetSum);
                maxLength = Math.max(maxLength, currLength);
            }
            map.put(prefixSum, i);
        }
        return maxLength;
    }
}
