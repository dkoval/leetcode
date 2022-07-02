package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/maximal-network-rank/">Maximal Network Rank</a>
 * <p>
 * There is an infrastructure of n cities with some number of roads connecting these cities.
 * Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 * <p>
 * The network rank of two different cities is defined as the total number of directly connected roads to either city.
 * If a road is directly connected to both cities, it is only counted once.
 * <p>
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * <p>
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 100</li>
 *  <li>0 <= roads.length <= n * (n - 1) / 2</li>
 *  <li>roads[i].length == 2</li>
 *  <li>0 <= ai, bi <= n - 1</li>
 *  <li>ai != bi
 *  <li>Each pair of cities has at most one road connecting them</li>
 * </ul>
 */
public interface MaximalNetworkRank {

    int maximalNetworkRank(int n, int[][] roads);

    class MaximalNetworkRankRev1 implements MaximalNetworkRank {

        // O(N^2) time | O(N^2) space
        @Override
        public int maximalNetworkRank(int n, int[][] roads) {
            // degree[i] is the degree of vertex i
            int[] degree = new int[n];
            // connected[i][j] denotes whether there is an edge between vertices i and j
            boolean[][] connected = new boolean[n][n];

            for (int[] road : roads) {
                degree[road[0]]++;
                degree[road[1]]++;
                connected[road[0]][road[1]] = true;
                connected[road[1]][road[0]] = true;
            }

            // consider all pairs of vertices
            int maxRank = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int currRank = degree[i] + degree[j];
                    if (connected[i][j]) {
                        // if an edge is directly connected to both vertices, it is only counted once
                        currRank--;
                    }
                    maxRank = Math.max(maxRank, currRank);
                }
            }
            return maxRank;
        }
    }
}
