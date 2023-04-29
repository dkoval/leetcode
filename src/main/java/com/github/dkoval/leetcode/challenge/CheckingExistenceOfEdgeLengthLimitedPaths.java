package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/d">Checking Existence of Edge Length Limited Paths</a>
 * <p>
 * An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between
 * nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.
 * <p>
 * Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether
 * there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .
 * <p>
 * Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true
 * if there is a path for queries[j] is true, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= edgeList.length, queries.length <= 10^5</li>
 *  <li>edgeList[i].length == 3</li>
 *  <li>queries[j].length == 3</li>
 *  <li>0 <= ui, vi, pj, qj <= n - 1</li>
 *  <li>ui != vi</li>
 *  <li>pj != qj
 *  <li>1 <= disi, limitj <= 10^9</li>
 *  <li>There may be multiple edges between two nodes.</li>
 * </ul>
 */
public interface CheckingExistenceOfEdgeLengthLimitedPaths {

    boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries);

    class CheckingExistenceOfEdgeLengthLimitedPathsRev1 implements CheckingExistenceOfEdgeLengthLimitedPaths {

        @Override
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            // idea: dynamically connect edges < limit using Union-Find data structure
            int q = queries.length;

            // sort queries by limit while recording the original order of queries
            int[][] queriesWithIndex = new int[q][4];
            for (int i = 0; i < q; i++) {
                queriesWithIndex[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
            }
            Arrays.sort(queriesWithIndex, Comparator.comparingInt(query -> query[2]));

            // process queries
            boolean[] ans = new boolean[q];
            UnionFind uf = new UnionFind(n);

            int i = 0;
            Arrays.sort(edgeList, Comparator.comparingInt(edge -> edge[2]));
            for (int[] query : queriesWithIndex) {
                // dynamically connect edges < limit
                while (i < edgeList.length && edgeList[i][2] < query[2]) {
                    uf.union(edgeList[i][0], edgeList[i][1]);
                    i++;
                }
                ans[query[3]] = uf.find(query[0]) == uf.find(query[1]);
            }
            return ans;
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
