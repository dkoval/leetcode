package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/">Search a 2D Matrix II</a>
 * <p>
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 * <p>
 * The matrix has the following properties:
 * <ul>
 *  <li>Integers in each row are sorted in ascending from left to right.</li>
 *  <li>Integers in each column are sorted in ascending from top to bottom.</li>
 * </ul>
 */
public abstract class Search2DMatrix2 {

    public abstract boolean searchMatrix(int[][] matrix, int target);

    // O(M * logN) time | O(1) space
    public static class Search2DMatrix2UsingBinarySearchWhenSearchingRows extends Search2DMatrix2 {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (containsInRow(matrix, i, target)) {
                    return true;
                }
            }
            return false;
        }

        private boolean containsInRow(int[][] matrix, int row, int target) {
            int lo = 0, hi = matrix[0].length - 1;
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

    // O(M + N) time | O(1) time
    // Resource: https://www.youtube.com/watch?v=dcTJRw1704w
    public static class Search2DMatrix2Optimal extends Search2DMatrix2 {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            // start with the pivot being the up-right corner
            // if target > pivot, then row++
            // if target < pivot, then col--
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (target > matrix[row][col]) {
                    row++;
                } else if (target < matrix[row][col]) {
                    col--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
