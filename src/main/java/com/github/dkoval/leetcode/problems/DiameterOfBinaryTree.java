package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 104]</li>
 *  <li>-100 <= Node.val <= 100</li>
 * </ul>
 */
public interface DiameterOfBinaryTree {

    int diameterOfBinaryTree(TreeNode root);

    class DiameterOfBinaryTreeRecursive implements DiameterOfBinaryTree {

        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // d = max(dL, dR, hL + hR)
            // option #1: path doesn't pass through the root node
            int ans = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
            // option #2: path passes through the root node
            return Math.max(ans, height(root.left) + height(root.right));
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    class DiameterOfBinaryTreeRecursiveOptimized implements DiameterOfBinaryTree {

        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            // "... The length of a path between two nodes is represented by the number of edges between them."
            return dfs(root).diameter - 1;
        }

        private TreeInfo dfs(TreeNode root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }

            TreeInfo left = dfs(root.left);
            TreeInfo right = dfs(root.right);

            // option #1: path doesn't pass through the root node
            int diameter = Math.max(left.diameter, right.diameter);
            // option #2: path passes through the root node
            diameter = Math.max(diameter, 1 + left.height + right.height); // longest path through the root

            // now, compute the height of the tree
            int height = 1 + Math.max(left.height, right.height);
            return new TreeInfo(diameter, height);
        }

        private static class TreeInfo {
            // The diameter of the bin tree (in number of nodes)
            final int diameter;
            // The height of the bin tree (in number of nodes)
            final int height;

            TreeInfo(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }
    }
}
