package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sum-of-squares-of-special-elements/">Sum of Squares of Special Elements</a>
 * <p>
 * You are given a 1-indexed integer array nums of length n.
 * <p>
 * An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
 * <p>
 * Return the sum of the squares of all special elements of nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length == n <= 50</li>
 *  <li>1 <= nums[i] <= 50</li>
 * </ul>
 */
public interface SumOfSquaresOfSpecialElements {

    int sumOfSquares(int[] nums);

    class SumOfSquaresOfSpecialElementsRev1 implements SumOfSquaresOfSpecialElements {

        @Override
        public int sumOfSquares(int[] nums) {
            final var n = nums.length;

            var total = 0;
            for (var i = 0; i < n; i++) {
                if (n % (i + 1) == 0) {
                    total += nums[i] * nums[i];
                }
            }
            return total;
        }
    }
}
