package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/">Flip Columns For Maximum Number of Equal Rows</a>
 * <p>
 * You are given an m x n binary matrix matrix.
 * <p>
 * You can choose any number of columns in the matrix and flip every cell in that column
 * (i.e., Change the value of the cell from 0 to 1 or vice versa).
 * <p>
 * Return the maximum number of rows that have all values equal after some number of flips.
 * <p>
 * Constraints:
 * <ul>
 *  <li>>m == matrix.length</li>
 *  <li>>n == matrix[i].length</li>
 *  <li>>1 <= m, n <= 300</li>
 *  <li>>matrix[i][j] is either 0 or 1.</li>
 * </ul>
 */
public interface FlipColumnsForMaximumNumberOfEqualRows {

    int maxEqualRowsAfterFlips(int[][] matrix);

    // Idea: https://youtu.be/MsdLjL87BEo?si=_FetHKpJFtvMJG25
    class FlipColumnsForMaximumNumberOfEqualRowsRev1 implements FlipColumnsForMaximumNumberOfEqualRows {

        @Override
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // Observation:
            // 0 0 1
            // 1 1 0 - flipped (i.e. XOR-ed) version of the previous row!
            //         Therefore, both rows can be mapped to the same key of some kind.
            //     ^ by flipping values in the last column, we get:
            // -----
            // 0 0 0
            // 1 1 1

            int best = 0;
            Map<String, Integer> counts = new HashMap<>();
            for (int[] row : matrix) {
                StringBuilder sb = new StringBuilder();
                for (int x : row) {
                    // flip the values in a row starting with 1
                    sb.append((row[0] == 0) ? x : (x + 1) % 2);
                }

                String key = sb.toString();
                int count = counts.getOrDefault(key, 0) + 1;
                best = Math.max(best, count);
                counts.put(key, count);
            }
            return best;
        }
    }
}
