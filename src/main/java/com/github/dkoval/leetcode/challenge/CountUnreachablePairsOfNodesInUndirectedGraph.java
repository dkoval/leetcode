package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">Count Unreachable Pairs of Nodes in an Undirected Graph</a>
 * <p>
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * <p>
 * Return the number of pairs of different nodes that are unreachable from each other.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= edges.length <= 2 * 10^5</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>ai != bi</li>
 *  <li>There are no repeated edges.</li>
 * </ul>
 */
public interface CountUnreachablePairsOfNodesInUndirectedGraph {

    long countPairs(int n, int[][] edges);

    class CountUnreachablePairsOfNodesInUndirectedGraphUsingBFS implements CountUnreachablePairsOfNodesInUndirectedGraph {

        @Override
        public long countPairs(int n, int[][] edges) {
            if (edges.length == 0) {
                // C(n, 2) = n * (n - 1) / 2
                return (long) n / 2 * (n - 1);
            }

            // idea: counts the number of nodes in each connected component;
            // used DFS or BFS to identify connected components.
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }

            boolean[] visited = new boolean[n];
            // counts[i] - the number of nodes in the i-th connected component
            List<Integer> counts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    counts.add(bfs(adj, i, visited));
                }
            }

            long ans = 0;
            for (int i = 0; i < counts.size() - 1; i++) {
                for (int j = i + 1; j < counts.size(); j++) {
                    ans += (long) counts.get(i) * counts.get(j);
                }
            }
            return ans;
        }

        private int bfs(Map<Integer, List<Integer>> adj, int source, boolean[] visited) {
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(source);
            visited[source] = true;
            int count = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                count++;
                for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (!visited[v]) {
                        q.offer(v);
                        visited[v] = true;
                    }
                }
            }
            return count;
        }
    }
}
