package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/">Divide Nodes Into the Maximum Number of Groups (Hard)</a>
 * <p>
 * You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.
 * <p>
 * You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi.
 * Notice that the given graph may be disconnected.
 * <p>
 * Divide the nodes of the graph into m groups (1-indexed) such that:
 * <ul>
 *  <li>Each node in the graph belongs to exactly one group.</li>
 *  <li>For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x,
 *  and bi belongs to the group with index y, then |y - x| = 1.
 *  </li>
 * </ul>
 * Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 500</li>
 *  <li>1 <= edges.length <= 104</li>
 *  <li>edges[i].length == 2</li>
 *  <li>1 <= ai, bi <= n</li>
 *  <li>ai != bi</li>
 *  <li>There is at most one edge between any pair of vertices.</li>
 * </ul>
 */
public interface DivideNodesIntoMaximumNumberOfGroups {

    int magnificentSets(int n, int[][] edges);

    class DivideNodesIntoMaximumNumberOfGroupsRev1 implements DivideNodesIntoMaximumNumberOfGroups {

        @Override
        public int magnificentSets(int n, int[][] edges) {
            final var adj = new HashMap<Integer, List<Integer>>();
            for (var edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }

            var total = 0;
            final var visited = new boolean[n + 1];
            for (var i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                // brute force: to maximize the number of groups, run BFS from every node of a connected component
                var component = getConnectedComponent(adj, i, visited);

                var numGroups = 0;
                for (var u : component) {
                    var length = getLongestPathLength(adj, u);
                    if (length < 0) {
                        return -1;
                    }
                    numGroups = Math.max(numGroups, length + 1);
                }
                total += numGroups;
            }
            return total;
        }

        private Set<Integer> getConnectedComponent(Map<Integer, List<Integer>> adj, int src, boolean[] visited) {
            // BFS
            final var q = new ArrayDeque<Integer>();
            final var component = new HashSet<Integer>();

            q.offer(src);
            visited[src] = true;
            component.add(src);
            while (!q.isEmpty()) {
                var curr = q.poll();
                for (var next : adj.getOrDefault(curr, List.of())) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                        component.add(next);
                    }
                }
            }
            return component;
        }

        private int getLongestPathLength(Map<Integer, List<Integer>> adj, int src) {
            // BFS
            final var q = new ArrayDeque<Node>();
            final var dist = new HashMap<Integer, Integer>();

            q.offer(new Node(src, 0));
            dist.put(src, 0);
            var maxPathLength = 0;
            while (!q.isEmpty()) {
                var curr = q.poll();
                for (var next : adj.getOrDefault(curr.id, List.of())) {
                    if (dist.containsKey(next)) {
                        if (dist.get(next) == curr.pathLength) {
                            return -1;
                        }
                        continue;
                    }

                    q.offer(new Node(next, curr.pathLength + 1));
                    dist.put(next, curr.pathLength + 1);
                    maxPathLength = Math.max(maxPathLength, curr.pathLength + 1);
                }
            }
            return maxPathLength;
        }

        private record Node(int id, int pathLength) {
        }
    }
}
