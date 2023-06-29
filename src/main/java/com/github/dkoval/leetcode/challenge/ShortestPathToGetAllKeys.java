package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-to-get-all-keys/">Shortest Path to Get All Keys (Hard)</a>
 * <p>
 * You are given an m x n grid grid where:
 * <ul>
 *  <li>'.' is an empty cell.</li>
 *  <li>'#' is a wall.</li>
 *  <li>'@' is the starting point.</li>
 *  <li>Lowercase letters represent keys.</li>
 *  <li>Uppercase letters represent locks.</li>
 * </ul>
 * You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
 * <p>
 * If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
 * <p>
 * For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * <p>
 * Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 30</li>
 *  <li>grid[i][j] is either an English letter, '.', '#', or '@'.</li>
 *  <li>The number of keys in the grid is in the range [1, 6].</li>
 *  <li>Each key in the grid is unique.</li>
 *  <li>Each key in the grid has a matching lock.</li>
 * </ul>
 */
public interface ShortestPathToGetAllKeys {

    int shortestPathAllKeys(String[] grid);

    class ShortestPathToGetAllKeysRev1 implements ShortestPathToGetAllKeys {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int shortestPathAllKeys(String[] grid) {
            // Idea: BFS with revisited states
            int m = grid.length;
            int n = grid[0].length();

            Node start = null;
            int allKeys = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    char c = grid[row].charAt(col);
                    if (c == '@') {
                        start = new Node(row, col, 0);
                    } else if (c >= 'a' && c <= 'f') {
                        allKeys |= 1 << (c - 'a');
                    }
                }
            }
            return bfs(grid, start, allKeys);
        }

        private int bfs(String[] grid, Node start, int allKeys) {
            int m = grid.length;
            int n = grid[0].length();

            Queue<Node> q = new ArrayDeque<>();
            // Given 1 <= k <= 6, K = 2^6 = 64
            boolean[][][] visited = new boolean[m][n][64];

            int moves = 0;
            q.offer(start);
            visited[start.row][start.col][start.keys] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    Node curr = q.poll();
                    if (curr.keys == allKeys) {
                        return moves;
                    }

                    for (int[] d : DIRS) {
                        int nextRow = curr.row + d[0];
                        int nextCol = curr.col + d[1];

                        // check boundaries
                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                            continue;
                        }

                        char c = grid[nextRow].charAt(nextCol);

                        // hit a wall
                        if (c == '#') {
                            continue;
                        }

                        // hit a lock with no corresponding key
                        if (c >= 'A' && c <= 'F' && (curr.keys & (1 << (c - 'A'))) == 0) {
                            continue;
                        }

                        int nextKeys = curr.keys;

                        // hit a key, collect it
                        if (c >= 'a' && c <= 'f') {
                            nextKeys |= 1 << (c - 'a');
                        }

                        if (!visited[nextRow][nextCol][nextKeys]) {
                            q.offer(new Node(nextRow, nextCol, nextKeys));
                            visited[nextRow][nextCol][nextKeys] = true;
                        }
                    }
                }
                moves++;
            }
            return -1;
        }

        private static class Node {
            final int row;
            final int col;
            // a bit mask representing collected keys (1 <= k <= 6):
            // 0-th bit -> 'a'
            // 1-st bit -> 'b'
            // ...
            // 5-th bit -> 'f'
            final int keys;

            Node(int row, int col, int keys) {
                this.row = row;
                this.col = col;
                this.keys = keys;
            }
        }
    }
}
