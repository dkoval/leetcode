package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/word-search">Word Search</a>
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == board.length</li>
 *  <li>n = board[i].length</li>
 *  <li>1 <= m, n <= 6</li>
 *  <li>1 <= word.length <= 15</li>
 *  <li>board and word consists of only lowercase and uppercase English letters</li>
 * </ul>
 */
public interface WordSearch {

    boolean exist(char[][] board, String word);

    class WordSearchRev2 implements WordSearch {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            boolean[][] visited = new boolean[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (dfs(board, row, col, visited, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int row, int col, boolean[][] visited, String word, int index) {
            if (board[row][col] != word.charAt(index)) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            int m = board.length;
            int n = board[0].length;

            visited[row][col] = true;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                    if (dfs(board, nextRow, nextCol, visited, word, index + 1)) {
                        return true;
                    }
                }
            }

            // backtrack
            visited[row][col] = false;
            return false;
        }
    }
}
