package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Number of Operations to Make Network Connected</a>
 * <p>
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
 * connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer
 * directly or indirectly through the network.
 * <p>
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.
 * <p>
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= connections.length <= min(n * (n - 1) / 2, 10^5)</li>
 *  <li>connections[i].length == 2</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>ai != bi</li>
 *  <li>There are no repeated connections</li>
 *  <li>No two computers are connected by more than one cable</li>
 * </ul>
 */
public interface NumberOfOperationsToMakeNetworkConnected {

    int makeConnected(int n, int[][] connections);

    class NumberOfOperationsToMakeNetworkConnectedDFSRecursive implements NumberOfOperationsToMakeNetworkConnected {

        @Override
        public int makeConnected(int n, int[][] connections) {
            // Fact: as long as there are at least (n - 1) connections, we can always connect n nodes
            int numConnections = connections.length;
            if (numConnections < n - 1) {
                return -1;
            }

            // Run DFS to determine the number of connected components
            int count = 0;
            Map<Integer, List<Integer>> graph = buildGraph(connections);
            boolean[] visited = new boolean[n];
            for (int u = 0; u < n; u++) {
                if (!visited[u]) {
                    dfs(graph, u, visited);
                    count++;
                }
            }
            // Same idea: can always connect m components with (m - 1) connections
            return count - 1;
        }

        private Map<Integer, List<Integer>> buildGraph(int[][] connections) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] connection : connections) {
                int a = connection[0];
                int b = connection[1];
                graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
            }
            return graph;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int u, boolean[] visited) {
            visited[u] = true;
            for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                if (!visited[v]) {
                    dfs(graph, v, visited);
                }
            }
        }
    }

    class NumberOfOperationsToMakeNetworkConnectedDFSIterative implements NumberOfOperationsToMakeNetworkConnected {

        @Override
        public int makeConnected(int n, int[][] connections) {
            // Fact: as long as there are at least (n - 1) connections, we can always connect n nodes
            int numConnections = connections.length;
            if (numConnections < n - 1) {
                return -1;
            }

            // Run DFS to determine the number of connected components
            int count = 0;
            Map<Integer, List<Integer>> graph = buildGraph(connections);
            boolean[] visited = new boolean[n];
            for (int u = 0; u < n; u++) {
                if (!visited[u]) {
                    dfs(graph, u, visited);
                    count++;
                }
            }
            // Same idea: can always connect m components with (m - 1) connections
            return count - 1;
        }

        private Map<Integer, List<Integer>> buildGraph(int[][] connections) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] connection : connections) {
                int a = connection[0];
                int b = connection[1];
                graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
            }
            return graph;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int source, boolean[] visited) {
            Deque<Integer> stack = new ArrayDeque<>();
            visited[source] = true;
            stack.push(source);
            while (!stack.isEmpty()) {
                int u = stack.pop();
                for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        stack.push(v);
                    }
                }
            }
        }
    }

    class NumberOfOperationsToMakeNetworkConnectedBFS implements NumberOfOperationsToMakeNetworkConnected {

        @Override
        public int makeConnected(int n, int[][] connections) {
            // Fact: as long as there are at least (n - 1) connections, we can always connect n nodes
            int numConnections = connections.length;
            if (numConnections < n - 1) {
                return -1;
            }

            // Run BFS to determine the number of connected components
            int count = 0;
            Map<Integer, List<Integer>> graph = buildGraph(connections);
            boolean[] visited = new boolean[n];
            for (int u = 0; u < n; u++) {
                if (!visited[u]) {
                    bfs(graph, u, visited);
                    count++;
                }
            }
            // Same idea: can always connect m components with (m - 1) connections
            return count - 1;
        }

        private Map<Integer, List<Integer>> buildGraph(int[][] connections) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] connection : connections) {
                int a = connection[0];
                int b = connection[1];
                graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
            }
            return graph;
        }

        private void bfs(Map<Integer, List<Integer>> graph, int source, boolean[] visited) {
            Queue<Integer> queue = new ArrayDeque<>();
            visited[source] = true;
            queue.offer(source);
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
    }
}
