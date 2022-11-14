package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/"> </a>
 * <p>
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 * <p>
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 * <p>
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= stones.length <= 1000</li>
 *  <li>0 <= xi, yi <= 10^4</li>
 *  <li>No two stones are at the same coordinate point</li>
 * </ul>
 */
public interface MostStonesRemovedWithSameRowOrColumn {

    int removeStones(int[][] stones);

    // O(N^2) time | O(N^2) space
    class MostStonesRemovedWithSameRowOrColumnUsingDFS implements MostStonesRemovedWithSameRowOrColumn {

        @Override
        public int removeStones(int[][] stones) {
            int n = stones.length;

            // 2 stones are considered adjacent if they share
            // the same row or column
            Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        // undirected graph
                        graph.computeIfAbsent(i, __ -> new ArrayList<>()).add(j);
                        graph.computeIfAbsent(j, __ -> new ArrayList<>()).add(i);
                    }
                }
            }

            Set<Integer> visited = new HashSet<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    count += dfs(graph, i, visited);
                }
            }
            return count;
        }

        private int dfs(Map<Integer, List<Integer>> graph, int u, Set<Integer> visited) {
            visited.add(u);
            // explore adjacent stones
            int count = 0;
            for (int v : graph.getOrDefault(u, Collections.emptyList())) {
                if (!visited.contains(v)) {
                    // remove v and proceed further
                    count += dfs(graph, v, visited) + 1;
                }
            }
            return count;
        }
    }
}
