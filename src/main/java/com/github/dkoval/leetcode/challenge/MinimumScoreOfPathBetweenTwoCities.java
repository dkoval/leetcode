package com.github.dkoval.leetcode.challenge;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/">Minimum Score of a Path Between Two Cities</a>
 * <p>
 * You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads
 * where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei.
 * The cities graph is not necessarily connected.
 * <p>
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 * <p>
 * Return the minimum possible score of a path between cities 1 and n.
 * <p>
 * Note:
 * <ul>
 *  <li>A path is a sequence of roads between two cities.</li>
 *  <li>It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.</li>
 *  <li>The test cases are generated such that there is at least one path between 1 and n.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= roads.length <= 10^5</li>
 *  <li>roads[i].length == 3</li>
 *  <li>1 <= ai, bi <= n</li>
 *  <li>ai != bi</li>
 *  <li>1 <= distancei <= 10^4</li>
 *  <li>There are no repeated edges.</li>
 *  <li>There is at least one path between 1 and n.</li>
 * </ul>
 */
public interface MinimumScoreOfPathBetweenTwoCities {

    int minScore(int n, int[][] roads);

    // O(N) time | O(N) space
    class MinimumScoreOfPathBetweenTwoCitiesUsingBFS implements MinimumScoreOfPathBetweenTwoCities {

        @Override
        public int minScore(int n, int[][] roads) {
            final var adj = new HashMap<Integer, List<City>>();
            for (var road : roads) {
                adj.computeIfAbsent(road[0], _ -> new ArrayList<>()).add(new City(road[1], road[2]));
                adj.computeIfAbsent(road[1], _ -> new ArrayList<>()).add(new City(road[0], road[2]));
            }

            // BFS
            final var q = new ArrayDeque<Integer>();
            final var visited = new boolean[n + 1];
            q.offer(1);
            visited[1] = true;
            var best = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                final var curr = q.poll();
                for (var neighbor : adj.getOrDefault(curr, emptyList())) {
                    // NOTE. Updating `best` within the above IF statement will yield a wrong result on certain test cases.
                    best = Math.min(best, neighbor.dist);
                    if (!visited[neighbor.id]) {
                        q.offer(neighbor.id);
                        visited[neighbor.id] = true;
                    }
                }
            }
            return best;
        }

        private record City(int id, int dist) {
        }
    }

    // O(N) time | O(N) space
    class MinimumScoreOfPathBetweenTwoCitiesUsingDFS implements MinimumScoreOfPathBetweenTwoCities {

        @Override
        public int minScore(int n, int[][] roads) {
            final var adj = new HashMap<Integer, List<City>>();
            for (int[] road : roads) {
                adj.computeIfAbsent(road[0], _ -> new ArrayList<>()).add(new City(road[1], road[2]));
                adj.computeIfAbsent(road[1], _ -> new ArrayList<>()).add(new City(road[0], road[2]));
            }

            final var best = new int[]{Integer.MAX_VALUE};
            final var visited = new boolean[n + 1];
            dfs(adj, 1, visited, best);
            return best[0];
        }

        private void dfs(Map<Integer, List<City>> adj, int curr, boolean[] visited, int[] best) {
            visited[curr] = true;
            for (City neighbor : adj.getOrDefault(curr, emptyList())) {
                best[0] = Math.min(best[0], neighbor.dist);
                if (!visited[neighbor.id]) {
                    dfs(adj, neighbor.id, visited, best);
                }
            }
        }

        private record City(int id, int dist) {
        }
    }
}
