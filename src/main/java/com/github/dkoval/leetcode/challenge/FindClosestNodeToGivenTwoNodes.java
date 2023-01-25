package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-closest-node-to-given-two-nodes/">Find Closest Node to Given Two Nodes</a>
 * <p>
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * <p>
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i].
 * If there is no outgoing edge from i, then edges[i] == -1.
 * <p>
 * You are also given two integers node1 and node2.
 * <p>
 * Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node,
 * and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.
 * <p>
 * Note that edges may contain cycles.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == edges.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>-1 <= edges[i] < n</li>
 *  <li>edges[i] != i</li>
 *  <li>0 <= node1, node2 < n</li>
 * </ul>
 */
public interface FindClosestNodeToGivenTwoNodes {

    int closestMeetingNode(int[] edges, int node1, int node2);

    class FindClosestNodeToGivenTwoNodesRev1 implements FindClosestNodeToGivenTwoNodes {

        @Override
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (edges[i] != -1) {
                    graph.computeIfAbsent(i, __ -> new ArrayList<>()).add(edges[i]);
                }
            }

            // dists1[i] is the shortest distance from node1 to node i
            int[] dists1 = bfs(graph, node1, n);

            // dists2[i] is the shortest distance from node2 to node i
            int[] dists2 = bfs(graph, node2, n);

            int bestDist = Integer.MAX_VALUE;
            int bestIdx = -1;
            for (int i = 0; i < n; i++) {
                int currDist = Math.max(dists1[i], dists2[i]);
                if (currDist < bestDist) {
                    bestDist = currDist;
                    bestIdx = i;
                }
            }
            return bestIdx;
        }

        private int[] bfs(Map<Integer, List<Integer>> graph, int source, int n) {
            int[] dists = new int[n];
            Arrays.fill(dists, Integer.MAX_VALUE);

            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            q.offer(source);
            visited[source] = true;
            int dist = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int u = q.poll();
                    dists[u] = dist;
                    for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                        if (!visited[v]) {
                            q.offer(v);
                            visited[v] = true;
                        }
                    }
                }
                dist++;
            }
            return dists;
        }
    }
}
