package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">Minimum Number of Vertices to Reach All Nodes</a>
 * <p>
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * <p>
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 * <p>
 * Notice that you can return the vertices in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= edges.length <= min(10^5, n * (n - 1) / 2)</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= fromi, toi < n</li>
 *  <li>All pairs (fromi, toi) are distinct</li>
 * </ul>
 */
public class MinimumNumberOfVerticesToReachAllNodes {

    // O(N) time | O(N) space
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // incoming[i] stores the number of incoming edges for a vertex i
        int[] incoming = new int[n];
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            incoming[to]++;
        }

        // any vertex with incoming edges can be reached from some other node,
        // therefore only collect vertices that have no incoming edges
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
