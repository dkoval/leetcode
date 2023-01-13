package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/longest-path-with-different-adjacent-characters/">Longest Path With Different Adjacent Characters (Hard)</a>
 * <p>
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1.
 * The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
 * <p>
 * You are also given a string s of length n, where s[i] is the character assigned to node i.
 * <p>
 * Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == parent.length == s.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= parent[i] <= n - 1 for all i >= 1</li>
 *  <li>parent[0] == -1</li>
 *  <li>parent represents a valid tree.</li>
 *  <li>s consists of only lowercase English letters.</li>
 * </ul>
 */
public interface LongestPathWithDifferentAdjacentCharacters {

    int longestPath(int[] parent, String s);

    class LongestPathWithDifferentAdjacentCharactersRev1 implements LongestPathWithDifferentAdjacentCharacters {

        @Override
        public int longestPath(int[] parent, String s) {
            int n = parent.length;

            // convert to adj list
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                // node 0 has no parent
                if (parent[i] == -1) {
                    continue;
                }

                // split the tree into forest of trees, where no pair of adjacent nodes have the same character assigned to them
                if (s.charAt(i) == s.charAt(parent[i])) {
                    continue;
                }

                graph[i].add(parent[i]);
                graph[parent[i]].add(i);
            }

            // compute the longest path in O(N) time
            int[] best = {0};
            boolean[] seen = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!seen[i]) {
                    longestPathRootedAt(graph, i, -1, seen, best);
                }
            }
            return best[0];
        }

        private TreeInfo longestPathRootedAt(List<Integer>[] graph, int node, int parent, boolean[] seen, int[] best) {
            seen[node] = true;

            // choose 2 subtrees with the maximum depth, then
            // longest path = depth1 + depth2 + 1
            Queue<Integer> minHeap = new PriorityQueue<>();
            for (int child : graph[node]) {
                // make sure we do not go up the tree
                if (child == parent) {
                    continue;
                }

                TreeInfo info = longestPathRootedAt(graph, child, node, seen, best);
                minHeap.offer(info.depth);

                if (minHeap.size() > 2) {
                    minHeap.poll();
                }
            }

            int depth = 0;
            int longestPath = 0;
            for (int d : minHeap) {
                depth = Math.max(depth, d);
                longestPath += d;
            }

            TreeInfo ans = new TreeInfo(depth + 1, longestPath + 1);
            best[0] = Math.max(best[0], ans.longestPath);
            return ans;
        }

        private static class TreeInfo {
            final int depth;
            final int longestPath;

            TreeInfo(int depth, int longestPath) {
                this.depth = depth;
                this.longestPath = longestPath;
            }
        }
    }
}
