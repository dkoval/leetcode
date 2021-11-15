package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/">Search a 2D Matrix</a>
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <ul>
 *     <li>Integers in each row are sorted from left to right.</li>
 *     <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 */
public interface SearchIn2DMatrix {

    boolean searchMatrix(int[][] matrix, int target);

    // O(logM + logN) time | O(1) space
    class SearchIn2DMatrixWithTwoBinarySearches implements SearchIn2DMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int row = findRowToSearchIn(matrix, target);
            return searchInRow(matrix, row, target);
        }

        private int findRowToSearchIn(int[][] matrix, int target) {
            // binary search
            int m = matrix.length, n = matrix[0].length;
            int lo = 0, hi = m - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[mid][n - 1] < target) {
                    // since rows are sorted in asc order, all elements in this row are < target,
                    // therefore moving to a row below
                    lo = mid + 1;
                } else if (matrix[mid][0] > target) {
                    // since rows are sorted in asc order, all elements in this row are > target,
                    // therefore moving to a row above
                    hi = mid - 1;
                } else {
                    lo = mid;
                    break;
                }
            }
            return lo;
        }

        private boolean searchInRow(int[][] matrix, int row, int target) {
            // binary search
            int n = matrix[0].length;
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[row][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[row][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    // O(log(M*N)) = O(logM + logN) time | O(1) space
    class SearchIn2DMatrixUsingBinarySearchWith2DCoordinatesRemapping implements SearchIn2DMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            // arr = flatten(row[0], row[1], ..., row[m - 1]) is sorted in asc order, hence can be binary searched
            int l = 0;
            int r = m * n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                // convert `mid` value to 2D (row, col) coordinates
                int row = mid / n;
                int col = mid % n;

                if (matrix[row][col] < target) {
                    l = mid + 1;
                } else if (matrix[row][col] > target) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
