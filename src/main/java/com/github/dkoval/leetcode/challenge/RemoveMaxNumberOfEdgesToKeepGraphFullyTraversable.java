package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/">Remove Max Number of Edges to Keep Graph Fully Traversable</a>
 * <p>
 * Alice and Bob have an undirected graph of n nodes and three types of edges:
 * <ul>
 *  <li>Type 1: Can be traversed by Alice only.</li>
 *  <li>Type 2: Can be traversed by Bob only.</li>
 *  <li>Type 3: Can be traversed by both Alice and Bob.</li>
 * </ul>
 * Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi,
 * find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob.
 * The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
 * <p>
 * Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)</li>
 *  <li>edges[i].length == 3</li>
 *  <li>1 <= typei <= 3</li>
 *  <li>1 <= ui < vi <= n</li>
 *  <li>All tuples (typei, ui, vi) are distinct.</li>
 * </ul>
 */
public interface RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    int maxNumEdgesToRemove(int n, int[][] edges);

    class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableRev1 implements RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

        @Override
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            // Rephrase: what is the min number of edges you can keep
            // to make the graph full traversable for Alice and Bob?
            // Then, the answer = total number of edges - min number of edges to keep.
            UnionFind alice = new UnionFind(n + 1);
            UnionFind bob = new UnionFind(n + 1);
            int keep = 0;

            // greedy - use as many type = 3 edges as possible (those edges can be used by both Alice and Bob)
            for (int[] edge : edges) {
                if (edge[0] == 3) {
                    if (alice.find(edge[1]) != alice.find(edge[2])) {
                        alice.union(edge[1], edge[2]);
                        bob.union(edge[1], edge[2]);
                        keep++;
                    }
                }
            }

            for (int[] edge : edges) {
                // keep edges that only Alice can use
                if (edge[0] == 1) {
                    if (alice.find(edge[1]) != alice.find(edge[2])) {
                        alice.union(edge[1], edge[2]);
                        keep++;
                    }
                }

                // keep edges that only Bob can use
                if (edge[0] == 2) {
                    if (bob.find(edge[1]) != bob.find(edge[2])) {
                        bob.union(edge[1], edge[2]);
                        keep++;
                    }
                }
            }

            // check if the graph is fully traversable by Alice and Bob
            for (int i = 1; i <= n; i++) {
                // everything must go through the same root
                if (alice.find(i) != alice.find(1)) {
                    return -1;
                }

                if (bob.find(i) != bob.find(1)) {
                    return -1;
                }
            }
            return edges.length - keep;
        }

        private static class UnionFind {
            final int[] parent;

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
                int px = find(x);
                int py = find(y);
                parent[px] = py;
            }
        }
    }
}
