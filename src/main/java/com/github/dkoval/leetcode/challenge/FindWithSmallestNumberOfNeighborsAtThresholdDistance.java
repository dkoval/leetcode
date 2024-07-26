package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">Find the City With the Smallest Number of Neighbors at a Threshold Distance</a>
 * <p>
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents
 * a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
 * <p>
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is
 * at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 * <p>
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 100</li>
 *  <li>1 <= edges.length <= n * (n - 1) / 2</li>
 *  <li>edges[i].length == 3</li>
 *  <li>0 <= fromi < toi < n</li>
 *  <li>1 <= weighti, distanceThreshold <= 10^4</li>
 *  <li>All pairs (fromi, toi) are distinct.</li>
 * </ul>
 */
public interface FindWithSmallestNumberOfNeighborsAtThresholdDistance {

    int findTheCity(int n, int[][] edges, int distanceThreshold);

    class FindWithSmallestNumberOfNeighborsAtThresholdDistanceRev1 implements FindWithSmallestNumberOfNeighborsAtThresholdDistance {

        @Override
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            Map<Integer, List<Node>> adj = new HashMap<>();
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(new Node(edge[0], edge[2]));
            }

            int bestCity = -1;
            int minReachableCities = Integer.MAX_VALUE;
            for (int city = 0; city < n; city++) {
                int numReachableCities = dijkstra(adj, n, city, distanceThreshold);
                if (numReachableCities <= minReachableCities) {
                    minReachableCities = numReachableCities;
                    bestCity = city;
                }
            }
            return bestCity;
        }

        private int dijkstra(Map<Integer, List<Node>> adj, int n, int start, int distanceThreshold) {
            Queue<Node> q = new PriorityQueue<>(Comparator.comparing(it -> it.weight));
            boolean[] visited = new boolean[n];

            int count = -1;
            q.offer(new Node(start, 0));
            while (!q.isEmpty()) {
                Node curr = q.poll();
                if (visited[curr.id]) {
                    continue;
                }

                visited[curr.id] = true;
                count++;

                for (Node neighbor : adj.getOrDefault(curr.id, List.of())) {
                    if (!visited[neighbor.id] && curr.weight + neighbor.weight <= distanceThreshold) {
                        q.offer(new Node(neighbor.id, curr.weight + neighbor.weight));
                    }
                }
            }
            return count;
        }

        private record Node(int id, int weight) {
        }
    }
}
