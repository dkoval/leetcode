package com.github.dkoval.leetcode.challenge;

import java.util.*;

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

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
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
            result.add(level);
        }

        return result;
    }
}
