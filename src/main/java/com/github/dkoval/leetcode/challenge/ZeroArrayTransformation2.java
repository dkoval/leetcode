package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/zero-array-transformation-ii/">Zero Array Transformation II</a>
 * <p>
 * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
 * <p>
 * Each queries[i] represents the following action on nums:
 * <ul>
 *  <li>Decrement the value at each index in the range [li, ri] in nums by at most vali.</li>
 *  <li>The amount by which each value is decremented can be chosen independently for each index.</li>
 * </ul>
 * A Zero Array is an array with all its elements equal to 0.
 * <p>
 * Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence,
 * nums becomes a Zero Array. If no such k exists, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 105</li>
 *  <li>0 <= nums[i] <= 5 * 105</li>
 *  <li>1 <= queries.length <= 105</li>
 *  <li>queries[i].length == 3</li>
 *  <li>0 <= li <= ri < nums.length</li>
 *  <li>1 <= vali <= 5</li>
 * </ul>
 */
public interface ZeroArrayTransformation2 {

    int minZeroArray(int[] nums, int[][] queries);

    class ZeroArrayTransformation2Rev1 implements ZeroArrayTransformation2 {

        @Override
        public int minZeroArray(int[] nums, int[][] queries) {
            final var q = queries.length;

            // binary search to guess the value k
            // FF ... FTT...T
            //         ^ answer
            var left = 0;
            var right = q + 1;
            while (left < right) {
                var mid = left + (right - left) / 2;
                if (good(nums, queries, mid)) {
                    // right may be the answer;
                    // check if there's a better option to the left of it
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return (left <= q) ? left : -1;
        }

        // all numbers are 0's after processing k queries
        private boolean good(int[] nums, int[][] queries, int k) {
            final var n = nums.length;

            // sweep line
            final var deltas = new int[n + 1];
            for (var i = 0; i < k; i++) {
                var left = queries[i][0];
                var right = queries[i][1];
                var value = queries[i][2];
                deltas[left] += value;
                deltas[right + 1] -= value;
            }

            // x - the current number at the i-th index after k queries
            var x = 0;
            for (var i = 0; i < n; i++) {
                x += deltas[i];
                if (x < nums[i]) {
                    // it's impossible to reduce nums[i] to 0 after k queries
                    return false;
                }
            }
            return true;
        }
    }
}
