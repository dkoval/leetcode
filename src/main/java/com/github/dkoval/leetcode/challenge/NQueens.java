package com.github.dkoval.leetcode.challenge;

import java.util.*;
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
public interface NQueens {

    List<List<String>> solveNQueens(int n);

    class NQueensRev1 implements NQueens {

        @Override
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            placeQueen(0, createBoard(n), new HashSet<>(), new HashSet<>(), new HashSet<>(), ans);
            return ans;
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

        private List<String> formatBoard(char[][] board) {
            List<String> res = new ArrayList<>();
            for (char[] row : board) {
                res.add(String.valueOf(row));
            }
            return res;
        }

        private void placeQueen(int row,
                                char[][] board,
                                Set<Integer> usedColumns,
                                Set<Integer> usedDiags1,
                                Set<Integer> usedDiags2,
                                List<List<String>> ans) {
            int n = board.length;

            if (row == n) {
                ans.add(formatBoard(board));
                return;
            }

            for (int col = 0; col < n; col++) {
                // check column and 2 diagonals
                // trick: use row + col = c1 and row - col = c2 equations to label diagonals
                if (!usedColumns.contains(col) && !usedDiags1.contains(row - col) && !usedDiags2.contains(row + col)) {
                    // place a queen at (row, col)
                    board[row][col] = 'Q';
                    usedColumns.add(col);
                    usedDiags1.add(row - col);
                    usedDiags2.add(row + col);

                    // go to the next row
                    placeQueen(row + 1, board, usedColumns, usedDiags1, usedDiags2, ans);

                    // backtrack
                    board[row][col] = '.';
                    usedColumns.remove(col);
                    usedDiags1.remove(row - col);
                    usedDiags2.remove(row + col);
                }
            }
        }
    }

    class NQueensRev2 implements NQueens {

        @Override
        public List<List<String>> solveNQueens(int n) {
            List<int[]> result = new ArrayList<>();
            placeQueen(0, new int[n], result);
            return result.stream().map(this::formatBoard).collect(Collectors.toList());
        }

        private void placeQueen(int row, int[] placements, List<int[]> result) {
            // placements[i] = j denotes a queen placed at i-th row and j-th column on an n x n chessboard
            int n = placements.length;
            if (row == n) {
                result.add(Arrays.copyOf(placements, n));
            }
            // generate all possible valid queen placements in the current row
            for (int col = 0; col < n; col++) {
                if (isValidPlacement(row, col, placements)) {
                    placements[row] = col; // place queen
                    placeQueen(row + 1, placements, result);
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

        private List<String> formatBoard(int[] placements) {
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
}
