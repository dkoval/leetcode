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
public class SearchIn2DMatrix {

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
