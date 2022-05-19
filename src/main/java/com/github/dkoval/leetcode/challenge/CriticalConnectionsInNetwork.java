package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/critical-connections-in-a-network/">Critical Connections in a Network</a>
 * <p>
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi]
 * represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^5</li>
 *  <li>n - 1 <= connections.length <= 10^5</li>
 *  <li>0 <= ai, bi <= n - 1</li>
 *  <li>ai != bi</li>
 *  <li>There are no repeated connections</li>
 * </ul>
 */
public interface CriticalConnectionsInNetwork {

    List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections);

    // https://www.youtube.com/watch?v=RYaakWv5m6o
    class CriticalConnectionsInNetworkUsingTarjan implements CriticalConnectionsInNetwork {
        private int id = 0;

        @Override
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<Integer>[] graph = buildGraph(n, connections);
            // Tarjan's algorithm
            boolean[] visited = new boolean[n];
            int[] low = new int[n]; // low[u] is the lowest id reachable from vertex u
            List<List<Integer>> ans = new ArrayList<>();
            dfs(graph, 0, -1, visited, low, ans);
            return ans;
        }

        private List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
            List<Integer>[] graph = new List[n];
            for (List<Integer> edge : connections) {
                int u = edge.get(0);
                int v = edge.get(1);

                if (graph[u] == null) {
                    graph[u] = new ArrayList<>();
                }
                graph[u].add(v);

                if (graph[v] == null) {
                    graph[v] = new ArrayList<>();
                }
                graph[v].add(u);
            }
            return graph;
        }

        private void dfs(List<Integer>[] graph, int u, int prev, boolean[] visited, int[] low, List<List<Integer>> ans) {
            visited[u] = true;
            int currId = low[u] = id++;

            for (int v : graph[u]) {
                if (v == prev) {
                    continue;
                }

                if (!visited[v]) {
                    dfs(graph, v, u, visited, low, ans);
                }

                low[u] = Math.min(low[u], low[v]);

                if (currId < low[v]) {
                    ans.add(Arrays.asList(u, v));
                }
            }
        }
    }
}
