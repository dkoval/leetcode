package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/">Shortest Distance After Road Addition Queries I</a>
 * <p>
 * You are given an integer n and a 2D integer array queries.
 * <p>
 * There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1
 * for all 0 <= i < n - 1.
 * <p>
 * queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi.
 * After each query, you need to find the length of the shortest path from city 0 to city n - 1.
 * <p>
 * Return an array answer where for each i in the range [0, queries.length - 1],
 * answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 500</li>
 *  <li>1 <= queries.length <= 500</li>
 *  <li>queries[i].length == 2</li>
 *  <li>0 <= queries[i][0] < queries[i][1] < n</li>
 *  <li>1 < queries[i][1] - queries[i][0]</li>
 *  <li>There are no repeated roads among the queries.</li>
 * </ul>
 */
public interface ShortestDistanceAfterRoadAdditionQueries1 {

    int[] shortestDistanceAfterQueries(int n, int[][] queries);

    class ShortestDistanceAfterRoadAdditionQueries1Rev1 implements ShortestDistanceAfterRoadAdditionQueries1 {

        private static int bfs(Map<Integer, List<Integer>> adj, int n, int source, int target) {
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            q.offer(source);
            visited[source] = true;

            int count = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int u = q.poll();
                    for (int v : adj.getOrDefault(u, List.of())) {
                        if (v == target) {
                            return count + 1;
                        }

                        if (!visited[v]) {
                            q.offer(v);
                            visited[v] = true;
                        }
                    }
                }
                count++;
            }
            return -1;
        }

        @Override
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                adj.computeIfAbsent(i, __ -> new ArrayList<>()).add(i + 1);
            }


            int q = queries.length;
            int[] ans = new int[q];
            for (int i = 0; i < q; i++) {
                adj.computeIfAbsent(queries[i][0], __ -> new ArrayList<>()).add(queries[i][1]);
                ans[i] = bfs(adj, n, 0, n - 1);
            }
            return ans;
        }
    }
}
