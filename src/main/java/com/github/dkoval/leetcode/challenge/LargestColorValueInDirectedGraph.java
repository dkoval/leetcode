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

            // check if there's a cycle in a directed graph
            // 0 - not visited
            // 1 - being visited
            // 2 - visited
            int[] visited = new int[n];
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && hasCycle(adj, i, visited)) {
                    return -1;
                }
            }

            // check every color (there will be <= 26 unique colors)
            Set<Character> availableColors = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char c = colors.charAt(i);
                availableColors.add(c);
            }

            int best = 0;
            for (char c : availableColors) {
                best = Math.max(best, compute(adj, colors, c));
            }
            return best;
        }

        private boolean hasCycle(Map<Integer, List<Integer>> adj, int source, int[] visited) {
            visited[source] = 1;
            for (int neighbor : adj.getOrDefault(source, Collections.emptyList())) {
                if (visited[neighbor] == 1) {
                    // came to a node marked as "being visited", hence there's a cycle
                    return true;
                }

                if (visited[neighbor] == 0 && hasCycle(adj, neighbor, visited)) {
                    return true;
                }
            }
            visited[source] = 2;
            return false;
        }

        private int compute(Map<Integer, List<Integer>> adj, String colors, char color) {
            int n = colors.length();

            // DP top-down + DFS
            Integer[] dp = new Integer[n];

            // run DFS on every node to determine the largest color value for this "color"
            int best = 0;
            for (int i = 0; i < n; i++) {
                best = Math.max(best, dfs(adj, colors, color, i, dp));
            }
            return best;
        }

        // Returns the largest color value for the fixed "color" across all paths starting at the "source" node
        private int dfs(Map<Integer, List<Integer>> adj, String colors, char color, int source, Integer[] dp) {
            if (dp[source] != null) {
                return dp[source];
            }

            int best = 0;
            for (int neighbor : adj.getOrDefault(source, Collections.emptyList())) {
                best = Math.max(best, dfs(adj, colors, color, neighbor, dp));
            }
            best += colors.charAt(source) == color ? 1 : 0;
            return dp[source] = best;
        }
    }
}
