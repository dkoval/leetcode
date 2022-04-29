package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
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
public class IsGraphBipartite {

    private enum Color {
        RED, BLUE;
    }

    // O(V + E) time
    // O(V) space
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Color[] colors = new Color[n];
        for (int u = 0; u < n; u++) {
            if (colors[u] != null) {
                // skip already colored vertices
                continue;
            }

            if (!canColor(graph, u, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean canColor(int[][] graph, int start, Color[] colors) {
        // BFS
        Queue<Integer> q = new LinkedList<>();
        colors[start] = Color.RED;
        q.offer(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            // adjacent vertices are expected to have the opposite color
            Color adjColor = (colors[u] == Color.RED) ? Color.BLUE : Color.RED;
            for (int v : graph[u]) {
                if (colors[v] == null) {
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
