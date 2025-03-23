package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/">Number of Ways to Arrive at Destination</a>
 * <p>
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections.
 * The inputs are generated such that you can reach any intersection from any other intersection and that
 * there is at most one road between any two intersections.
 * <p>
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that
 * there is a road between intersections ui and vi that takes timei minutes to travel.
 * You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 * <p>
 * Return the number of ways you can arrive at your destination in the shortest amount of time.
 * Since the answer may be large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= n <= 200</li>
 * <li>n - 1 <= roads.length <= n * (n - 1) / 2</li>
 * <li>roads[i].length == 3</li>
 * <li>0 <= ui, vi <= n - 1</li>
 * <li>1 <= timei <= 10^9</li>
 * <li>ui != vi</li>
 * <li>There is at most one road connecting any two intersections.</li>
 * <li>You can reach any intersection from any other intersection.</li>
 * </ul>
 */
public interface NumberOfWaysToArriveAtDestination {

    int MOD = 1_000_000_007;

    int countPaths(int n, int[][] roads);

    class NumberOfWaysToArriveAtDestinationRev1 implements NumberOfWaysToArriveAtDestination {

        @Override
        public int countPaths(int n, int[][] roads) {
            final var adj = new HashMap<Integer, List<Node>>();
            for (var road : roads) {
                adj.computeIfAbsent(road[0], __ -> new ArrayList<>()).add(new Node(road[1], road[2]));
                adj.computeIfAbsent(road[1], __ -> new ArrayList<>()).add(new Node(road[0], road[2]));
            }

            // idea: Dijkstra + DP
            final var pq = new PriorityQueue<Node>(Comparator.comparing(it -> it.time));
            final var visited = new boolean[n];

            // best[v] - the time it takes to get from 0 to v
            final var best = new long[n];
            Arrays.fill(best, Long.MAX_VALUE);

            // DP array:
            // count[v] - the number of ways to get from 0 to v in the shortest amount of time
            final var count = new long[n];

            best[0] = 0L;
            count[0] = 1L;
            pq.offer(new Node(0, 0));
            while (!pq.isEmpty()) {
                var curr = pq.poll();

                if (visited[curr.id]) {
                    continue;
                }

                visited[curr.id] = true;
                for (var neighbor : adj.getOrDefault(curr.id, List.of())) {
                    final var totalTime = best[curr.id] + neighbor.time;
                    if (best[neighbor.id] > totalTime) {
                        best[neighbor.id] = totalTime;
                        count[neighbor.id] = count[curr.id];
                        pq.offer(new Node(neighbor.id, totalTime));
                    } else if (best[neighbor.id] == totalTime) {
                        count[neighbor.id] += count[curr.id];
                        count[neighbor.id] %= MOD;
                    }
                }
            }
            return (int) count[n - 1];
        }

        record Node(
                int id,
                long time
        ) {
        }
    }
}
