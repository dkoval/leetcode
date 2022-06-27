package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">Find Eventual Safe States</a>
 * <p>
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed
 * 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge
 * from node i to each node in graph[i].
 * <p>
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
 * from that node leads to a terminal node.
 * <p>
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == graph.length</li>
 *  <li>1 <= n <= 10^4</li>
 *  <li>0 <= graph[i].length <= n</li>
 *  <li>0 <= graph[i][j] <= n - 1</li>
 *  <li>graph[i] is sorted in a strictly increasing order</li>
 *  <li>The graph may contain self-loops</li>
 *  <li>The number of edges in the graph will be in the range [1, 4 * 10^4]</li>
 * </ul>
 */
public interface FindEventualSafeStates {

    List<Integer> eventualSafeNodes(int[][] graph);

    class FindEventualSafeStatesDFS implements FindEventualSafeStates {
        private static final int UNVISITED = 0;
        private static final int BEING_VISITED = 1;
        private static final int VISITED = 2;

        @Override
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<Integer> ans = new ArrayList<>();
            int[] visited = new int[n];
            for (int u = 0; u < n; u++) {
                if (dfs(graph, u, visited)) {
                    ans.add(u);
                }
            }
            return ans;
        }

        // O(V + E) time | O(V) space, where
        // V - number of nodes in the graph, E - number of edges
        private boolean dfs(int[][] graph, int u, int[] visited) {
            if (visited[u] != UNVISITED) {
                // either BEING_VISITED or VISITED
                return visited[u] == VISITED;
            }

            visited[u] = BEING_VISITED;
            for (int v : graph[u]) {
                if (visited[v] == UNVISITED) {
                    if (!dfs(graph, v, visited)) {
                        // reached a cycle
                        return false;
                    }
                } else if (visited[v] == BEING_VISITED) {
                    // reached a cycle
                    return false;
                }
            }
            visited[u] = VISITED;
            return true;
        }
    }
}
