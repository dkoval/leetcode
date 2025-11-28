package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-k-divisible-components/">Maximum Number of K-Divisible Components (Hard)</a>
 * <p>
 * There is an undirected tree with n nodes labeled from 0 to n - 1.
 * You are given the integer n and a 2D integer array edges of length n - 1,
 * where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 * <p>
 * You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node,
 * and an integer k.
 * <p>
 * A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that
 * the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.
 * <p>
 * Return the maximum number of components in any valid split.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 3 * 10^4</li>
 *  <li>edges.length == n - 1</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>values.length == n</li>
 *  <li>0 <= values[i] <= 10^9</li>
 *  <li>1 <= k <= 10^9</li>
 *  <li>Sum of values is divisible by k.</li>
 *  <li>The input is generated such that edges represents a valid tree.</li>
 * </ul>
 */
public interface MaximumNumberOfKDivisibleComponents {

    int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k);

    class MaximumNumberOfKDivisibleComponentsRev1 implements MaximumNumberOfKDivisibleComponents {

        @Override
        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            final var adj = new HashMap<Integer, List<Integer>>();
            for (var edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }

            // idea: if a is divisible by k, and b is divisible by k, then
            // (a + b) is also divisible by k
            final var count = new int[]{0};
            traverse(adj, values, 0, -1, sumOfValues -> count[0] += (sumOfValues % k == 0) ? 1 : 0);
            // adding 1 to the total count because 0 is always divisible by k
            return count[0] + 1;
        }

        // returns the sum of the values of the nodes in a component with the root at "node"
        private long traverse(Map<Integer, List<Integer>> adj, int[] values, int node, int parent, Consumer<Long> listener) {
            // the "parent" parameter is used here to prevent going backwards
            var total = 0L;
            total += values[node];
            for (var neighbor : adj.getOrDefault(node, List.of())) {
                if (neighbor != parent) {
                    final var sumOfValues = traverse(adj, values, neighbor, node, listener);
                    listener.accept(sumOfValues);
                    total += sumOfValues;
                }
            }
            return total;
        }
    }
}
