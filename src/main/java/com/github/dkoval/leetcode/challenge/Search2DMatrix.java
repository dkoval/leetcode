package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 * You are given an m x n integer matrix matrix with the following two properties:
 * <ul>
 *  <li>Each row is sorted in non-decreasing order.</li>
 *  <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == matrix.length</li>
 *  <li>n == matrix[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>-104 <= matrix[i][j], target <= 10^4</li>
 * </ul>
 */
public interface Search2DMatrix {

    boolean searchMatrix(int[][] matrix, int target);

    class Search2DMatrixWithTwoBinarySearchesRev1 implements Search2DMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            // binary search the row
            int leftRow = 0;
            int rightRow = m - 1;
            while (leftRow <= rightRow) {
                int midRow = leftRow + (rightRow - leftRow) / 2;
                if (matrix[midRow][0] < target) {
                    // binary search in matrix[midRow] row
                    int leftCol = 1;
                    int rightCol = n - 1;
                    while (leftCol <= rightCol) {
                        int midCol = leftCol + (rightCol - leftCol) / 2;
                        if (matrix[midRow][midCol] < target) {
                            leftCol = midCol + 1;
                        } else if (matrix[midRow][midCol] > target) {
                            rightCol = midCol - 1;
                        } else {
                            return true;
                        }
                    }
                    // target is not in this row, keep on checking the rows below midRow
                    leftRow = midRow + 1;
                } else if (matrix[midRow][0] > target) {
                    // target is not in this row, keep on checking the rows above midRow
                    rightRow = midRow - 1;
                } else {
                    // matrix[midRow][0] == target
                    return true;
                }
            }
            return false;
        }
    }

    // O(logM + logN) time | O(1) space
    class Search2DMatrixWithTwoBinarySearchesRev2 implements Search2DMatrix {

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
    class SearchIn2DMatrixUsingBinarySearchWith2DCoordinatesRemapping implements Search2DMatrix {

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
