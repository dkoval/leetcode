package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3711/">Number of Submatrices That Sum to Target</a>
 * <p>
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 */
public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // for each row i, calculate prefix sum, i.e. matrix[i][j] = sumOf(matrix[i][0], ..., matrix[i][j])
        int m = matrix.length, n = matrix[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int count = 0;

        // for each pair of columns, find the number of subarrays whose sum equals to target
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = col1; col2 < n; col2++) {
                Map<Integer, Integer> sumOccurrences = new HashMap<>();
                sumOccurrences.put(0, 1);

                int sum = 0;
                for (int row = 0; row < m; row++) {
                    sum += matrix[row][col2] - (col1 > 0 ? matrix[row][col1 - 1] : 0);
                    count += sumOccurrences.getOrDefault(sum - target, 0);
                    sumOccurrences.put(sum, sumOccurrences.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
