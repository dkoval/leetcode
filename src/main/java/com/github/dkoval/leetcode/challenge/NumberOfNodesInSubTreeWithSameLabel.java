package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/">Number of Nodes in the Sub-Tree With the Same Label</a>
 * <p>
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes
 * numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree
 * has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
 * <p>
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 * <p>
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 * <p>
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>edges.length == n - 1</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>ai != bi</li>
 *  <li>labels.length == n</li>
 *  <li>labels is consisting of only of lowercase English letters.</li>
 * </ul>
 */
public interface NumberOfNodesInSubTreeWithSameLabel {

    int[] countSubTrees(int n, int[][] edges, String labels);

    // O(N) time | O(N) space
    class NumberOfNodesInSubTreeWithSameLabelRev1 implements NumberOfNodesInSubTreeWithSameLabel {

        @Override
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            // convert to adj list
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            int[] ans = new int[n];
            dfs(graph, labels, 0, -1, ans);
            return ans;
        }

        private int[] dfs(List<Integer>[] graph, String labels, int node, int parent, int[] ans) {
            // frequencies of labels ('a' - 'z') found in the subtrees of the current node
            int[] nodeFreq = new int[26];

            // include the current node
            int idx = labels.charAt(node) - 'a';
            nodeFreq[idx] = 1;

            // traverse subtrees of the current node
            for (int child : graph[node]) {
                if (child == parent) {
                    continue;
                }

                // merge frequencies
                int[] childFreq = dfs(graph, labels, child, node, ans);
                for (int i = 0; i < 26; i++) {
                    nodeFreq[i] += childFreq[i];
                }
            }

            // update the global ans
            ans[node] = nodeFreq[idx];
            return nodeFreq;
        }
    }
}
