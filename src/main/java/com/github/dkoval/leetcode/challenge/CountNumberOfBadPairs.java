package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/count-number-of-bad-pairs/">Count Number of Bad Pairs</a>
 * <p>
 * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
 * <p>
 * Return the total number of bad pairs in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface CountNumberOfBadPairs {

    long countBadPairs(int[] nums);

    class CountNumberOfBadPairsRev1 implements CountNumberOfBadPairs {

        @Override
        public long countBadPairs(int[] nums) {
            final var n = nums.length;

            // j - i != nums[j] - nums[i], j > i
            // nums[i] - i != nums[j] - j

            // The number of possible pairs:
            // C(n, 2) = n * (n - 1) / 2
            final var totalPairs = ((long) n) * (n - 1) / 2;

            var goodPairs = 0L;
            // nums[i] - i -> count
            final var counts = new HashMap<Integer, Integer>();
            for (var i = 0; i < n; i++) {
                final var diff = nums[i] - i;

                // the number of new pairs that can be formed with this `diff`
                var count = counts.getOrDefault(diff, 0);
                goodPairs += count;

                counts.put(diff, count + 1);
            }

            return totalPairs - goodPairs;
        }
    }
}
