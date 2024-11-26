package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-champion-ii/">Find Champion II</a>
 * <p>
 * There are n teams numbered from 0 to n - 1 in a tournament; each team is also a node in a DAG.
 * <p>
 * You are given the integer n and a 0-indexed 2D integer array edges of length m representing the DAG,
 * where edges[i] = [ui, vi] indicates that there is a directed edge from team ui to team vi in the graph.
 * <p>
 * A directed edge from a to b in the graph means that team a is stronger than team b and team b is weaker than team a.
 * <p>
 * Team a will be the champion of the tournament if there is no team b that is stronger than team a.
 * <p>
 * Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return -1.
 * <p>
 * Notes
 * <p>
 * A cycle is a series of nodes a1, a2, ..., an, an+1 such that node a1 is the same node as node an+1,
 * the nodes a1, a2, ..., an are distinct, and there is a directed edge from the node ai to node ai+1 for every i in the range [1, n].
 * A DAG is a directed graph that does not have any cycle.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>m == edges.length</li>
 *  <li>0 <= m <= n * (n - 1) / 2</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= edge[i][j] <= n - 1</li>
 *  <li>edges[i][0] != edges[i][1]</li>
 *  <li>The input is generated such that if team a is stronger than team b, team b is not stronger than team a.</li>
 *  <li>The input is generated such that if team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.</li>
 * </ul>
 */
public interface FindChampion2 {

    int findChampion(int n, int[][] edges);

    class FindChampion2Rev1 implements FindChampion2 {

        @Override
        public int findChampion(int n, int[][] edges) {
            // Idea: count incoming edges
            int[] incoming = new int[n];
            for (int[] edge : edges) {
                incoming[edge[1]]++;
            }

            int champion = -1;
            for (int i = 0; i < n; i++) {
                if (incoming[i] == 0) {
                    // check if champion is unique
                    if (champion != -1) {
                        return -1;
                    }
                    champion = i;
                }
            }
            return champion;
        }
    }
}
