package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/">Number of Ways to Assign Edge Weights I</a>
 * <p>
 * There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1,
 * where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.
 * <p>
 * Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.
 * <p>
 * The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.
 * <p>
 * Select any one node x at the maximum depth. Return the number of ways to assign edge weights in the path from node 1 to x such that its total cost is odd.
 * <p>
 * Since the answer may be large, return it modulo 10^9 + 7.
 * <p>
 * Note: Ignore all edges not in the path from node 1 to x.
 */
public interface NumberOfWaysToAssignEdgeWeights1 {

    int MOD = 1_000_000_007;

    int assignEdgeWeights(int[][] edges);

    class NumberOfWaysToAssignEdgeWeights1Rev1 implements NumberOfWaysToAssignEdgeWeights1 {

        @Override
        public int assignEdgeWeights(int[][] edges) {
            final var adj = new HashMap<Integer, List<Integer>>();
            for (var edge : edges) {
                adj.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], _ -> new ArrayList<>()).add(edge[0]);
            }

            final var d = maxDepth(adj);
            // (2 ^ d) / 2 = 2 ^ (d - 1)
            return quickPow2(d - 1);
        }

        private int maxDepth(Map<Integer, List<Integer>> adj) {
            final var q = new ArrayDeque<Integer>();
            final var visited = new HashSet<Integer>();
            q.offer(1);
            visited.add(1);
            var res = -1;
            while (!q.isEmpty()) {
                var size = q.size();
                while (size-- > 0) {
                    final var curr = q.poll();
                    for (var neighbor : adj.getOrDefault(curr, List.of())) {
                        if (!visited.contains(neighbor)) {
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                res++;
            }
            return res;
        }

        private int quickPow2(int n) {
            var res = 1L;
            var base = 2L;
            while (n > 0) {
                if (n % 2 == 1) {
                    res *= base;
                    res %= MOD;
                }
                base *= base;
                base %= MOD;
                n /= 2;
            }
            return (int) res;
        }
    }
}
