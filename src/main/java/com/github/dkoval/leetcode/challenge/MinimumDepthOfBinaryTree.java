package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 10^5].</li>
 *  <li>-1000 <= Node.val <= 1000</li>
 * </ul>
 */
public interface MinimumDepthOfBinaryTree {

    int minDepth(TreeNode root);

    class MinimumDepthOfBinaryTreeDFS implements MinimumDepthOfBinaryTree {

        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            // base case: reached a leaf node
            if (root.left == null && root.right == null) {
                return 1;
            }

            int minDepth = Integer.MAX_VALUE;
            if (root.left != null) {
                minDepth = Math.min(minDepth, minDepth(root.left));
            }

            if (root.right != null) {
                minDepth = Math.min(minDepth, minDepth(root.right));
            }
            return 1 + minDepth;
        }
    }

    class MinimumDepthOfBinaryTreeBFS implements MinimumDepthOfBinaryTree {

        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // BFS
            int depth = 1;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (curr.left == null && curr.right == null) {
                        return depth;
                    }

                    if (curr.left != null) {
                        q.offer(curr.left);
                    }

                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
}
