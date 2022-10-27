package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/continuous-subarray-sum/">Continuous Subarray Sum</a>
 * <p>
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size
 * at least two whose elements sum up to a multiple of k, or false otherwise.
 * <p>
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>0 <= sum(nums[i]) <= 2^31 - 1</li>
 *  <li>1 <= k <= 2^31 - 1</li>
 * </ul>
 */
public interface ContinuousSubarraySum {

    boolean checkSubarraySum(int[] nums, int k);

    // Resource: https://www.youtube.com/watch?v=OKcrLfR-8mE
    // O(N) time | O(N) space
    class ContinuousSubarraySumRev1 implements ContinuousSubarraySum {

        @Override
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;

            // prefix sum (nums[0] + nums[1] + .. + nums[i]) % k -> index
            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, -1);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i] % k;
                sum %= k;

                if (!seen.containsKey(sum)) {
                    seen.put(sum, i);
                    continue;
                }

                // There exists index j such that
                // (nums[0] + ... + nums[j]) % k = sum
                //
                // On the other hand
                // (nums[0] + ... + nums[j] + nums[j + 1] + ... + nums[i]) % k = sum
                //                            ^-------------------^
                // which means that
                // (nums[j + 1] + ... + nums[i]) % k = 0 <- potential answer
                int j = seen.get(sum);

                // make sure a continuous subarray is of size >= 2
                if (i - j >= 2) {
                    return true;
                }
            }
            return false;
        }
    }
}
