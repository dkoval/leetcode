package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/">Amount of Time for Binary Tree to Be Infected</a>
 * <p>
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 * <p>
 * Each minute, a node becomes infected if:
 * <ul>
 *  <li>The node is currently uninfected.</li>
 *  <li>The node is adjacent to an infected node.</li>
 * </ul>
 * Return the number of minutes needed for the entire tree to be infected.
 */
public interface AmountOfTimeForBinaryTreeToBeInfected {

    int amountOfTime(TreeNode root, int start);

    class AmountOfTimeForBinaryTreeToBeInfectedRev1 implements AmountOfTimeForBinaryTreeToBeInfected {

        @Override
        public int amountOfTime(TreeNode root, int start) {
            Map<Integer, List<Integer>> adj = new HashMap<>();
            traverse(root, null, adj);

            // BFS
            int totalTime = -1;
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(start);
            visited.add(start);
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int curr = q.poll();
                    for (int next : adj.getOrDefault(curr, Collections.emptyList())) {
                        if (!visited.contains(next)) {
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
                totalTime++;
            }
            return totalTime;
        }

        private void traverse(TreeNode curr, TreeNode parent, Map<Integer, List<Integer>> adj) {
            if (curr == null) {
                return;
            }

            if (parent != null) {
                adj.computeIfAbsent(parent.val, __ -> new ArrayList<>()).add(curr.val);
                adj.computeIfAbsent(curr.val, __ -> new ArrayList<>()).add(parent.val);
            }

            traverse(curr.left, curr, adj);
            traverse(curr.right, curr, adj);
        }
    }
}
