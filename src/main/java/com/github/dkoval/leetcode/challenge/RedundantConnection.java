package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/redundant-connection/">Redundant Connection</a>
 * <p>
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge
 * between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == edges.length</li>
 *  <li>3 <= n <= 1000</li>
 *  <li>edges[i].length == 2</li>
 *  <li>1 <= ai < bi <= edges.length</li>
 *  <li>ai != bi</li>
 *  <li>There are no repeated edges.</li>
 *  <li>The given graph is connected.</li>
 * </ul>
 */
public interface RedundantConnection {

    int[] findRedundantConnection(int[][] edges);

    class RedundantConnectionUsingUnionFind implements RedundantConnection {

        @Override
        public int[] findRedundantConnection(int[][] edges) {
            final var n = edges.length;

            final var uf = new UnionFind(n + 1);
            for (var edge : edges) {
                if (!uf.union(edge[0], edge[1])) {
                    return edge;
                }
            }
            return new int[0];
        }

        private static class UnionFind {
            // parent[i] denotes the parent of i
            int[] parent;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int a, int b) {
                final var pa = find(a);
                final var pb = find(b);
                if (pa != pb) {
                    parent[pa] = pb;
                    return true;
                }
                return false;
            }
        }
    }

    class RedundantConnectionUsingDFS implements RedundantConnection {

        @Override
        public int[] findRedundantConnection(int[][] edges) {
            final var adj = new HashMap<Integer, Set<Integer>>();
            for (var edge : edges) {
                if (dfs(adj, edge[0], edge[1], new HashSet<>())) {
                    return edge;
                }
                adj.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], key -> new HashSet<>()).add(edge[0]);
            }
            return new int[0];
        }

        private boolean dfs(Map<Integer, Set<Integer>> adj, int curr, int target, Set<Integer> visited) {
            if (curr == target) {
                return true;
            }

            visited.add(curr);
            for (var next : adj.getOrDefault(curr, Set.of())) {
                if (!visited.contains(next) && dfs(adj, next, target, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
