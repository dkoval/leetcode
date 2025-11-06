package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/power-grid-maintenance/">Power Grid Maintenance</a>
 * <p>
 * You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).
 * <p>
 * These stations are interconnected via n bidirectional cables, represented by a 2D array connections,
 * where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi.
 * Stations that are directly or indirectly connected form a power grid.
 * <p>
 * Initially, all stations are online (operational).
 * <p>
 * You are also given a 2D array queries, where each query is one of the following two types:
 * <p>
 * [1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself.
 * If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x.
 * If no operational station exists in that grid, return -1.
 * <p>
 * [2, x]: Station x goes offline (i.e., it becomes non-operational).
 * <p>
 * Return an array of integers representing the results of each query of type [1, x] in the order they appear.
 * <p>
 * Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= c <= 10^5</li>
 *  <li>0 <= n == connections.length <= min(10^5, c * (c - 1) / 2)</li>
 *  <li>connections[i].length == 2</li>
 *  <li>1 <= ui, vi <= c</li>
 *  <li>ui != vi</li>
 *  <li>1 <= queries.length <= 2 * 10^5</li>
 *  <li>queries[i].length == 2</li>
 *  <li>queries[i][0] is either 1 or 2.</li>
 *  <li>1 <= queries[i][1] <= c</li>
 * </ul>
 */
public interface PowerGridMaintenance {

    int[] processQueries(int c, int[][] connections, int[][] queries);

    class PowerGridMaintenanceRev1 implements PowerGridMaintenance {

        @Override
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            final var adj = new HashMap<Integer, List<Integer>>();
            for (var connection : connections) {
                adj.computeIfAbsent(connection[0], __ -> new ArrayList<>()).add(connection[1]);
                adj.computeIfAbsent(connection[1], __ -> new ArrayList<>()).add(connection[0]);
            }

            // componentId -> sorted set of online node ids
            final var components = new HashMap<Integer, SortedSet<Integer>>();
            // nodeId -> componentId
            final var nodes = new HashMap<Integer, Integer>();

            var currComponentId = 1;
            final var visited = new boolean[c + 1];
            for (var i = 1; i <= c; i++) {
                if (!visited[i]) {
                    traverse(adj, i, visited, currComponentId++, components, nodes);
                }
            }

            // process queries
            final var ans = new ArrayList<Integer>();
            for (var query : queries) {
                final var componentId = nodes.get(query[1]);
                final var online = components.get(componentId);
                switch (query[0]) {
                    case 1 -> {
                        if (online.isEmpty()) {
                            ans.add(-1);
                        } else {
                            ans.add(online.contains(query[1]) ? query[1] : online.first());
                        }
                    }
                    case 2 -> {
                        if (!online.isEmpty()) {
                            online.remove(query[1]);
                        }
                    }
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private void traverse(
                Map<Integer, List<Integer>> adj,
                int source,
                boolean[] visited,
                int componentId,
                Map<Integer, SortedSet<Integer>> components,
                Map<Integer, Integer> nodes
        ) {
            // BFS
            final var q = new ArrayDeque<Integer>();
            q.offer(source);
            while (!q.isEmpty()) {
                final var curr = q.poll();
                components.computeIfAbsent(componentId, __ -> new TreeSet<>()).add(curr);
                nodes.put(curr, componentId);
                visited[curr] = true;

                for (var neighbor : adj.getOrDefault(curr, List.of())) {
                    if (!visited[neighbor]) {
                        q.offer(neighbor);
                    }
                }
            }
        }
    }
}
