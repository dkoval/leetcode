package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/path-with-maximum-probability/">Path with Maximum Probability</a>
 * <p>
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b]
 * is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 * <p>
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end
 * and return its success probability.
 * <p>
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer
 * by at most 1e-5.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^4</li>
 *  <li>0 <= start, end < n</li>
 *  <li>start != end</li>
 *  <li>0 <= a, b < n</li>
 *  <li>a != b</li>
 *  <li>0 <= succProb.length == edges.length <= 2*10^4</li>
 *  <li>0 <= succProb[i] <= 1</li>
 *  <li>There is at most one edge between every two nodes.</li>
 * </ul>
 */
public interface PathWithMaximumProbability {

    double maxProbability(int n, int[][] edges, double[] succProb, int start, int end);

    class PathWithMaximumProbabilityRev1 implements PathWithMaximumProbability {

        @Override
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // convert to adjacency list
            Map<Integer, List<Node>> adj = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                adj.computeIfAbsent(edges[i][0], __ -> new ArrayList<>()).add(new Node(edges[i][1], succProb[i]));
                adj.computeIfAbsent(edges[i][1], __ -> new ArrayList<>()).add(new Node(edges[i][0], succProb[i]));
            }

            // Dijkstra
            Queue<Node> q = new PriorityQueue<>(Comparator.comparingDouble(node -> -1 * node.probability));
            boolean[] visited = new boolean[n];
            q.offer(new Node(start, 1.0));
            while (!q.isEmpty()) {
                Node curr = q.poll();
                if (curr.id == end) {
                    return curr.probability;
                }

                visited[curr.id] = true;
                for (Node neighbor : adj.getOrDefault(curr.id, List.of())) {
                    if (!visited[neighbor.id]) {
                        q.offer(new Node(neighbor.id, curr.probability * neighbor.probability));
                    }
                }
            }
            return 0.0;
        }

        private record Node(int id, double probability) {
        }
    }
}
