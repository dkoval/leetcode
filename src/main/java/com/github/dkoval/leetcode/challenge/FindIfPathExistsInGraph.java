package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Find if Path Exists in Graph</a>
 * <p>
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi]
 * denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
 * and no vertex has an edge to itself.
 * <p>
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * <p>
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination,
 * or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= n <= 2 * 105</li>
 * <li>0 <= edges.length <= 2 * 105</li>
 * <li>edges[i].length == 2</li>
 * <li>0 <= ui, vi <= n - 1</li>
 * <li>ui != vi</li>
 * <li>0 <= source, destination <= n - 1</li>
 * <li>There are no duplicate edges</li>
 * <li>There are no self edges</li>
 * </ul>
 */
public interface FindIfPathExistsInGraph {

    boolean validPath(int n, int[][] edges, int source, int destination);

    class FindIfPathExistsInGraphBFS implements FindIfPathExistsInGraph {

        @Override
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            if (source == destination) {
                return true;
            }

            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }

            // BFS
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            q.offer(source);
            visited[source] = true;
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int neighbor : adj.getOrDefault(curr, List.of())) {
                    if (neighbor == destination) {
                        return true;
                    }

                    if (!visited[neighbor]) {
                        q.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            return false;
        }
    }
}
