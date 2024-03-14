package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">Binary Subarrays With Sum</a>
 * <p>
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 * <p>
 * A subarray is a contiguous part of the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 3 * 10^4</li>
 *  <li>nums[i] is either 0 or 1</li>
 *  <li>0 <= goal <= nums.length</li>
 * </ul>
 */
public interface BinarySubarraysWithSum {

    int numSubarraysWithSum(int[] nums, int goal);

    // O(N) time | O(N) space
    class BinarySubarraysWithSumRev1 implements BinarySubarraysWithSum {

        @Override
        public int numSubarraysWithSum(int[] nums, int goal) {
            // prefix sum -> count
            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, 1);

            int total = 0;
            int prefixSum = 0;
            for (int x : nums) {
                prefixSum += x;
                int delta = prefixSum - goal;
                if (seen.containsKey(delta)) {
                    total += seen.get(delta);
                }
                seen.put(prefixSum, seen.getOrDefault(prefixSum, 0) + 1);
            }
            return total;
        }
    }
}
