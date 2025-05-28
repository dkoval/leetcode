package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/">Maximize the Number of Target Nodes After Connecting Trees I</a>
 * <p>
 * There exist two undirected trees with n and m nodes, with distinct labels in ranges [0, n - 1] and [0, m - 1], respectively.
 * <p>
 * You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that
 * there is an edge between nodes ui and vi in the second tree. You are also given an integer k.
 * <p>
 * Node u is target to node v if the number of edges on the path from u to v is less than or equal to k.
 * Note that a node is always target to itself.
 * <p>
 * Return an array of n integers answer, where answer[i] is the maximum possible number of nodes target to node i of
 * the first tree if you have to connect one node from the first tree to another node in the second tree.
 * <p>
 * Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n, m <= 1000</li>
 *  <li>edges1.length == n - 1</li>
 *  <li>edges2.length == m - 1</li>
 *  <li>edges1[i].length == edges2[i].length == 2</li>
 *  <li>edges1[i] = [ai, bi]</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>edges2[i] = [ui, vi]</li>
 *  <li>0 <= ui, vi < m</li>
 *  <li>The input is generated such that edges1 and edges2 represent valid trees.</li>
 *  <li>0 <= k <= 1000</li>
 * </ul>
 */
public interface MaximizeNumberOfTargetNodesAfterConnectingTrees1 {

    int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k);

    class MaximizeNumberOfTargetNodesAfterConnectingTrees1Rev1 implements MaximizeNumberOfTargetNodesAfterConnectingTrees1 {

        @Override
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            final var n = edges1.length + 1;
            final var m = edges2.length + 1;

            final var tree1 = buildTree(edges1);
            final var tree2 = buildTree(edges2);

            var best2 = 0;
            for (var i = 0; i < m; i++) {
                best2 = Math.max(best2, bfs(tree2, i, k - 1));
            }

            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                ans[i] = bfs(tree1, i, k) + best2;
            }
            return ans;
        }

        private Map<Integer, List<Integer>> buildTree(int[][] edges) {
            final var tree = new HashMap<Integer, List<Integer>>();
            for (var edge : edges) {
                tree.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                tree.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }
            return tree;
        }

        // Returns the number of target nodes v on the path from u.
        // u is target to v if the number of edges on the path from u to v is <= k
        private int bfs(Map<Integer, List<Integer>> tree, int u, int k) {
            if (k < 0) {
                return 0;
            }

            final var q = new ArrayDeque<Integer>();
            final var visited = new HashSet<Integer>();
            q.offer(u);
            visited.add(u);

            var count = 1;
            while (!q.isEmpty() && k > 0) {
                var size = q.size();
                while (size-- > 0) {
                    final var curr = q.poll();
                    for (var neighbor : tree.getOrDefault(curr, List.of())) {
                        if (!visited.contains(neighbor)) {
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                k--;
                count += q.size();
            }
            return count;
        }
    }
}
