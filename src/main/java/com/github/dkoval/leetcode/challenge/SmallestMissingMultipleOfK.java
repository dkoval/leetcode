package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/smallest-missing-multiple-of-k/">Smallest Missing Multiple of K</a>
 * <p>
 * Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.
 * <p>
 * A multiple of k is any positive integer divisible by k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 *  <li>1 <= k <= 100</li>
 * </ul>
 */
public interface SmallestMissingMultipleOfK {

    int missingMultiple(int[] nums, int k);

    class SmallestMissingMultipleOfKRev1 implements SmallestMissingMultipleOfK {

        @Override
        public int missingMultiple(int[] nums, int k) {
            var uniq = new HashSet<Integer>();
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                uniq.add(x);
                max = Math.max(max, x);
            }

            var missing = k;
            while (missing <= max) {
                if (!uniq.contains(missing)) {
                    return missing;
                }
                missing += k;
            }
            return missing;
        }
    }

    class SmallestMissingMultipleOfKRev2 implements SmallestMissingMultipleOfK {

        @Override
        public int missingMultiple(int[] nums, int k) {
            // 1 <= nums[i] <= 100
            var uniq = new boolean[101];
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                uniq[x] = true;
                max = Math.max(max, x);
            }

            var missing = k;
            while (missing <= max) {
                if (!uniq[missing]) {
                    return missing;
                }
                missing += k;
            }
            return missing;
        }
    }
}
