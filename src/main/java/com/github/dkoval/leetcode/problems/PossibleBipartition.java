package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/possible-bipartition/">Possible Bipartition</a>
 * <p>
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai
 * does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 2000</li>
 *  <li>0 <= dislikes.length <= 10^4</li>
 *  <li>dislikes[i].length == 2</li>
 *  <li>1 <= dislikes[i][j] <= n</li>
 *  <li>ai < bi</li>
 *  <li>All the pairs of dislikes are unique</li>
 * </ul>
 */
public interface PossibleBipartition {

    boolean possibleBipartition(int n, int[][] dislikes);

    class PossibleBipartitionRev1 implements PossibleBipartition {

        @Override
        public boolean possibleBipartition(int n, int[][] dislikes) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] people : dislikes) {
                graph.computeIfAbsent(people[0], key -> new ArrayList<>()).add(people[1]);
                graph.computeIfAbsent(people[1], key -> new ArrayList<>()).add(people[0]);
            }

            int[] colors = new int[n + 1];
            Arrays.fill(colors, -1);
            for (int u = 0; u < n; u++) {
                if (colors[u] == -1 && !dfs(graph, u,  0, colors)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int u, int color, int[] colors) {
            colors[u] = color;
            int adjColor = 1 - color;
            for (int v : graph.getOrDefault(u, Collections.emptyList())) {
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
}
