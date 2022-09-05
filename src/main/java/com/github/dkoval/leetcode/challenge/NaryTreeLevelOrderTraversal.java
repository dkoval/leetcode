package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree Level Order Traversal</a>
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The height of the n-ary tree is less than or equal to 1000</li>
 *  <li>The total number of nodes is between [0, 10^4]</li>
 * </ul>
 */
public class NaryTreeLevelOrderTraversal {

    public static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
    }

    // O(N) time | O(N) space, where N is the total number of nodes in a n-ary tree
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                Node node = q.poll();
                level.add(node.val);
                for (Node child : node.children) {
                    q.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
