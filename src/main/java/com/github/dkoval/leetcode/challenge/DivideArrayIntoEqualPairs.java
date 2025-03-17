package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/divide-array-into-equal-pairs/">Divide Array Into Equal Pairs</a>
 * <p>
 * You are given an integer array nums consisting of 2 * n integers.
 * <p>
 * You need to divide nums into n pairs such that:
 * <ul>
 *  <li>Each element belongs to exactly one pair.</li>
 *  <li>The elements present in a pair are equal.</li>
 * </ul>
 * Return true if nums can be divided into n pairs, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>nums.length == 2 * n</li>
 *  <li>1 <= n <= 500</li>
 *  <li>1 <= nums[i] <= 500</li>
 * </ul>
 */
public interface DivideArrayIntoEqualPairs {

    boolean divideArray(int[] nums);

    class DivideArrayIntoEqualPairsRev1 implements DivideArrayIntoEqualPairs {

        @Override
        public boolean divideArray(int[] nums) {
            final var counts = new HashMap<Integer, Integer>();
            for (var x : nums) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            for (var count : counts.values()) {
                if (count % 2 != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
