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
public interface MinimumOperationsToReduceXToZero {

    int minOperations(int[] nums, int x);

    class MinimumOperationsToReduceXToZeroRev1 implements MinimumOperationsToReduceXToZero {

        // O(N) time | O(N) space
        @Override
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int minNumOps = Integer.MAX_VALUE;

            Map<Integer, Integer> prefixSumToNumOps = new HashMap<>();
            prefixSumToNumOps.put(0, 0);

            // process prefix sum
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                prefixSumToNumOps.put(sum, i + 1);
            }

            if (sum < x) {
                return -1;
            }

            if (prefixSumToNumOps.containsKey(x)) {
                minNumOps = prefixSumToNumOps.get(x);
            }

            // process suffix sum
            sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                // x = some prefixSum + some suffixSum
                sum += nums[i];
                int complement = x - sum;
                if (prefixSumToNumOps.containsKey(complement)) {
                    minNumOps = Math.min(minNumOps, prefixSumToNumOps.get(complement) + (n - i));
                }
            }

            return (minNumOps != Integer.MAX_VALUE) ? minNumOps : -1;
        }
    }

    class MinimumOperationsToReduceXToZeroRev2 implements MinimumOperationsToReduceXToZero {

        // O(N) time | O(N) space
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum == x) {
                return nums.length;
            }

            int length = maxSumSubarrayLength(nums, sum - x);
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

    // O(N) time | O(1) space
    class MinimumOperationsToReduceXToZeroRev3 implements MinimumOperationsToReduceXToZero {

        @Override
        public int minOperations(int[] nums, int x) {
            int n = nums.length;

            // find the length of the longest subarray that sums up to target = sum(nums) - x,
            // then answer = N - L
            int target = -x;
            for (int num : nums) {
                target += num;
            }

            // corner cases
            if (target < 0) {
                return -1;
            }

            if (target == 0) {
                return n;
            }

            // sliding window
            int left = 0;
            int sum = 0;
            int len = 0;
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while (sum > target) {
                    sum -= nums[left];
                    left++;
                }
                if (sum == target) {
                    len = Math.max(len, right - left + 1);
                }
            }
            return (len > 0) ? n - len : -1;
        }
    }
}
