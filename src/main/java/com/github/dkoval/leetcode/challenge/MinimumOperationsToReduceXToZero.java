package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Minimum Operations to Reduce X to Zero</a>
 * <p>
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost
 * or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 *  <li>1 <= x <= 10^9</li>
 * </ul>
 */
public class MinimumOperationsToReduceXToZero {

    // O(N) time | O(N) space
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

    private int maxSumSubarrayLength(int[] nums, int targetSum) {
        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int sum = prefixSum - targetSum;
            if (prefixSumToIndex.containsKey(sum)) {
                int currLength = i - prefixSumToIndex.get(sum);
                maxLength = Math.max(maxLength, currLength);
            }
            prefixSumToIndex.put(prefixSum, i);
        }
        return maxLength;
    }
}
