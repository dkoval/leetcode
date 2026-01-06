package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">Maximum Level Sum of a Binary Tree</a>
 * <p>
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * <p>
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4].</li>
 *  <li>-10^5 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface MaximumLevelSumOfBinaryTree {

    int maxLevelSum(TreeNode root);

    // O(N) time | O(N) space
    class MaximumLevelSumOfBinaryTreeRev1 implements MaximumLevelSumOfBinaryTree {

        @Override
        public int maxLevelSum(TreeNode root) {
            var bestLevel = 1;
            var bestSum = Integer.MIN_VALUE;

            // BFS
            var currLevel = 1;
            final var q = new ArrayDeque<TreeNode>();
            q.offer(root);
            while (!q.isEmpty()) {
                int currSum = 0;
                int size = q.size();
                // process nodes at the current level
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    currSum += node.val;

                    if (node.left != null) {
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }

                if (currSum > bestSum) {
                    bestSum = currSum;
                    bestLevel = currLevel;
                }

                currLevel++;
            }
            return bestLevel;
        }
    }
}
