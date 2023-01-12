package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">Minimum Time to Collect All Apples in a Tree</a>
 * <p>
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
 * You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect
 * all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * <p>
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge
 * connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true
 * means that vertex i has an apple; otherwise, it does not have any apple.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>edges.length == n - 1</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= ai < bi <= n - 1</li>
 *  <li>from_i < to_i</li>
 *  <li>hasApple.length == n</li>
 * </ul>
 */
public interface MinimumTimeToCollectAllApplesInTree {

    int minTime(int n, int[][] edges, List<Boolean> hasApple);

    class MinimumTimeToCollectAllApplesInTreeRev1 implements MinimumTimeToCollectAllApplesInTree {
        @Override
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            // convert to adj list
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            return dfs(graph, hasApple, 0, -1);
        }

        private int dfs(List<Integer>[] graph, List<Boolean> hasApple, int node, int parent) {
            int time = 0;
            for (int child : graph[node]) {
                if (child != parent) {
                    time += dfs(graph, hasApple, child, node);
                }
            }

            // add cost of coming back to the parent node:
            // - current node has an apple
            // - a subtree of the current node has an apple
            if ((hasApple.get(node) || time > 0) && node != 0) {
                time += 2;
            }
            return time;
        }
    }
}
