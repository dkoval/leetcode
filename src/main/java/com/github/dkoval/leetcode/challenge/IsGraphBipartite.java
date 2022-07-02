package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
 * <p>
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 * More formally, for each v in graph[u], there is an undirected edge between node u and node v.
 * The graph has the following properties:
 * <ul>
 *  <li>There are no self-edges (graph[u] does not contain u).</li>
 *  <li>There are no parallel edges (graph[u] does not contain duplicate values).</li>
 *  <li>If v is in graph[u], then u is in graph[v] (the graph is undirected).</li>
 *  <li>The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.</li>
 * </ul>
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph
 * connects a node in set A and a node in set B.
 * <p>
 * Return true if and only if it is bipartite.
 * <p>
 * Constraints:
 * <ul>
 *  <li>graph.length == n</li>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= graph[u].length < n</li>
 *  <li>0 <= graph[u][i] <= n - 1</li>
 *  <li>graph[u] does not contain u</li>
 *  <li>All the values of graph[u] are unique</li>
 *  <li>If graph[u] contains v, then graph[v] contains u</li>
 * </ul>
 */
public interface IsGraphBipartite {

    boolean isBipartite(int[][] graph);

    class IsGraphBipartiteDFS implements IsGraphBipartite {

        @Override
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];
            Arrays.fill(colors, -1);

            for (int u = 0; u < n; u++) {
                if (colors[u] == -1 && !dfs(graph, u, 0, colors)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int u, int color, int[] colors) {
            colors[u] = color;
            int adjColor = 1 - color;
            for (int v : graph[u]) {
                if (colors[v] == -1) {
                    boolean ok = dfs(graph, v, adjColor, colors);
                    if (!ok) {
                        return false;
                    }
                } else if (colors[v] != adjColor) {
                    return false;
                }
            }
            return true;
        }
    }

    class IsGraphBipartiteBFS implements IsGraphBipartite {

        // O(V + E) time
        // O(V) space
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];
            Arrays.fill(colors, -1);

            for (int u = 0; u < n; u++) {
                if (colors[u] == -1 && !bfs(graph, u, colors)) {
                    return false;
                }
            }
            return true;
        }

        private boolean bfs(int[][] graph, int start, int[] colors) {
            Queue<Integer> q = new ArrayDeque<>();
            colors[start] = 0;
            q.offer(start);
            while (!q.isEmpty()) {
                int u = q.poll();
                // adjacent vertices are expected to have the opposite color
                int adjColor = 1 - colors[u];
                for (int v : graph[u]) {
                    if (colors[v] == -1) {
                        colors[v] = adjColor;
                        q.offer(v);
                    } else if (colors[v] != adjColor) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
