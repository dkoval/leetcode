package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-good-paths/">Number of Good Paths (Hard!!!)</a>
 * <p>
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 * <p>
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node.
 * You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * <p>
 * A good path is a simple path that satisfies the following conditions:
 * <p>
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than or equal to the starting node
 * (i.e. the starting node's value should be the maximum value along the path).
 * Return the number of distinct good paths.
 * <p>
 * Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0.
 * A single node is also considered as a valid path.
 */
public interface NumberOfGoodPaths {

    int numberOfGoodPaths(int[] vals, int[][] edges);

    // Resources:
    // https://www.youtube.com/watch?v=JNvIK9xio0U&
    // https://www.youtube.com/watch?v=rv2GBYQm7xM
    // https://leetcode.com/problems/number-of-good-paths/solutions/2892908/number-of-good-paths/
    class NumberOfGoodPathsRev1 implements NumberOfGoodPaths {

        // O(N*logN) time | O(N) space
        @Override
        public int numberOfGoodPaths(int[] vals, int[][] edges) {
            int n = vals.length;

            // convert to adj list
            List<Integer>[] graph = new List[n];
            // also, maintain val -> index mapping
            Map<Integer, List<Integer>> indices = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                indices.computeIfAbsent(vals[i], __ -> new ArrayList<>()).add(i);
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            // idea: build the answer incrementally
            int ans = 0;
            UnionFind uf = new UnionFind(n);

            // greedy: iterate through `vals` in increasing order
            List<Integer> sortedVals = new ArrayList<>(indices.keySet());
            Collections.sort(sortedVals);
            for (int val : sortedVals) {
                // here, `val` is the value of the starting node;
                List<Integer> nodes = indices.get(val);
                // for each node with value `val`, run union-find to connect adjacent nodes
                for (int u : nodes) {
                    for (int v : graph[u]) {
                        // here vals[u] == val
                        if (vals[v] <= val) {
                            // can add v to the path
                            uf.union(u, v);
                        }
                    }
                }

                // for each disjoint set, how many `val`s does it contain?
                // each disjoint set is identified by its root parent
                Map<Integer, Integer> counts = new HashMap<>();
                // if a disjoint set had k `val`s, the number of good paths we could make is:
                // (note that a single node is also considered as a valid path)
                // 1 + 2 + 3 + ... + k
                // i.e. every new added node with value `val`, creates (count + 1) new paths
                for (int u : nodes) {
                    // root parent
                    int pu = uf.find(u);
                    // `u` is a part of `pu` disjoint set
                    int count = counts.getOrDefault(pu, 0) + 1;
                    counts.put(pu, count);
                    ans += count;
                }
            }
            return ans;
        }

        private static class UnionFind {
            // parent[i] is the parent of i
            final int[] parent;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    // path compression
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            void union(int a, int b) {
                int pa = find(a);
                int pb = find(b);
                parent[pa] = pb;
            }
        }
    }
}
