package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">Shortest Path with Alternating Colors</a>
 * <p>
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
 * Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * <p>
 * You are given two arrays redEdges and blueEdges where:
 * <p>
 * redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
 * such that the edge colors alternate along the path, or -1 if such a path does not exist.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= redEdges.length, blueEdges.length <= 400</li>
 *  <li>redEdges[i].length == blueEdges[j].length == 2</li>
 *  <li>0 <= ai, bi, uj, vj < n</li>
 * </ul>
 */
public interface ShortestPathWithAlternatingColors {

    int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges);

    class ShortestPathWithAlternatingColorsBFS implements ShortestPathWithAlternatingColors {

        private static final int RED = 0;
        private static final int BLUE = 1;

        private static class Node {
            final int id;
            final int color; // color of an incoming edge

            Node(int id, int color) {
                this.id = id;
                this.color = color;
            }
        }

        @Override
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            // graph[0] - adj list representation of the graph with red edges only
            // graph[1] - adj list representation of the graph with blue edges only
            List<Map<Integer, List<Integer>>> graph = Arrays.asList(adjList(redEdges), adjList(blueEdges));

            // BFS
            Queue<Node> q = new ArrayDeque<>();

            // dist[c][i] - the length of the shortest path from 0 to i such that the edge colors alternate in the c-colored graph;
            // also is used to check if the i-th node has been visited.
            int[][] dist = new int[2][n];
            Arrays.fill(dist[RED], Integer.MAX_VALUE);
            Arrays.fill(dist[BLUE], Integer.MAX_VALUE);

            dist[RED][0] = 0;
            dist[BLUE][0] = 0;

            // multi-source BFS: starting node 0 can "have" either RED or BLUE incoming edge
            q.offer(new Node(0, RED));
            q.offer(new Node(0, BLUE));
            while (!q.isEmpty()) {
                Node curr = q.poll();
                int u = curr.id;
                int c = curr.color;

                for (int v : graph.get(c).getOrDefault(u, Collections.emptyList())) {
                    if (dist[1 - c][v] == Integer.MAX_VALUE) {
                        // not yet visited
                        q.offer(new Node(v, 1 - c));
                        dist[1 - c][v] = dist[c][u] + 1;
                    }
                }
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = Math.min(dist[BLUE][i], dist[RED][i]);
                if (ans[i] == Integer.MAX_VALUE) {
                    ans[i] = -1;
                }
            }
            return ans;
        }

        private Map<Integer, List<Integer>> adjList(int[][] edges) {
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int[] edge : edges) {
                adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
            }
            return adjList;
        }
    }
}
