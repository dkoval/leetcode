package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * <p>
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 200</li>
 *  <li>n == isConnected.length</li>
 *  <li>n == isConnected[i].length</li>
 *  <li>isConnected[i][j] is 1 or 0</li>
 *  <li>isConnected[i][i] == 1</li>
 *  <li>isConnected[i][j] == isConnected[j][i]</li>
 * </ul>
 */
public interface NumberOfProvinces {

    int findCircleNum(int[][] connected);

    class NumberOfProvincesUsingDFS implements NumberOfProvinces {

        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int findCircleNum(int[][] connected) {
            int n = connected.length;
            int count = 0;
            boolean[] visited = new boolean[n];
            for (int u = 0; u < n; u++) {
                if (!visited[u]) {
                    dfs(connected, u, visited);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] connected, int u, boolean[] visited) {
            int n = connected.length;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (u != v && connected[u][v] == 1 && !visited[v]) {
                    dfs(connected, v, visited);
                }
            }
        }
    }

    class NumberOfProvincesUsingUnionFind implements NumberOfProvinces {

        private static class UnionFind {
            int[] parent;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px != py) {
                    parent[px] = py;
                    return true;
                }
                return false;
            }
        }

        @Override
        public int findCircleNum(int[][] connected) {
            int n = connected.length;
            UnionFind uf = new UnionFind(n);
            int count = n;
            // consider all pairs of connected cities
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (connected[i][j] == 1 && uf.union(i, j)) {
                        count--;
                    }
                }
            }
            return count;
        }
    }
}
