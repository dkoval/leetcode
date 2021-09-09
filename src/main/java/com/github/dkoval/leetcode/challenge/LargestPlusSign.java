package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3969/">Largest Plus Sign</a>
 * <p>
 * You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines.
 * The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
 * <p>
 * Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
 * <p>
 * An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1
 * going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign,
 * only the relevant area of the plus sign is checked for 1's.
 */
public class LargestPlusSign {

    // O(N^2) time | O(N^2) space
    // Resource: https://www.youtube.com/watch?v=QCb0hRt_gCs
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = createGrid(n, mines);

        // for each row i, leftToRight[i][j] stores the number of consecutive 1s up till leftToRight[i][j] if going from left to right
        int[][] leftToRight = new int[n][n];
        // for each row i, rightToLeft[i][j] stores the number of consecutive 1s up till rightToLeft[i][j] if going from right to left
        int[][] rightToLeft = new int[n][n];

        for (int i = 0; i < n; i++) {
            countOnesInRow(grid, n, i, leftToRight, true);
            countOnesInRow(grid, n, i, rightToLeft, false);
        }

        // for each column j, topToBottom[i][j] stores the number of consecutive 1s up till topToBottom[i][j] if going from top to bottom
        int[][] topToBottom = new int[n][n];
        // for each column j, bottomToTop[i][j] stores the number of consecutive 1s up till bottomToTop[i][j] if going from bottom to top
        int[][] bottomToTop = new int[n][n];

        for (int j = 0; j < n; j++) {
            countOnesInCol(grid, n, j, topToBottom, true);
            countOnesInCol(grid, n, j, bottomToTop, false);
        }

        // with this information in place, the answer to the problem is
        // max of min(leftToRight[i][j], rightToLeft[i][j], topToBottom[i][j], bottomToTop[i][j]) for all i and j
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currMin = Integer.MAX_VALUE;
                currMin = Math.min(currMin, leftToRight[i][j]);
                currMin = Math.min(currMin, rightToLeft[i][j]);
                currMin = Math.min(currMin, topToBottom[i][j]);
                currMin = Math.min(currMin, bottomToTop[i][j]);

                answer = Math.max(answer, currMin);
            }
        }
        return answer;
    }

    private int[][] createGrid(int n, int[][] mines) {
        int[][] grid = new int[n][n];

        // initially, fill grid with 1s
        for (int[] row : grid) {
            Arrays.fill(row, 1);
        }

        // place 0s onto the grid
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        return grid;
    }

    private void countOnesInRow(int[][] grid, int n, int row, int[][] result, boolean reversed) {
        OnesCounter counter = new OnesCounter(grid, result);
        Range.of(n, reversed).forEach(col -> counter.process(row, col));
    }

    private void countOnesInCol(int[][] grid, int n, int col, int[][] result, boolean reversed) {
        OnesCounter counter = new OnesCounter(grid, result);
        Range.of(n, reversed).forEach(row -> counter.process(row, col));
    }
}

// Represents abstract computation on a range of numbers [0:n)
class Range {
    private int x;
    private final int end;
    private final int step;

    static Range of(int n, boolean reversed) {
        return new Range(n, reversed);
    }

    private Range(int n, boolean reversed) {
        this.x = reversed ? n - 1 : 0;
        this.end = reversed ? -1 : n;
        this.step = reversed ? -1 : 1;
    }

    void forEach(Consumer<Integer> action) {
        while (x != end) {
            action.accept(x);
            x += step;
        }
    }
}

class OnesCounter {
    private int count = 0;
    private final int[][] grid;
    private final int[][] result;

    OnesCounter(int[][] grid, int[][] result) {
        this.grid = grid;
        this.result = result;
    }

    void process(int row, int col) {
        if (grid[row][col] == 0) {
            count = 0;
        } else {
            result[row][col] = ++count;
        }
    }
}
