package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3801/">Max Sum of Rectangle No Larger Than K</a>
 * <p>
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * <p>
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>-100 <= matrix[i][j] <= 100</li>
 *  <li>-10^5 <= k <= 10^5</li>
 * </ul>
 */
public interface MaxSumOfRectangleNoLargerThanK {

    int maxSumSubmatrix(int[][] matrix, int k);

    // O(M^2 * N^2) time | O(M * N) space
    class MaxSumOfRectangleNoLargerThanKBruteForceWithPrefixSum implements MaxSumOfRectangleNoLargerThanK {

        @Override
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;

            // prefixSum[i][j] denotes the sum of a rectangle with
            // (0, 0) top-left and (i, j) bottom-right corners
            int[][] prefixSum = new int[m][n];

            // compute prefix sum for each row
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefixSum[i][j] = (j > 0 ? prefixSum[i][j - 1] : 0) + matrix[i][j];
                }
            }

            // compute prefix sum for each column
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
            }

            int maxSum = Integer.MIN_VALUE;
            for (int i1 = 0; i1 < m; i1++) {
                for (int i2 = i1; i2 < m; i2++) {
                    for (int j1 = 0; j1 < n; j1++) {
                        for (int j2 = j1; j2 < n; j2++) {
                            int currSum = prefixSum[i2][j2]
                                    - (i1 > 0 ? prefixSum[i1 - 1][j2] : 0)
                                    - (j1 > 0 ? prefixSum[i2][j1 - 1] : 0)
                                    + (i1 > 0 && j1 > 0 ? prefixSum[i1 - 1][j1 - 1] : 0);

                            if (currSum <= k) {
                                maxSum = Math.max(maxSum, currSum);
                            }
                        }
                    }
                }
            }
            return maxSum;
        }
    }
}
