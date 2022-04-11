package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/shift-2d-grid/">Shift 2D Grid</a>
 * <p>
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 * <p>
 * In one shift operation:
 * <ul>
 *  <li>Element at grid[i][j] moves to grid[i][j + 1].</li>
 *  <li>Element at grid[i][n - 1] moves to grid[i + 1][0].</li>
 *  <li>Element at grid[m - 1][n - 1] moves to grid[0][0].</li>
 * </ul>
 * Return the 2D grid after applying shift operation k times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m <= 50</li>
 *  <li>1 <= n <= 50</li>
 *  <li>-1000 <= grid[i][j] <= 1000</li>
 *  <li>0 <= k <= 100</li>
 * </ul>
 */
public interface Shift2DGrid {

    List<List<Integer>> shiftGrid(int[][] grid, int k);

    class Shift2DGridRev1 implements Shift2DGrid {

        @Override
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            k %= m * n;
            List<List<Integer>> board = convert(grid);
            while (k-- > 0) {
                shift(board);
            }
            return board;
        }

        private List<List<Integer>> convert(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            List<List<Integer>> ans = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    row.add(grid[i][j]);
                }
                ans.add(row);
            }
            return ans;
        }

        private void shift(List<List<Integer>> grid) {
            int m = grid.size();
            int n = grid.get(0).size();
            int bottomRight = grid.get(m - 1).get(n - 1);
            for (int i = m - 1; i >= 0; i--) {
                // shift elements in the current row by 1 step to the right
                List<Integer> row = grid.get(i);
                for (int j = n - 1; j >= 1; j--) {
                    row.set(j, row.get(j - 1));
                }
                // set grid[i][0] to grid[i - 1][n - 1];
                int first = (i > 0) ? grid.get(i - 1).get(n - 1) : bottomRight;
                row.set(0, first);
            }
        }
    }

    class Shift2DGridRev2 implements Shift2DGrid {

        @Override
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            k %= m * n;
            while (k-- > 0) {
                shift(grid);
            }
            return convert(grid);
        }

        private List<List<Integer>> convert(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            List<List<Integer>> ans = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    row.add(grid[i][j]);
                }
                ans.add(row);
            }
            return ans;
        }

        private void shift(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int bottomRight = grid[m - 1][n - 1];
            for (int i = m - 1; i >= 0; i--) {
                // shift elements in the current row by 1 step to the right
                for (int j = n - 1; j >= 1; j--) {
                    grid[i][j] = grid[i][j - 1];
                }
                // set grid[i][0] to grid[i - 1][n - 1];
                grid[i][0] = (i > 0) ? grid[i - 1][n - 1] : bottomRight;
            }
        }
    }

    class Shift2DGridRev3 implements Shift2DGrid {

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        @Override
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            // allocate the result list
            List<List<Integer>> board = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    row.add(1001); // any number
                }
                board.add(row);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // shift
                    int idx = (i * n + j + k) % (m * n);
                    int row = idx / n;
                    int col = idx % n;
                    board.get(row).set(col, grid[i][j]);
                }
            }
            return board;
        }
    }
}
