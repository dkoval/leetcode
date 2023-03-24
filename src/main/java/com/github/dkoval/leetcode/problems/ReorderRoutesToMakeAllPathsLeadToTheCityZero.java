package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">Reorder Routes to Make All Paths Lead to the City Zero</a>
 * <p>
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
 * two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in
 * one direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 5 * 10^4</li>
 *  <li>connections.length == n - 1</li>
 *  <li>connections[i].length == 2</li>
 *  <li>0 <= ai, bi <= n - 1</li>
 *  <li>ai != bi</li>
 * </ul>
 */
public interface ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    int minReorder(int n, int[][] connections);

    class ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFS implements ReorderRoutesToMakeAllPathsLeadToTheCityZero {

        private static class Node {
            final int id;
            final boolean forward;

            Node(int id, boolean forward) {
                this.id = id;
                this.forward = forward;
            }
        }

        @Override
        public int minReorder(int n, int[][] connections) {
            Map<Integer, List<Node>> graph = new HashMap<>();
            for (int[] connection : connections) {
                graph.computeIfAbsent(connection[0], key -> new ArrayList<>()).add(new Node(connection[1], true));
                graph.computeIfAbsent(connection[1], key -> new ArrayList<>()).add(new Node(connection[0], false));
            }

            boolean[] visited = new boolean[n];
            return dfs(graph, 0, visited);
        }

        private int dfs(Map<Integer, List<Node>> graph, int u, boolean[] visited) {
            visited[u] = true;
            int count = 0;
            for (Node v : graph.get(u)) {
                if (!visited[v.id]) {
                    count += v.forward ? 1 : 0;
                    count += dfs(graph, v.id, visited);
                }
            }
            return count;
        }
    }

    class ReorderRoutesToMakeAllPathsLeadToTheCityZeroBFS implements ReorderRoutesToMakeAllPathsLeadToTheCityZero {

        @Override
        public int minReorder(int n, int[][] connections) {
            Map<Integer, List<Node>> adj = new HashMap<>();
            for (int[] connection : connections) {
                adj.computeIfAbsent(connection[0], __ -> new ArrayList<>()).add(new Node(connection[1], true));
                adj.computeIfAbsent(connection[1], __ -> new ArrayList<>()).add(new Node(connection[0], false));
            }

            // BFS - explore all cities starting from 0
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            q.offer(0);
            visited[0] = true;
            int count = 0;
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (Node neighbor : adj.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited[neighbor.id]) {
                        q.offer(neighbor.id);
                        visited[neighbor.id] = true;
                        if (neighbor.forward) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private static class Node {
            final int id;
            final boolean forward;

            Node(int id, boolean forward) {
                this.id = id;
                this.forward = forward;
            }
        }
    }
}
