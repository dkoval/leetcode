package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3752/">N-Queens</a>
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space, respectively.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<int[]> result = new ArrayList<>();
        placeQueenAtRow(0, new int[n], result);
        return result.stream().map(this::board).collect(Collectors.toList());
    }

    private void placeQueenAtRow(int row, int[] placements, List<int[]> result) {
        // placements[i] = j denotes a queen placed at i-th row and j-th column on an n x n chessboard
        int n = placements.length;
        if (row == n) {
            result.add(Arrays.copyOf(placements, n));
        }
        // generate all possible valid queen placements in the current row
        for (int col = 0; col < n; col++) {
            if (isValidPlacement(row, col, placements)) {
                placements[row] = col; // place queen
                placeQueenAtRow(row + 1, placements, result);
            }
        }
    }

    private boolean isValidPlacement(int row, int col, int[] placements) {
        // check previous rows
        for (int currRow = 0; currRow < row; currRow++) {
            int currCol = placements[currRow];
            if (col == currCol) {
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

    private List<String> board(int[] placements) {
        int n = placements.length;
        List<String> result = new ArrayList<>();
        for (int col : placements) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                char c = (col == j) ? 'Q' : '.';
                row.append(c);
            }
            result.add(row.toString());
        }
        return result;
    }
}
