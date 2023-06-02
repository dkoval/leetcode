package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/">Detonate the Maximum Bombs</a>
 * <p>
 * You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.
 * This area is in the shape of a circle with the center as the location of the bomb.
 * <p>
 * The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri].
 * xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.
 * <p>
 * You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range.
 * These bombs will further detonate the bombs that lie in their ranges.
 * <p>
 * Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= bombs.length <= 100</li>
 *  <li>bombs[i].length == 3</li>
 *  <li>1 <= xi, yi, ri <= 10^5</li>
 * </ul>
 */
public interface DetonateMaximumBombs {

    int maximumDetonation(int[][] bombs);

    class DetonateMaximumBombsDFSRev1 implements DetonateMaximumBombs {

        @Override
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;

            // adj[i] is the list of bombs that lie in the i-th bomb range
            Map<Cell, List<Cell>> adj = new HashMap<>();
            // how many bombs are placed at (x, y) location
            Map<Cell, Integer> counts = new HashMap<>();

            for (int i = 0; i < n; i++) {
                Cell source = new Cell(bombs[i][0], bombs[i][1]);
                counts.put(source, counts.getOrDefault(source, 0) + 1);
                // find bombs[j] that lie in the i-th bomb range
                // (x - x0)^2 + (y - y0)^2 <= r^2
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (pow2(bombs[i][0] - bombs[j][0]) + pow2(bombs[i][1] - bombs[j][1]) <= pow2(bombs[i][2])) {
                        Cell target = new Cell(bombs[j][0], bombs[j][1]);
                        adj.computeIfAbsent(source, __ -> new ArrayList<>()).add(target);
                    }
                }
            }

            int best = 0;
            for (int[] bomb : bombs) {
                best = Math.max(best, dfs(adj, counts, new Cell(bomb[0], bomb[1]), new HashSet<>()));
            }
            return best;
        }

        private int dfs(Map<Cell, List<Cell>> adj, Map<Cell, Integer> counts, Cell source, Set<Cell> visited) {
            visited.add(source);
            int count = counts.get(source);
            for (Cell neighbor : adj.getOrDefault(source, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    count += dfs(adj, counts, neighbor, visited);
                }
            }
            return count;
        }

        private long pow2(int x) {
            // Constraints: x <= 10^5
            // Therefore x^2 <= 10^10 - doesn't fit into int
            return ((long) x) * x;
        }

        private static class Cell {
            final int x;
            final int y;

            Cell(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || obj.getClass() != Cell.class) {
                    return false;
                }
                Cell that = (Cell) obj;
                return (x == that.x) && (y == that.y);
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }

    class DetonateMaximumBombsDFSRev2 implements DetonateMaximumBombs {

        @Override
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;

            int best = 0;
            for (int i = 0; i < n; i++) {
                // spread bombs[i] detonation effect
                best = Math.max(best, dfs(bombs, i, new boolean[n]));
            }
            return best;
        }

        private int dfs(int[][] bombs, int i, boolean[] visited) {
            int n = bombs.length;

            visited[i] = true;
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && detonate(bombs, i, j)) {
                    count += dfs(bombs, j, visited);
                }
            }
            return count;
        }

        // checks if bombs[i] detonates bombs[j], i.e. bombs[j] lies in the bombs[i] range
        private boolean detonate(int[][] bombs, int i, int j) {
            // (x - x0)^2 + (y - y0)^2 <= R^2
            int dx = bombs[j][0] - bombs[i][0];
            int dy = bombs[j][1] - bombs[i][1];
            int r = bombs[i][2];
            return pow2(dx) + pow2(dy) <= pow2(r);
        }

        private long pow2(int x) {
            // Constraints: x <= 10^5
            // Therefore x^2 <= 10^10 - doesn't fit into int
            return ((long) x) * x;
        }
    }
}
