package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/largest-color-value-in-a-directed-graph/">Largest Color Value in a Directed Graph (Hard)</a>
 * <p>
 * There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
 * <p>
 * You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed).
 * You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
 * <p>
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k.
 * The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
 * <p>
 * Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == colors.length</li>
 *  <li>m == edges.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= m <= 10^5</li>
 *  <li>colors consists of lowercase English letters.</li>
 *  <li>0 <= aj, bj < n</li>
 * </ul>
 */
public interface LargestColorValueInDirectedGraph {

    int largestPathValue(String colors, int[][] edges);

    class LargestColorValueInDirectedGraphDFS implements LargestColorValueInDirectedGraph {

        @Override
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();

            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
            }

            // counts[x][c] - the number of c-colored nodes on the path starting at x
            int[][] counts = new int[n][26];

            int best = 0;
            boolean[] visited = new boolean[n];
            boolean[] path = new boolean[n]; // is used to detect a cycle
            for (int x = 0; x < n; x++) {
                if (!visited[x]) {
                    int ans = dfs(adj, x, colors, counts, visited, path);
                    if (ans < 0) {
                        return -1;
                    }
                    best = Math.max(best, ans);
                }
            }
            return best;
        }

        // Returns the largest color value across all paths starting at source
        private int dfs(Map<Integer, List<Integer>> adj, int source, String colors, int[][] counts, boolean[] visited, boolean[] path) {
            if (path[source]) {
                // a cycle detected
                return -1;
            }

            if (visited[source]) {
                return 0;
            }

            visited[source] = true;

            // add source node to the path
            path[source] = true;
            int color = colors.charAt(source) - 'a';

            counts[source][color] = 1;
            for (int neighbor : adj.getOrDefault(source, Collections.emptyList())) {
                int ans = dfs(adj, neighbor, colors, counts, visited, path);
                if (ans < 0) {
                    return -1;
                }

                for (int c = 0; c < 26; c++) {
                    counts[source][c] = Math.max(
                            counts[source][c],
                            counts[neighbor][c] + (c == color ? 1 : 0));
                }
            }

            // backtrack - remove source from the current path
            path[source] = false;

            // get the most frequent color across all paths starting at source
            int best = 0;
            for (int c : counts[source]) {
                best = Math.max(best, c);
            }
            return best;
        }
    }
}
