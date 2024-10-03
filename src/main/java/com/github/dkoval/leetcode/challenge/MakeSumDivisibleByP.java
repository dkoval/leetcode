package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/make-sum-divisible-by-p/">Make Sum Divisible by P</a>
 * <p>
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining
 * elements is divisible by p. It is not allowed to remove the whole array.
 * <p>
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 * <p>
 * A subarray is defined as a contiguous block of elements in the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>1 <= p <= 10^9</li>
 * </ul>
 */
public interface MakeSumDivisibleByP {

    int minSubarray(int[] nums, int p);

    class MakeSumDivisibleByPRev1 implements MakeSumDivisibleByP {

        @Override
        public int minSubarray(int[] nums, int p) {
            int n = nums.length;

            // to make the whole array divisible by k,
            // we want to remove a subarray nums[i : j] having
            // sum(nums[i : j]) % p = sum(nums) % p
            int remainder = 0;
            for (int x : nums) {
                remainder += x;
                remainder %= p;
            }

            if (remainder == 0) {
                return 0;
            }

            int best = n;

            // prefix sum -> the ending index of a prefix with this sum
            Map<Integer, Integer> lookup = new HashMap<>();
            lookup.put(0, -1);

            int prefixSum = 0;
            for (int i = 0; i < n; i++) {
                prefixSum += nums[i];
                prefixSum %= p;

                // prefixSum % p = (remainder + x) % p,
                // where x is the sum of an already seen prefix that we want to remove
                //
                // x = (prefixSum - remainder) % p
                //
                // To handle negative numbers mod p, offset by +p:
                // x = (prefixSum - remainder + p) % p
                int x = (prefixSum - remainder + p) % p;
                if (lookup.containsKey(x)) {
                    best = Math.min(best, i - lookup.get(x));
                }
                lookup.put(prefixSum, i);
            }
            return (best == n) ? -1 : best;
        }
    }
}
