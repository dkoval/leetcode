package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * <p>
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 200</li>
 *  <li>n == isConnected.length</li>
 *  <li>n == isConnected[i].length</li>
 *  <li>isConnected[i][j] is 1 or 0</li>
 *  <li>isConnected[i][i] == 1</li>
 *  <li>isConnected[i][j] == isConnected[j][i]</li>
 * </ul>
 */
public class NumberOfProvinces {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int findCircleNum(int[][] connected) {
        Map<Integer, List<Integer>> adj = adj(connected);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int city : adj.keySet()) {
            if (!visited.contains(city)) {
                visited.add(city);
                dfs(adj, city, visited);
                count++;
            }
        }
        return count;
    }

    private Map<Integer, List<Integer>> adj(int[][] connected) {
        int n = connected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (connected[i][j] == 1) {
                    adj.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
                }
            }
        }
        return adj;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int source, Set<Integer> visited) {
        for (int x : adj.get(source)) {
            if (!visited.contains(x)) {
                visited.add(x);
                dfs(adj, x, visited);
            }
        }
    }
}
