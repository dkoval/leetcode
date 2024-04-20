package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-groups-of-farmland/">Find All Groups of Farmland</a>
 * <p>
 * You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents
 * a hectare of farmland.
 * <p>
 * To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland.
 * These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
 * <p>
 * land can be represented by a coordinate system where the top left corner of land is (0, 0) and
 * the bottom right corner of land is (m-1, n-1).
 * Find the coordinates of the top left and bottom right corner of each group of farmland.
 * A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented
 * by the 4-length array [r1, c1, r2, c2].
 * <p>
 * Return a 2D array containing the 4-length arrays described above for each group of farmland in land.
 * If there are no groups of farmland, return an empty array. You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <lli>m == land.length</li>
 *  <lli>n == land[i].length</li>
 *  <lli>1 <= m, n <= 300</li>
 *  <lli>land consists of only 0's and 1's.</li>
 *  <lli>Groups of farmland are rectangular in shape.</li>
 * </ul>
 */
public interface FindAllGroupsOfFarmland {

    // up, down, left, right
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int[][] findFarmland(int[][] land);

    class FindAllGroupsOfFarmlandDFS implements FindAllGroupsOfFarmland {

        @Override
        public int[][] findFarmland(int[][] land) {
            int m = land.length;
            int n = land[0].length;

            List<int[]> ans = new ArrayList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (land[row][col] == 1) {
                        traverse(land, row, col, ans);
                    }
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }

        private void traverse(int[][] land, int row, int col, List<int[]> ans) {
            int[] coords = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
            dfs(land, row, col, coords);
            ans.add(coords);
        }

        private void dfs(int[][] land, int row, int col, int[] coords) {
            int m = land.length;
            int n = land[0].length;

            // mark as visited
            land[row][col] = 2;

            // top-left corner
            coords[0] = Math.min(coords[0], row);
            coords[1] = Math.min(coords[1], col);

            // bottom-right corner
            coords[2] = Math.max(coords[2], row);
            coords[3] = Math.max(coords[3], col);

            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                // out of bounds or not a farmland cell?
                if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || land[nextRow][nextCol] != 1) {
                    continue;
                }

                dfs(land, nextRow, nextCol, coords);
            }
        }
    }
}
