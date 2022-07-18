package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/">Number of Submatrices That Sum to Target (Hard)</a>
 * <p>
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= matrix.length <= 100</li>
 *  <li>1 <= matrix[0].length <= 100</li>
 *  <li>-1000 <= matrix[i] <= 1000</li>
 *  <li>-10^8 <= target <= 10^8</li>
 * </ul>
 */
public interface NumberOfSubmatricesThatSumToTarget {

    int numSubmatrixSumTarget(int[][] matrix, int target);

    class NumberOfSubmatricesThatSumToTargetRev1 implements NumberOfSubmatricesThatSumToTarget {

        @Override
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            // for each row i, calculate prefix sum, i.e. matrix[i][j] = sumOf(matrix[i][0], ..., matrix[i][j])
            int m = matrix.length;
            int n = matrix[0].length;
            for (int row = 0; row < m; row++) {
                for (int col = 1; col < n; col++) {
                    matrix[row][col] += matrix[row][col - 1];
                }
            }

            // for each pair of columns, find the number of subarrays whose sum equals to target
            int count = 0;
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = col1; col2 < n; col2++) {
                    // prefix sum -> count
                    Map<Integer, Integer> counts = new HashMap<>();
                    counts.put(0, 1);

                    int sum = 0;
                    for (int row = 0; row < m; row++) {
                        sum += matrix[row][col2] - (col1 > 0 ? matrix[row][col1 - 1] : 0);
                        count += counts.getOrDefault(sum - target, 0);
                        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
                    }
                }
            }
            return count;
        }
    }

    class NumberOfSubmatricesThatSumToTargetRev2 implements NumberOfSubmatricesThatSumToTarget {

        @Override
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            // vertical prefix sums
            int[][] prefixSum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefixSum[i][j] += (i > 0 ? prefixSum[i - 1][j] : 0) + matrix[i][j];
                }
            }

            // now, the problem reduces to https://leetcode.com/problems/subarray-sum-equals-k/
            int count = 0;
            // consider all submatrices between rows i1 and i2
            for (int i1 = 0; i1 < m; i1++) {
                for (int i2 = i1; i2 < m; i2++) {
                    // prefix sum -> count
                    Map<Integer, Integer> counts = new HashMap<>();
                    counts.put(0, 1); // corner case, denotes an empty prefix

                    int sum = 0; // current prefix sum in a 1D array
                    for (int j = 0; j < n; j++) {
                        sum += prefixSum[i2][j] - (i1 > 0 ? prefixSum[i1 - 1][j] : 0);
                        int diff = sum - target; // chop off prefix(es) with sum == diff
                        count += counts.getOrDefault(diff, 0);
                        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
                    }
                }
            }
            return count;
        }
    }

    class NumberOfSubmatricesThatSumToTargetRev3 implements NumberOfSubmatricesThatSumToTarget {

        @Override
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            // 2D prefix sum, i.e.
            // prefixSum[i][j] is the sum of all elements in a submatrix defined by
            // (0, 0) upper-left and (i, j) bottom-right corners
            int[][] prefixSum = new int[m][n];

            // 1st pass - compute prefix sum for each row i
            for (int i = 0; i < m; i++) {
                prefixSum[i][0] = matrix[i][0];
                for (int j = 1; j < n; j++) {
                    prefixSum[i][j] += prefixSum[i][j - 1] + matrix[i][j];
                }
            }

            // 2nd pass - combine prefix sums of (i - 1) and i-th rows
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
            }

            // now, the problem reduces to https://leetcode.com/problems/subarray-sum-equals-k/
            int count = 0;
            // consider all submatrices between rows i1 and i2
            for (int i1 = 0; i1 < m; i1++) {
                for (int i2 = i1; i2 < m; i2++) {
                    // prefix sum -> count
                    Map<Integer, Integer> counts = new HashMap<>();
                    counts.put(0, 1); // corner case, denotes an empty prefix

                    for (int j = 0; j < n; j++) {
                        int sum = prefixSum[i2][j] - (i1 > 0 ? prefixSum[i1 - 1][j] : 0);
                        int diff = sum - target; // chop off prefix(es) with sum == diff
                        count += counts.getOrDefault(diff, 0);
                        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
                    }
                }
            }
            return count;
        }
    }
}
