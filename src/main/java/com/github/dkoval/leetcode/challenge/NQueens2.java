package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/n-queens-ii/">N-Queens II</a>
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public interface NQueens2 {

    int totalNQueens(int n);

    class NQueens2Rev1 implements NQueens2 {

        @Override
        public int totalNQueens(int n) {
            return placeQueen(0, createBoard(n), new HashSet<>(), new HashSet<>(), new HashSet<>());
        }

        private char[][] createBoard(int n) {
            char[][] board = new char[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    board[row][col] = '.';
                }
            }
            return board;
        }

        private int placeQueen(int row, char[][] board, Set<Integer> usedCols, Set<Integer> usedDiags1, Set<Integer> usedDiags2) {
            int n = board.length;

            if (row == n) {
                return 1;
            }

            int count = 0;
            for (int col = 0; col < n; col++) {
                // check column and 2 diagonals
                // trick: use row + col = c1 and row - col = c2 equations to label diagonals
                if (!usedCols.contains(col) && !usedDiags1.contains(row - col) && !usedDiags2.contains(row + col)) {
                    // place a queen
                    board[row][col] = 'Q';
                    usedCols.add(col);
                    usedDiags1.add(row - col);
                    usedDiags2.add(row + col);

                    // go to the next row
                    count += placeQueen(row + 1, board, usedCols, usedDiags1, usedDiags2);

                    // backtrack
                    board[row][col] = '.';
                    usedCols.remove(col);
                    usedDiags1.remove(row - col);
                    usedDiags2.remove(row + col);
                }
            }
            return count;
        }
    }

    class NQueens2Rev2 implements NQueens2 {

        @Override
        public int totalNQueens(int n) {
            return placeQueen(0, new int[n]);
        }

        private int placeQueen(int row, int[] placements) {
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
                    numSolutions += placeQueen(row + 1, placements);
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
}
