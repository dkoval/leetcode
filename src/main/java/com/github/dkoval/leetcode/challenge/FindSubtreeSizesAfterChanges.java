package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-subtree-sizes-after-changes/">Find Subtree Sizes After Changes</a>
 * <p>
 * You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1.
 * The tree is represented by an array parent of size n, where parent[i] is the parent of node i.
 * Since node 0 is the root, parent[0] == -1.
 * <p>
 * You are also given a string s of length n, where s[i] is the character assigned to node i.
 * <p>
 * We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:
 * <p>
 * Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
 * <p>
 * If node y does not exist, do nothing.
 * <p>
 * Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.
 * <p>
 * Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == parent.length == s.length</li>
 *  <li>1 <= n <= 105</li>
 *  <li>0 <= parent[i] <= n - 1 for all i >= 1.</li>
 *  <li>parent[0] == -1</li>
 *  <li>parent represents a valid tree.</li>
 *  <li>s consists only of lowercase English letters.</li>
 * </ul>
 */
public interface FindSubtreeSizesAfterChanges {

    int[] findSubtreeSizes(int[] parent, String s);

    class FindSubtreeSizesAfterChangesRev1 implements FindSubtreeSizesAfterChanges {

        @Override
        public int[] findSubtreeSizes(int[] parent, String s) {
            final var n = parent.length;

            var children = childrenOf(parent);
            dfs(parent, s, children, 0, new HashMap<>());

            // rebuild `children` as `parent` got modified
            children = childrenOf(parent);

            final var res = new int[n];
            sizeOfSubtrees(children, 0, res);
            return res;
        }

        private Map<Integer, List<Integer>> childrenOf(int[] parent) {
            final var children = new HashMap<Integer, List<Integer>>();
            for (var i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    children.computeIfAbsent(parent[i], _ -> new ArrayList<>()).add(i);
                }
            }
            return children;
        }

        private void dfs(int[] parent, String s, Map<Integer, List<Integer>> children, int node, Map<Character, Integer> ancestors) {
            final var c = s.charAt(node);

            final var ancestor = ancestors.getOrDefault(c, -1);
            if (ancestor != -1) {
                parent[node] = ancestor;
            }

            // record the current node as the ancestor for future nodes
            ancestors.put(c, node);

            for (var child : children.getOrDefault(node, List.of())) {
                dfs(parent, s, children, child, ancestors);
            }

            // backtrack
            if (ancestor != -1) {
                ancestors.put(c, ancestor);
            } else {
                ancestors.remove(c);
            }
        }

        private int sizeOfSubtrees(Map<Integer, List<Integer>> children, int node, int[] res) {
            var size = 1;
            for (var child : children.getOrDefault(node, List.of())) {
                size += sizeOfSubtrees(children, child, res);
            }
            return res[node] = size;
        }
    }
}
