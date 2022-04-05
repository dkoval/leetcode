package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3904/">Valid Sudoku</a>
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
 */
public class ValidSudoku {

    private static final int N = 9;
    private static final int M = 3;

    // O(N^2) time | O(1) space
    public boolean isValidSudoku(char[][] board) {
        // check 9 rows, 9 columns and 9 squares 3x3
        for (int i = 0; i < N; i++) {
            boolean validRow = isValid(board, i, 0, i, N - 1);
            boolean validCol = isValid(board, 0, i, N - 1, i);

            int fatRow = i / M;
            int fatCol = i % M;
            boolean validSquare = isValid(board, fatRow * M, fatCol * M, fatRow * M + M - 1 , fatCol * M + M - 1);

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
