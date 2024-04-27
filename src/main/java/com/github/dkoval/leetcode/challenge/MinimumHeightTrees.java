package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 * <p>
 * A tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.
 * <p>
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between the two nodes ai and bi in the tree,
 * you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h.
 * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * <p>
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * <p>
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 2 * 104</li>
 *  <li>edges.length == n - 1</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>ai != bi</li>
 *  <li>All the pairs (ai, bi) are distinct</li>
 *  <li>The given input is guaranteed to be a tree and there will be no repeated edges</li>
 * </ul>
 */
public interface MinimumHeightTrees {

    List<Integer> findMinHeightTrees(int n, int[][] edges);

    class MinimumHeightTreesRev1 implements MinimumHeightTrees {

        @Override
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            // corner case
            if (n == 1) {
                return List.of(0);
            }

            // graph is fully connected, because it has n nodes and (n - 1) edges
            // idea: peel off leaf nodes layer by layer
            Map<Integer, List<Integer>> adj = new HashMap<>();
            int[] indegree = new int[n];
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adj.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);

                indegree[edge[0]]++;
                indegree[edge[1]]++;
            }

            // collect leaf nodes
            Queue<Integer> leaves = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 1) {
                    leaves.offer(i);
                }
            }

            // peel off leaf nodes
            // there can be either 1 or 2 nodes that can be the roots of MHTs
            while (n > 2) {
                int size = leaves.size();
                while (size-- > 0) {
                    int curr = leaves.poll();
                    n--;
                    indegree[curr]--;
                    for (int neighbor : adj.getOrDefault(curr, List.of())) {
                        // removing a leaf node decrements neighbor's indegree
                        if (--indegree[neighbor] == 1) {
                            // a leaf node from the next layer
                            leaves.add(neighbor);
                        }
                    }
                }
            }
            return new ArrayList<>(leaves);
        }
    }
}
