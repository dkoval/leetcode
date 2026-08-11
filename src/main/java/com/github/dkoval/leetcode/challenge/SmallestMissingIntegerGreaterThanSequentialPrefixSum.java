package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/">Smallest Missing Integer Greater Than Sequential Prefix Sum</a>
 * <p>
 * You are given a 0-indexed array of integers nums.
 * <p>
 * A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.
 * <p>
 * Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 50</li>
 *  <li>1 <= nums[i] <= 50</li>
 * </ul>
 */
public interface SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    int missingInteger(int[] nums);

    class SmallestMissingIntegerGreaterThanSequentialPrefixSumRev1 implements SmallestMissingIntegerGreaterThanSequentialPrefixSum {

        @Override
        public int missingInteger(int[] nums) {
            final var n = nums.length;

            var prefix = nums[0];
            for (var i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    break;
                }
                prefix += nums[i];
            }

            final var uniq = setOf(nums);
            var res = prefix;
            while (uniq.contains(res)) {
                res++;
            }
            return res;
        }

        private Set<Integer> setOf(int[] nums) {
            final var res = new HashSet<Integer>();
            for (var x : nums) {
                res.add(x);
            }
            return res;
        }
    }
}
