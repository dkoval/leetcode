package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-center-of-star-graph/">Find Center of Star Graph</a>
 * <p>
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where
 * there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * <p>
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge
 * between the nodes ui and vi. Return the center of the given star graph.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 10^5</li>
 *  <li>edges.length == n - 1</li>
 *  <li>edges[i].length == 2</li>
 *  <li>1 <= ui, vi <= n</li>
 *  <li>ui != vi</li>
 *  <li>The given edges represent a valid star graph</li>
 * </ul>
 */
public interface FindCenterOfStarGraph {

    int findCenter(int[][] edges);

    class FindCenterOfStarGraphRev1 implements FindCenterOfStarGraph {

        @Override
        public int findCenter(int[][] edges) {
            int n = edges.length;

            int[] counts = new int[n + 1];
            for (int[] edge : edges) {
                for (int i = 0; i < 2; i++) {
                    if (++counts[edge[i] - 1] == n) {
                        return edge[i];
                    }
                }
            }
            return -1;
        }
    }

    class FindCenterOfStarGraphRev2 implements FindCenterOfStarGraph {

        @Override
        public int findCenter(int[][] edges) {
            // Any two edges must have a common node, which is the center.
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (seen.contains(edges[i][j])) {
                        return edges[i][j];
                    }
                    seen.add(edges[i][j]);
                }
            }
            return -1;
        }
    }
}
