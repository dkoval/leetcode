package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-iv/">Spiral Matrix IV</a>
 * <p>
 * You are given two integers m and n, which represent the dimensions of a matrix.
 * <p>
 * You are also given the head of a linked list of integers.
 * <p>
 * Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
 * starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.
 * <p>
 * Return the generated matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m, n <= 10^5</li>
 *  <li>1 <= m * n <= 10^5</li>
 *  <li>The number of nodes in the list is in the range [1, m * n].</li>
 *  <li>0 <= Node.val <= 1000</li>
 * </ul>
 */
public interface SpiralMatrix4 {

    int[][] spiralMatrix(int m, int n, ListNode head);

    class SpiralMatrix4Rev1 implements SpiralMatrix4 {

        @Override
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] ans = new int[m][n];
            for (int[] row : ans) {
                Arrays.fill(row, -1);
            }

            ListNode curr = head;
            int startRow = 0, endRow = m - 1;
            int startCol = 0, endCol = n - 1;
            while (curr != null) {
                // go left to right
                for (int j = startCol; j <= endCol && curr != null; j++) {
                    ans[startRow][j] = curr.val;
                    curr = curr.next;
                }
                startRow++;

                // go top to bottom
                for (int i = startRow; i <= endRow && curr != null; i++) {
                    ans[i][endCol] = curr.val;
                    curr = curr.next;
                }
                endCol--;

                // go right to left;
                for (int j = endCol; j >= startCol && curr != null; j--) {
                    ans[endRow][j] = curr.val;
                    curr = curr.next;
                }
                endRow--;

                // go bottom to up
                for (int i = endRow; i >= startRow && curr != null; i--) {
                    ans[i][startCol] = curr.val;
                    curr = curr.next;
                }
                startCol++;
            }
            return ans;
        }
    }

    class SpiralMatrix4Rev2 implements SpiralMatrix4 {

        // right, down, left, up
        private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        @Override
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] ans = new int[m][n];
            for (int[] row : ans) {
                Arrays.fill(row, -1);
            }

            // current position in the grid
            int row = 0;
            int col = 0;
            // current index in DIRS[]
            int d = 0;

            ListNode curr = head;
            while (curr != null) {
                ans[row][col] = curr.val;

                int nextRow = row + DIRS[d][0];
                int nextCol = col + DIRS[d][1];

                // maybe change direction
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || ans[nextRow][nextCol] != -1) {
                    d = (d + 1) % DIRS.length;
                    nextRow = row + DIRS[d][0];
                    nextCol = col + DIRS[d][1];
                }

                row = nextRow;
                col = nextCol;
                curr = curr.next;
            }
            return ans;
        }
    }
}
