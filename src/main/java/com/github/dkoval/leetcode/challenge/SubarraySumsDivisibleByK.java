package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 * <p>
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 3 * 10^4</li>
 *  <li>-104 <= nums[i] <= 10^4</li>
 *  <li>2 <= k <= 10^4</li>
 * </ul>
 */
public interface SubarraySumsDivisibleByK {

    int subarraysDivByK(int[] nums, int k);

    class SubarraySumsDivisibleByKRev2 implements SubarraySumsDivisibleByK {

        @Override
        public int subarraysDivByK(int[] nums, int k) {
            // sum(nums[0 : i]) % k -> count
            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, 1);

            int total = 0;
            int sum = 0;
            for (int x : nums) {
                sum += x;
                sum %= k;

                // corner case: handle mod of negative numbers
                if (sum < 0) {
                    sum += k;
                }

                int count = 0;
                if (seen.containsKey(sum)) {
                    count = seen.get(sum);
                    total += count;
                }
                seen.put(sum, count + 1);
            }
            return total;
        }
    }

    class SubarraySumsDivisibleByKRev3 implements SubarraySumsDivisibleByK {

        @Override
        public int subarraysDivByK(int[] nums, int k) {
            // sum(nums[0 : i]) % k -> count
            int[] seen = new int[k];
            seen[0] = 1;

            int total = 0;
            int sum = 0;
            for (int x : nums) {
                sum += x;
                sum %= k;

                // corner case : handle mod of negative numbers
                if (sum < 0) {
                    sum += k;
                }

                if (seen[sum] > 0) {
                    total += seen[sum];
                }
                seen[sum]++;
            }
            return total;
        }
    }
}
