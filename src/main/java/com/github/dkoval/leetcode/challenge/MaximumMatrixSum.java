package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-matrix-sum/">Maximum Matrix Sum</a>
 * <p>
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 * <p>
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 * <p>
 * Your goal is to maximize the summation of the matrix's elements.
 * Return the maximum sum of the matrix's elements using the operation mentioned above.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == matrix.length == matrix[i].length</li>
 *  <li>2 <= n <= 250</li>
 *  <li>-105 <= matrix[i][j] <= 10^5</li>
 * </ul>
 */
public interface MaximumMatrixSum {

    long maxMatrixSum(int[][] matrix);

    class MaximumMatrixSumRev1 implements MaximumMatrixSum {

        @Override
        public long maxMatrixSum(int[][] matrix) {
            // Observation #1. It is always possible to make any 2 negative numbers positive,
            // regardless of their positions in the matrix (think of the Snake game as an analogy)!
            // That is, 2 negative numbers at positions (r1, c1) and (r2, c2) can always be made adjacent:
            // by applying the described operation, we can always build a path from (r1, c1) to (r2, c2).
            // ---
            // Observation #2. If the number of negative numbers in the matrix is uneven, to maximize the
            // sum, we want to make the smallest abs(matrix[i][j]) negative.
            var sum = 0L;
            var smallest = Integer.MAX_VALUE;
            var negCount = 0;
            for (var row : matrix) {
                for (var x : row) {
                    if (x < 0) {
                        negCount++;
                    }
                    final var value = Math.abs(x);
                    sum += value;
                    smallest = Math.min(smallest, value);
                }
            }
            return (negCount % 2 == 0) ? sum : sum - smallest - smallest;
        }
    }

    // O(M * N * log(M * N) time | O(M * N) space
    class MaximumMatrixSumRev2 implements MaximumMatrixSum {

        @Override
        public long maxMatrixSum(int[][] matrix) {
            final var m = matrix.length;
            final var n = matrix[0].length;

            final var nums = new int[m * n];
            for (var i = 0; i < nums.length; i++) {
                final var row = i / n;
                final var col = i % n;
                nums[i] = matrix[row][col];
            }

            Arrays.sort(nums);

            for (var i = 0; i < nums.length; i += 2) {
                if (i + 1 < nums.length && -nums[i] + -nums[i + 1] > nums[i] + nums[i + 1]) {
                    nums[i] = -nums[i];
                    nums[i + 1] = -nums[i + 1];
                }
            }

            var sum = 0L;
            for (var x : nums) {
                sum += x;
            }
            return sum;
        }
    }
}
