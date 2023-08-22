package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/">Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree (Hard)</a>
 * <p>
 * Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti]
 * represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges
 * that connects all vertices without cycles and with the minimum possible total edge weight.
 * <p>
 * Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST).
 * An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge.
 * On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.
 * <p>
 * Note that you can return the indices of the edges in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 100</li>
 *  <li>1 <= edges.length <= min(200, n * (n - 1) / 2)</li>
 *  <li>edges[i].length == 3</li>
 *  <li>0 <= ai < bi < n</li>
 *  <li>1 <= weighti <= 1000</li>
 * </ul>
 */
public interface FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

    List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges);

    // Resource: https://www.youtube.com/watch?v=pGLdK7cTOnI
    class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeRev1 implements FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

        @Override
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            IndexedEdge[] indexedEdges = new IndexedEdge[edges.length];
            for (int i = 0; i < edges.length; i++) {
                indexedEdges[i] = new IndexedEdge(i, edges[i]);
            }

            // sort edges by weight in ASC order - prerequisite for Kruskal's algorithm
            Arrays.sort(indexedEdges, Comparator.comparingInt(it -> it.edge[2]));

            // calculate MST
            int minTotalWeight = mst(n, indexedEdges, -1, -1);

            // critical and pseudo-critical edges
            List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
            for (int i = 0; i < indexedEdges.length; i++) {
                // exclude the i-th edge to check if it's a critical one
                if (mst(n, indexedEdges, i, -1) > minTotalWeight) {
                    // critical
                    ans.get(0).add(indexedEdges[i].index);
                } else {
                    // otherwise, include the i-th edge to check if it can appear in MST
                    if (mst(n, indexedEdges, -1, i) == minTotalWeight) {
                        // pseudo-critical
                        ans.get(1).add(indexedEdges[i].index);
                    }
                }
            }
            return ans;
        }

        private int mst(int n, IndexedEdge[] edges, int excludeEdge, int includeEdge) {
            UnionFind uf = new UnionFind(n);
            int totalWeight = 0;
            int count = 0;

            if (includeEdge != -1) {
                uf.union(edges[includeEdge].edge[0], edges[includeEdge].edge[1]);
                totalWeight += edges[includeEdge].edge[2];
                count++;
            }

            for (int i = 0; i < edges.length; i++) {
                if (i == excludeEdge) {
                    continue;
                }

                if (uf.union(edges[i].edge[0], edges[i].edge[1])) {
                    totalWeight += edges[i].edge[2];
                    count++;
                }
            }
            return (count == n - 1) ? totalWeight : Integer.MAX_VALUE;
        }

        private static class UnionFind {
            // parent[i] is the parent of i
            final int[] parent;
            final int[] rank;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
                rank = new int[n];
            }

            int find(int x) {
                if (parent[x] != x) {
                    // path compression
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int a, int b) {
                int pa = find(a);
                int pb = find(b);
                if (pa != pb) {
                    parent[pa] = pb;
                    return true;
                }
                return false;
            }
        }

        private static class IndexedEdge {
            final int index;
            final int[] edge; // [a, b, weight]

            IndexedEdge(int index, int[] edge) {
                this.index = index;
                this.edge = edge;
            }
        }
    }
}
