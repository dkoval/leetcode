package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-graph-with-shortest-path-calculator/">Design Graph With Shortest Path Calculator (Hard)</a>
 * <p>
 * There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1.
 * The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti]
 * meaning that there is an edge from fromi to toi with the cost edgeCosti.
 * <p>
 * Implement the Graph class:
 * <ul>
 *  <li>Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.</li>
 *  <li>addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost].
 *  It is guaranteed that there is no edge between the two nodes before adding this one.
 *  </li>
 *  <li>int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2.
 *  If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.
 *  </li>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= edges.length <= n * (n - 1)</li>
 *  <li>edges[i].length == edge.length == 3</li>
 *  <li>0 <= fromi, toi, from, to, node1, node2 <= n - 1</li>
 *  <li>1 <= edgeCosti, edgeCost <= 10^6</li>
 *  <li>There are no repeated edges and no self-loops in the graph at any point.</li>
 *  <li>At most 100 calls will be made for addEdge.</li>
 *  <li>At most 100 calls will be made for shortestPath.</li>
 * </ul>
 */
public interface DesignGraphWithShortestPathCalculator {

    abstract class Graph {

        Graph(int n, int[][] edges) {
            // noop
        }

        abstract void addEdge(int[] edge);

        abstract int shortestPath(int node1, int node2);
    }

    class GraphRev1 extends Graph {

        private final List<Node>[] adj;
        private final int n;
        public GraphRev1(int n, int[][] edges) {
            super(n, edges);

            this.n = n;
            this.adj = new List[n];
            for (int i = 0; i < n; i++) {
                this.adj[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        @Override
        public final void addEdge(int[] edge) {
            adj[edge[0]].add(new Node(edge[1], edge[2]));
        }

        @Override
        public int shortestPath(int node1, int node2) {
            // Dijkstra's algorithm
            Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(it -> it.cost));
            boolean[] visited = new boolean[n];

            q.offer(new Node(node1, 0));
            while (!q.isEmpty()) {
                Node curr = q.poll();
                visited[curr.id] = true;

                if (curr.id == node2) {
                    return curr.cost;
                }

                for (Node next : adj[curr.id]) {
                    if (!visited[next.id]) {
                        q.offer(new Node(next.id, curr.cost + next.cost));
                    }
                }
            }
            return -1;
        }

        private static class Node {
            final int id;
            final int cost;

            Node(int id, int cost) {
                this.id = id;
                this.cost = cost;
            }
        }
    }
}
