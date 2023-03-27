package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-cycle-in-a-graph/">Longest Cycle in a Graph (Hard)</a>
 * <p>
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * <p>
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i].
 * If there is no outgoing edge from node i, then edges[i] == -1.
 * <p>
 * Return the length of the longest cycle in the graph. If no cycle exists, return -1.
 * <p>
 * A cycle is a path that starts and ends at the same node.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == edges.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>-1 <= edges[i] < n</li>
 *  <li>edges[i] != i</li>
 * </ul>
 */
public interface LongestCycleInGraph {

    int longestCycle(int[] edges);

    // O(N) time | O(N) space
    class LongestCycleInGraphRev1 implements LongestCycleInGraph {

        @Override
        public int longestCycle(int[] edges) {
            int n = edges.length;
            boolean[] visited = new boolean[n];
            int[] best = {-1};
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visit(edges, i, visited, best);
                }
            }
            return best[0];
        }

        private void visit(int[] edges, int start, boolean[] visited, int[] best) {
            int curr = start;
            int dist = 0;
            // node -> distance from start
            Map<Integer, Integer> seen = new HashMap<>();
            // keep on exploring the nodes until a cycle is found
            while (!visited[curr]) {
                visited[curr] = true;
                seen.put(curr, dist++);
                if (edges[curr] != -1) {
                    curr = edges[curr];
                    if (seen.containsKey(curr)) {
                        best[0] = Math.max(best[0], dist - seen.get(curr));
                        return;
                    }
                }
            }
        }
    }
}
