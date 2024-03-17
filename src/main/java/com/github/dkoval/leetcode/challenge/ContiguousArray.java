package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contiguous-array/">Contiguous Array</a>
 * <p>
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>nums[i] is either 0 or 1</li>
 * </ul>
 */
public interface ContiguousArray {

    int findMaxLength(int[] nums);

    class ContiguousArrayRev2 implements ContiguousArray {

        @Override
        public int findMaxLength(int[] nums) {
            int n = nums.length;

            // nums       = [0, 1, 0, 0, 1]
            // prefix sum = [-1, 0, -1, -2, -1]

            // prefix sum -> index
            Map<Integer, Integer> lookup = new HashMap<>();
            lookup.put(0, -1);

            int maxLength = 0;
            int prefixSum = 0;
            for (int i = 0; i < n; i++) {
                prefixSum += (nums[i] == 0) ? -1 : 1;
                if (!lookup.containsKey(prefixSum)) {
                    lookup.put(prefixSum, i);
                } else {
                    int index = lookup.get(prefixSum);
                    maxLength = Math.max(maxLength, i - index);
                }
            }
            return maxLength;
        }
    }
}
