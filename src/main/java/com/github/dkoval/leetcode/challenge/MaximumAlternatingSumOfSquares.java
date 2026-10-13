package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-alternating-sum-of-squares/">Maximum Alternating Sum of Squares</a>
 * <p>
 * You are given an integer array nums. You may rearrange the elements in any order.
 * <p>
 * The alternating score of an array arr is defined as:
 * <p>
 * score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
 * <p>
 * Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-4 * 10^4 <= nums[i] <= 4 * 10^4</li>
 * </ul>
 */
public interface MaximumAlternatingSumOfSquares {

    long maxAlternatingSum(int[] nums);

    class MaximumAlternatingSumOfSquaresRev1 implements MaximumAlternatingSumOfSquares {

        @Override
        public long maxAlternatingSum(int[] nums) {
            final var n = nums.length;

            final var xs = new int[n];
            for (var i = 0; i < n; i++) {
                xs[i] = nums[i] * nums[i];
            }

            Arrays.sort(xs);

            var res = 0L;
            var left = 0;
            var right = n - 1;
            var even = true;
            while (left <= right) {
                res += even ? xs[right--] : -xs[left++];
                even = !even;
            }
            return res;
        }
    }

    class MaximumAlternatingSumOfSquaresRev2 implements MaximumAlternatingSumOfSquares {

        @Override
        public long maxAlternatingSum(int[] nums) {
            final var n = nums.length;

            final var xs = new int[n];
            for (var i = 0; i < n; i++) {
                xs[i] = nums[i] * nums[i];
            }

            Arrays.sort(xs);

            var res = 0L;
            for (var i = n / 2; i < n; i++) {
                res += xs[i];
            }

            for (var i = 0; i < n / 2; i++) {
                res -= xs[i];
            }
            return res;
        }
    }
}
