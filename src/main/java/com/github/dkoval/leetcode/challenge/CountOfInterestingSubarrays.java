package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-of-interesting-subarrays/">Count of Interesting Subarrays</a>
 * <p>
 * You are given a 0-indexed integer array nums, an integer modulo, and an integer k.
 * <p>
 * Your task is to find the count of subarrays that are interesting.
 * <p>
 * A subarray nums[l..r] is interesting if the following condition holds:
 * <p>
 * Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.
 * Return an integer denoting the count of interesting subarrays.
 * <p>
 * Note: A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>1 <= modulo <= 10^9</li>
 *  <li>0 <= k < modulo</li>
 * </ul>
 */
public interface CountOfInterestingSubarrays {

    long countInterestingSubarrays(List<Integer> nums, int modulo, int k);

    class CountOfInterestingSubarraysRev1 implements CountOfInterestingSubarrays {

        @Override
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            // prefixCount[r] - the number of indices where nums[r] % modulo == k
            var prefixCount = 0;

            // prefixCount % modulo -> count
            final var counts = new HashMap<Integer, Integer>();
            counts.put(0, 1);

            var total = 0L;
            for (var x : nums) {
                prefixCount += (x % modulo == k) ? 1 : 0;
                prefixCount %= modulo;
                // check if there exist indices l such that prefixCount[l:r] % modulo == k, i.e.
                // prefixCount[l] = (prefixCount[r] - k) % modulo = (prefixCount[r] - k + modulo) % modulo <-- + modulo to handle negative numbers
                final var complement = (prefixCount - k + modulo) % modulo;
                if (counts.containsKey(complement)) {
                    total += counts.get(complement);
                }
                counts.put(prefixCount, counts.getOrDefault(prefixCount, 0) + 1);
            }
            return total;
        }
    }
}
