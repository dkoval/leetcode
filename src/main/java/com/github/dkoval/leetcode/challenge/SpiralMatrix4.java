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
}
