package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/">Find the Maximum Number of Elements in Subset</a>
 * <p>
 * You are given an array of positive integers nums.
 * <p>
 * You need to select a subset of nums which satisfies the following condition:
 * <p>
 * You can place the selected elements in a 0-indexed array such that it follows the pattern:
 * [x, x^2, x^4, ..., x^k/2, x^k, x^k/2, ..., x^4, x^2, x] (Note that k can be be any non-negative power of 2).
 * <p>
 * For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.
 * <p>
 * Return the maximum number of elements in a subset that satisfies these conditions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface FindMaximumNumberOfElementsInSubset {

    int maximumLength(int[] nums);

    class FindMaximumNumberOfElementsInSubsetRev1 implements FindMaximumNumberOfElementsInSubset {

        @Override
        public int maximumLength(int[] nums) {
            final var freq = new HashMap<Integer, Integer>();
            for (var num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            final var ones = freq.getOrDefault(1, 0);
            var best = (ones % 2 != 0) ? ones : Math.max(ones - 1, 0);

            for (var num : freq.keySet()) {
                if (num == 1) {
                    continue;
                }

                var length = 0;
                int x = num;
                while (freq.containsKey(x) && freq.get(x) >= 2) {
                    length += 2;
                    x *= x;
                }

                length += freq.containsKey(x) ? 1 : -1;
                best = Math.max(best, length);
            }
            return best;
        }
    }
}
