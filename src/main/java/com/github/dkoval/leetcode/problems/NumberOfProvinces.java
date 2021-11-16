package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

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
        int n = connected.length;
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int city = 0; city < n; city++) {
            if (!visited.contains(city)) {
                dfs(connected, city, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] connected, int city, Set<Integer> visited) {
        int n = connected.length;
        visited.add(city);
        for (int neighbour = 0; neighbour < n; neighbour++) {
            if (connected[city][neighbour] == 1 && !visited.contains(neighbour)) {
                dfs(connected, neighbour, visited);
            }
        }
    }
}
