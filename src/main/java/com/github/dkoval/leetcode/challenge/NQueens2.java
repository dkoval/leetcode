package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3760/">N-Queens II</a>
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueens2 {

    public int totalNQueens(int n) {
        return placeQueens(0, new int[n]);
    }

    private int placeQueens(int row, int[] placements) {
        // placements[i] = j denotes a queen placed at i-th row and j-th column
        int n = placements.length;
        if (row == n) {
            return 1;
        }
        // generate all possible valid queen placements in the current row
        int numSolutions = 0;
        for (int col = 0; col < n; col++) {
            if (isValidPlacement(row, col, placements)) {
                placements[row] = col;
                numSolutions += placeQueens(row + 1, placements);
            }
        }
        return numSolutions;
    }

    private boolean isValidPlacement(int row, int col, int[] placements) {
        // check all previous rows
        for (int currRow = 0; currRow < row; currRow++) {
            int currCol = placements[currRow];
            if (currCol == col) {
                // same column
                return false;
            }
            if (Math.abs(row - currRow) == Math.abs(col - currCol)) {
                // same diagonal
                return false;
            }
        }
        return true;
    }
}
