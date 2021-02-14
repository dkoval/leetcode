package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3639/">Is Graph Bipartite?</a>
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
 */
public class IsGraphBipartite {

    private enum Label {
        RED, BLUE
    }

    private static class LabeledVertex {
        final int idx;
        final Label label;

        LabeledVertex(int idx, Label label) {
            this.idx = idx;
            this.label = label;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Label[] labels = new Label[n];
        for (int u = 0; u < n; u++) {
            if (labels[u] == null) {
                if (!canLabel(graph, labels, u)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canLabel(int[][] graph, Label[] labels, int u) {
        Queue<LabeledVertex> queue = new LinkedList<>();
        labels[u] = Label.RED;
        queue.offer(new LabeledVertex(u, Label.RED));

        while (!queue.isEmpty()) {
            LabeledVertex x = queue.poll();
            Label adjLabel = (x.label == Label.RED) ? Label.BLUE : Label.RED;
            for (int v : graph[x.idx]) {
                if (labels[v] == null) {
                    labels[v] = adjLabel;
                    queue.offer(new LabeledVertex(v, adjLabel));
                } else if (labels[v] != adjLabel) {
                    return false;
                }
            }
        }
        return true;
    }
}
