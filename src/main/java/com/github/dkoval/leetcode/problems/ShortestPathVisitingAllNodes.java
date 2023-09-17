package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/shortest-path-visiting-all-nodes/">Shortest Path Visiting All Nodes (Hard)</a>
 * <p>
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i]
 * is a list of all the nodes connected with node i by an edge.
 * <p>
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit
 * nodes multiple times, and you may reuse edges.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == graph.length</li>
 *  <li>1 <= n <= 12</li>
 *  <li>0 <= graph[i].length < n</li>
 *  <li>graph[i] does not contain i</li>
 *  <li>If graph[a] contains b, then graph[b] contains a</li>
 *  <li>The input graph is always connected</li>
 * </ul>
 */
public interface ShortestPathVisitingAllNodes {

    int shortestPathLength(int[][] graph);

    class ShortestPathVisitingAllNodesUsingBFSAndBitmask implements ShortestPathVisitingAllNodes {

        private static class Node {
            final int id;
            final int path;

            Node (int id, int path) {
                this.id = id;
                this.path = path;
            }
        }

        @Override
        public int shortestPathLength(int[][] graph) {
            // Idea:
            // - start multi-BFS from all nodes at the same time
            // - use a bitmask to represent a path, where the i-th bit set to 1 means that the i-th node was visited
            // - bitmask 11...1 means that all nodes were visited
            int n = graph.length;

            // corner case
            if (graph[0].length == 0) {
                return 0;
            }

            // 2^n - 1 -> 11...1 n 1's in binary representation
            int target = (1 << n) - 1;

            // paths[i] - records all paths starting at node i
            Set<Integer>[] paths = new HashSet[n];
            Queue<Node> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int path = 1 << i;
                paths[i] = new HashSet<>();
                paths[i].add(path);
                q.offer(new Node(i, path));
            }

            int length = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    Node curr = q.poll();
                    for (int neighbor : graph[curr.id]) {
                        int path = curr.path | (1 << neighbor);

                        if (paths[neighbor].contains(path)) {
                            continue;
                        }

                        if (path == target) {
                            return length + 1;
                        }

                        paths[neighbor].add(path);
                        q.offer(new Node(neighbor, path));
                    }
                }
                length++;
            }
            return -1;
        }
    }
}
