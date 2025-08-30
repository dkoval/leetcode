package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <ul>
 *  <li>Each row must contain the digits 1-9 without repetition.</li>
 *  <li>Each column must contain the digits 1-9 without repetition.</li>
 *  <li>Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.</li>
 * </ul>
 * <p>
 * Note:
 * <ul>
 *  <li>A Sudoku board (partially filled) could be valid but is not necessarily solvable.</li>
 *  <li>Only the filled cells need to be validated according to the mentioned rules.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>board.length == 9</li>
 *  <li>board[i].length == 9</li>
 *  <li>board[i][j] is a digit 1-9 or '.'.</li>
 * </ul>
 */
public interface ValidSudoku {

    boolean isValidSudoku(char[][] board);

    class ValidSudokuRev1 implements ValidSudoku {

        private static final int N = 9;
        private static final int M = 3;

        // O(N^2) time | O(1) space
        @Override
        public boolean isValidSudoku(char[][] board) {
            // check 9 rows, 9 columns and 9 squares 3x3
            for (int i = 0; i < N; i++) {
                boolean validRow = isValid(board, i, 0, i, N - 1);
                boolean validCol = isValid(board, 0, i, N - 1, i);

                int fatRow = i / M;
                int fatCol = i % M;
                boolean validSquare = isValid(board, fatRow * M, fatCol * M, fatRow * M + M - 1, fatCol * M + M - 1);

                if (!validRow || !validCol || !validSquare) {
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int startRow, int startCol, int endRow, int endCol) {
            Set<Character> seen = new HashSet<>();
            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    char c = board[row][col];
                    if (c == '.') {
                        continue;
                    }
                    if (seen.contains(c)) {
                        return false;
                    }
                    seen.add(c);
                }
            }
            return true;
        }
    }

    class ValidSudokuRev2 implements ValidSudoku {

        @Override
        public boolean isValidSudoku(char[][] board) {
            // validate each row
            for (var row = 0; row < 9; row++) {
                if (!isValid(board, row, 0, row, 8)) {
                    return false;
                }
            }

            // validate each col
            for (var col = 0; col < 9; col++) {
                if (!isValid(board, 0, col, 8, col)) {
                    return false;
                }
            }

            // validate each of 3x3 boxes
            for (var bigRow = 0; bigRow < 3; bigRow++) {
                for (var bigCol = 0; bigCol < 3; bigCol++) {
                    if (!isValid(board, bigRow * 3, bigCol * 3, bigRow * 3 + 2, bigCol * 3 + 2)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int startRow, int startCol, int endRow, int endCol) {
            final var seen = new boolean[9];
            for (var row = startRow; row <= endRow; row++) {
                for (var col = startCol; col <= endCol; col++) {
                    if (board[row][col] == '.') {
                        continue;
                    }

                    final var x = board[row][col] - '0';
                    if (seen[x - 1]) {
                        return false;
                    }
                    seen[x - 1] = true;
                }
            }
            return true;
        }
    }
}
