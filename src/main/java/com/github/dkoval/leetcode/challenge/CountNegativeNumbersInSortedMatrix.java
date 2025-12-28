package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Count Negative Numbers in a Sorted Matrix</a>
 * <p>
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>-100 <= grid[i][j] <= 100</li>
 * </ul>
 * <p>
 * Follow up: Could you find an O(n + m) solution?
 */
public interface CountNegativeNumbersInSortedMatrix {

    int countNegatives(int[][] grid);

    // O(m * n) time | O(1) space
    class CountNegativeNumbersInSortedMatrixRev1 implements CountNegativeNumbersInSortedMatrix {

        @Override
        public int countNegatives(int[][] grid) {
            int n = grid[0].length;
            int count = 0;
            for (int[] row : grid) {
                for (int j = n - 1; j >= 0 && row[j] < 0; j--) {
                    count++;
                }
            }
            return count;
        }
    }

    // O(m + n) time | O(1) space
    class CountNegativeNumbersInSortedMatrixRev2 implements CountNegativeNumbersInSortedMatrix {

        @Override
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            int row = 0;
            int col = n - 1;
            while (row < m && col >= 0) {
                if (grid[row][col] < 0) {
                    // since the matrix is sorted in non-increasing order both row-wise and column-wise,
                    // all numbers in the same colum are also negative, hence count them all
                    count += m - row;
                    col--;
                } else {
                    // move to the next row in the search for a negative number
                    row++;
                }
            }
            return count;
        }
    }

    // O(m + n) time | O(1) space
    class CountNegativeNumbersInSortedMatrixRev3 implements CountNegativeNumbersInSortedMatrix {

        @Override
        public int countNegatives(int[][] grid) {
            // .....xxx
            // ...xxxxx
            // ...xxxxx <- same quantity of negative numbers or expands to the left
            // ..xxxxxx
            // .xxxxxxx
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            int col = n - 1;
            for (int row = 0; row < m; row++) {
                while (col >= 0 && grid[row][col] < 0) {
                    col--;
                }
                count += n - col - 1;
            }
            return count;
        }
    }
}
