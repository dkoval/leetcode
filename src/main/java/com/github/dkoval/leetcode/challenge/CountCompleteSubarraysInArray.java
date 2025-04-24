package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/count-complete-subarrays-in-an-array/">Count Complete Subarrays in an Array</a>
 * <p>
 * You are given an array nums consisting of positive integers.
 * <p>
 * We call a subarray of an array complete if the following condition is satisfied:
 * <p>
 * The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
 * Return the number of complete subarrays.
 * <p>
 * A subarray is a contiguous non-empty part of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 2000</li>
 * </ul>
 */
public interface CountCompleteSubarraysInArray {

    int countCompleteSubarrays(int[] nums);

    class CountCompleteSubarraysInArrayRev1 implements CountCompleteSubarraysInArray {

        @Override
        public int countCompleteSubarrays(int[] nums) {
            final var n = nums.length;

            final var distinct = new HashSet<Integer>();
            for (var x : nums) {
                distinct.add(x);
            }

            var count = 0;
            for (var start = 0; start <= n - distinct.size(); start++) {
                final var seen = new HashSet<Integer>();
                for (var end = start; end < n; end++) {
                    seen.add(nums[end]);
                    if (seen.size() == distinct.size()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
