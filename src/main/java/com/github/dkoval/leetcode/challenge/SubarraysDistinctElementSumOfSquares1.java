package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/">Subarrays Distinct Element Sum of Squares I</a>
 * <p>
 * You are given a 0-indexed integer array nums.
 * <p>
 * The distinct count of a subarray of nums is defined as:
 * <p>
 * Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length.
 * Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
 * <p>
 * Return the sum of the squares of distinct counts of all subarrays of nums.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface SubarraysDistinctElementSumOfSquares1 {

    int sumCounts(List<Integer> nums);

    class SubarraysDistinctElementSumOfSquares1Rev1 implements SubarraysDistinctElementSumOfSquares1 {

        @Override
        public int sumCounts(List<Integer> nums) {
            final var n = nums.size();

            var total = 0;
            for (var len = 1; len <= n; len++) {
                for (var start = 0; start <= n - len; start++) {
                    final var distinct = new HashSet<Integer>();
                    for (var i = start; i < start + len; i++) {
                        distinct.add(nums.get(i));
                    }
                    total += distinct.size() * distinct.size();
                }
            }
            return total;
        }
    }

    class SubarraysDistinctElementSumOfSquares1Rev2 implements SubarraysDistinctElementSumOfSquares1 {

        @Override
        public int sumCounts(List<Integer> nums) {
            final var n = nums.size();

            var total = 0;
            for (var i = 0; i < n; i++) {
                final var distinct = new HashSet<Integer>();
                for (var j = i; j < n; j++) {
                    distinct.add(nums.get(j));
                    total += distinct.size() * distinct.size();
                }
            }
            return total;
        }
    }

    class SubarraysDistinctElementSumOfSquares1Rev3 implements SubarraysDistinctElementSumOfSquares1 {

        @Override
        public int sumCounts(List<Integer> nums) {
            final var n = nums.size();

            var total = 0;
            for (var i = 0; i < n; i++) {
                // constraint: 1 <= nums[i] <= 100
                final var distinct = new boolean[101];
                for (var j = i; j < n; j++) {
                    distinct[nums.get(j)] = true;
                    var count = 0;
                    for (var k = 1; k <= 100; k++) {
                        if (distinct[k]) {
                            count++;
                        }
                    }
                    total += count * count;
                }
            }
            return total;
        }
    }

    class SubarraysDistinctElementSumOfSquares1Rev4 implements SubarraysDistinctElementSumOfSquares1 {

        @Override
        public int sumCounts(List<Integer> nums) {
            final var n = nums.size();

            var total = 0;
            for (var i = 0; i < n; i++) {
                // 1 <= nums[i] <= 100
                final var distinct = new boolean[101];
                var count = 0;
                for (var j = i; j < n; j++) {
                    final var ok = addIfDistinct(distinct, nums.get(j));
                    if (ok) {
                        count++;
                    }
                    total += count * count;
                }
            }
            return total;
        }

        private boolean addIfDistinct(boolean[] distinct, int x) {
            if (!distinct[x]) {
                return distinct[x] = true;
            }
            return false;
        }
    }
}
