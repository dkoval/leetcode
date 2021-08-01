package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/">Making A Large Island (Hard)</a>
 * <p>
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * <p>
 * Return the size of the largest island in grid after applying this operation.
 * <p>
 * An island is a 4-directionally connected group of 1s
 */
public class MakingLargeIsland {

    private static final int STARTING_LABEL = 1;
    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1,0}};

    // O(N^2) time | O(N^2) space
    // Resource: https://www.youtube.com/watch?v=ggEq5JrnmH0
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int[][] labels = new int[n][n];
        // stores label -> area mapping for an island
        Map<Integer, Integer> areas = new HashMap<>();
        // label = 0 denotes cells that do not belong to any island, therefore area is set to 0
        areas.put(0, 0);

        int currLabel = STARTING_LABEL;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col, labels, currLabel);
                    areas.put(currLabel++, area);
                }
            }
        }

        int maxArea = areas.getOrDefault(STARTING_LABEL, 0);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    // `used` set avoids adding islands with the same label
                    Set<Integer> used = new HashSet<>();
                    for (int[] d : DIRECTIONS) {
                        int nextRow = row + d[0];
                        int nextCol = col + d[1];
                        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                            used.add(labels[nextRow][nextCol]);
                        }
                    }

                    int area = 1;
                    for (int label : used) {
                        area += areas.get(label);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    // Assigns a label to an island starting at grid[row][col] and its returns area
    private int dfs(int[][] grid, int row, int col, int[][] labels, int label) {
        int n = grid.length;

        // consider unlabeled 1s only
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || labels[row][col] != 0) {
            return 0;
        }

        // assign a label
        labels[row][col] = label;

        // compute the area by exploring a 4-connected 1s
        int area = 1;
        for (int[] d : DIRECTIONS) {
            area += dfs(grid, row + d[0], col + d[1], labels, label);
        }
        return area;
    }
}
