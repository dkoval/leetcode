package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/zero-array-transformation-i/">Zero Array Transformation I</a>
 * <p>
 * You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
 * <p>
 * For each queries[i]:
 * <ul>
 *  <li>Select a subset of indices within the range [li, ri] in nums.</li>
 *  <li>Decrement the values at the selected indices by 1.</li>
 * </ul>
 * A Zero Array is an array where all elements are equal to 0.
 * <p>
 * Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 *  <li>1 <= queries.length <= 10^5</li>
 *  <li>queries[i].length == 2</li>
 *  <li>0 <= li <= ri < nums.length</li>
 * </ul>
 */
public interface ZeroArrayTransformation1 {

    boolean isZeroArray(int[] nums, int[][] queries);

    class ZeroArrayTransformation1Rev1 implements ZeroArrayTransformation1 {

        @Override
        public boolean isZeroArray(int[] nums, int[][] queries) {
            final var n = nums.length;

            final var diffs = new int[n + 1];
            for (var query : queries) {
                final var l = query[0];
                final var r = query[1];
                diffs[l] -= 1;
                diffs[r + 1] += 1;
            }

            var prefixSum = 0;
            for (var i = 0; i < n; i++) {
                prefixSum += diffs[i];
                if (Math.max(nums[i] + prefixSum, 0) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    class ZeroArrayTransformation1Rev2 implements ZeroArrayTransformation1 {

        @Override
        public boolean isZeroArray(int[] nums, int[][] queries) {
            final var n = nums.length;

            final var diffs = new int[n + 1];
            for (var query : queries) {
                final var l = query[0];
                final var r = query[1];
                diffs[l] += 1;
                diffs[r + 1] -= 1;
            }

            if (nums[0] > diffs[0]) {
                return false;
            }

            for (var i = 1; i < n; i++) {
                diffs[i] += diffs[i - 1];
                if (nums[i] > diffs[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
