package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-erasure-value/">Maximum Erasure Value</a>
 * <p>
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 * <p>
 * Return the maximum score you can get by erasing exactly one subarray.
 * <p>
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is,
 * if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 * </ul>
 */
public interface MaximumErasureValue {

    int maximumUniqueSubarray(int[] nums);

    class MaximumErasureValueRev1 implements MaximumErasureValue {

        // O(N) time | O(N) space
        @Override
        public int maximumUniqueSubarray(int[] nums) {
            int n = nums.length;

            Map<Integer, Integer> lastIdx = new HashMap<>();
            lastIdx.put(nums[0], 0);

            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];

            int maxSum = nums[0];
            int start = 0;
            for (int end = 1; end < n; end++) {
                if (lastIdx.containsKey(nums[end])) {
                    int idx = lastIdx.get(nums[end]);
                    if (idx >= start) {
                        start = idx + 1;
                    }
                }
                prefixSum[end] = nums[end] + prefixSum[end - 1];
                lastIdx.put(nums[end], end);
                maxSum = Math.max(maxSum, prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0));
            }
            return maxSum;
        }
    }

    class MaximumErasureValueRev2 implements MaximumErasureValue {

        // O(N) time | O(N) space
        @Override
        public int maximumUniqueSubarray(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> frequency = new HashMap<>();
            int maxSum = 0, currSum = 0;
            // sliding window containing only unique elements
            int l = 0, r = 0;
            while (r < n) {
                frequency.put(nums[r], frequency.getOrDefault(nums[r], 0) + 1);
                currSum += nums[r];

                // shift left boundary until there is no duplicates left in a subarray nums[l:r]
                while (frequency.get(nums[r]) > 1) {
                    frequency.put(nums[l], frequency.get(nums[l]) - 1);
                    currSum -= nums[l];
                    l++;
                }

                r++;
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
    }
}
