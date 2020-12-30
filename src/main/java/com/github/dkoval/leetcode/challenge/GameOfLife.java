package com.github.dkoval.leetcode.challenge;

/**
 * According to <a href="https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia's article</a>:
 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
 * or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 * <ul>
 * <li>Any live cell with fewer than two live neighbors dies as if caused by under-population.</li>
 * <li>Any live cell with two or three live neighbors lives on to the next generation.</li>
 * <li>Any live cell with more than three live neighbors dies, as if by over-population.</li>
 * <li>Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.</li>
 * </ul>
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public abstract class GameOfLife {

    public abstract void gameOfLife(int[][] board);

    public static class GameOfLifeNaive extends GameOfLife {

        @Override
        public void gameOfLife(int[][] board) {
            int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // possible directions
            int m = board.length, n = board[0].length;
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int numAdjLiveCells = 0;
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 1) {
                            numAdjLiveCells++;
                        }
                    }
                    // apply conditions
                    if (board[i][j] == 1) {
                        // cell (i, j) is alive
                        if (numAdjLiveCells == 2 || numAdjLiveCells == 3) {
                            tmp[i][j] = 1;
                        }
                    } else {
                        // cell (i, j) is dead
                        if (numAdjLiveCells == 3) {
                            tmp[i][j] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = tmp[i][j];
                }
            }
        }
    }

    // O(N) time | O(1) space
    public static class GameOfLifeInPlace extends GameOfLife {

        @Override
        public void gameOfLife(int[][] board) {
            int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // possible directions
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int numAdjLiveCells = 0;
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 1 || board[row][col] == 2)) {
                            numAdjLiveCells++;
                        }
                    }
                    // apply conditions
                    if (board[i][j] == 1) {
                        // cell (i, j) is alive
                        if (numAdjLiveCells < 2 || numAdjLiveCells > 3) {
                            // 2: alive -> dead
                            board[i][j] = 2;
                        }
                    } else {
                        // cell (i, j) is dead
                        if (numAdjLiveCells == 3) {
                            // 3: dead -> alive
                            board[i][j] = 3;
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 0 % 2 = 0 - dead
                    // 1 % 2 = 1 - alive
                    // 2 % 2 = 0 - dead
                    // 3 % 2 = 1 - alive
                    board[i][j] %= 2;
                }
            }
        }
    }
}
