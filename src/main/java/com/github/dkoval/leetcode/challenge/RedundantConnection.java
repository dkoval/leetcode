package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3791/">Redundant Connection</a>
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
 */
public interface RedundantConnection {

    int[] findRedundantConnection(int[][] edges);

    class RedundantConnectionUsingUnionFind implements RedundantConnection {

        private static class UnionFind {
            // parent[i] = p denotes the parent of i
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

            void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                parent[rootX] = rootY;
            }
        }

        @Override
        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                if (uf.find(edge[0] - 1) == uf.find(edge[1] - 1)) {
                    // belong to the same connected component
                    return edge;
                }
                uf.union(edge[0] - 1, edge[1] - 1);
            }
            return new int[0];
        }
    }

    class RedundantConnectionUsingDFS implements RedundantConnection {

        @Override
        public int[] findRedundantConnection(int[][] edges) {
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            for (int[] edge : edges) {
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
            for (int next : adj.getOrDefault(curr, Collections.emptySet())) {
                if (!visited.contains(next) && dfs(adj, next, target, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
