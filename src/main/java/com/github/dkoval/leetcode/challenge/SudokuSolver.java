package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver (Hard)</a>
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all the following rules:
 * <ul>
 *  <li>Each of the digits 1-9 must occur exactly once in each row.</li>
 *  <li>Each of the digits 1-9 must occur exactly once in each column.</li>
 *  <li>Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.</li>
 * </ul>
 * The '.' character indicates empty cells.
 * <p>
 * Constraints:
 * <ul>
 *  <li>board.length == 9</li>
 *  <li>board[i].length == 9</li>
 *  <li>board[i][j] is a digit or '.'.</li>
 *  <li>It is guaranteed that the input board has only one solution.</li>
 * </ul>
 */
public interface SudokuSolver {

    void solveSudoku(char[][] board);

    class SudokuSolverRev1 implements SudokuSolver {

        @Override
        public void solveSudoku(char[][] board) {
            final var available = new ArrayList<Cell>();

            // rows[i][x] - if the number x is present in the i-th row
            final var rows = new boolean[9][9];
            // cols[j][x] - if the number x is present in the j-th column
            final var cols = new boolean[9][9];
            // squares[i][x] - if the number x is present in the i-th 3x3 square (there are 9 such squares)
            final var squares = new boolean[9][9];

            // collect cells to fill
            for (var row = 0; row < 9; row++) {
                for (var col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        available.add(new Cell(row, col));
                    } else {
                        final var x = board[row][col] - '0' - 1;
                        rows[row][x] = true;
                        cols[col][x] = true;

                        final var bigRow = row / 3;
                        final var bigCol = col / 3;

                        // enumerate 2D (bigRow, bigCol) such that the information can be stored in a 1D array
                        final var square = bigRow * 3 + bigCol;
                        squares[square][x] = true;
                    }
                }
            }

            solve(board, available, 0, rows, cols, squares);
        }

        private boolean solve(char[][] board, List<Cell> available, int index, boolean[][] rows, boolean[][] cols, boolean[][] squares) {
            if (index == available.size()) {
                return true;
            }

            final var curr = available.get(index);

            final var bigRow = curr.row / 3;
            final var bigCol = curr.col / 3;
            final var square = bigRow * 3 + bigCol;

            // brute force + backtracking
            for (var x = 0; x < 9; x++) {
                if (rows[curr.row][x] || cols[curr.col][x] || squares[square][x]) {
                    // x is already taken
                    continue;
                }

                // put (x + 1) on the board
                board[curr.row][curr.col] = (char) ('0' + x + 1);
                rows[curr.row][x] = cols[curr.col][x] = squares[square][x] = true;

                if (solve(board, available, index + 1, rows, cols, squares)) {
                    return true;
                }

                // backtrack
                board[curr.row][curr.col] = '.';
                rows[curr.row][x] = cols[curr.col][x] = squares[square][x] = false;
            }
            return false;
        }

        record Cell(int row, int col) {
        }
    }
}
