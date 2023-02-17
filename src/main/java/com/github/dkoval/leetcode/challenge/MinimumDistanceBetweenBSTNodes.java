package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Minimum Distance Between BST Nodes</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 100].</li>
 *  <li>0 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface MinimumDistanceBetweenBSTNodes {

    int minDiffInBST(TreeNode root);

    class MinimumDistanceBetweenBSTNodesUsingInorderTraversal implements MinimumDistanceBetweenBSTNodes {

        @Override
        public int minDiffInBST(TreeNode root) {
            // Idea: inorder traversal of a BST visits nodes in ASC order
            // min diff = min(node.val - prev)
            TreeInfo info = new TreeInfo(-1, Integer.MAX_VALUE);
            inorder(root, info);
            return info.ans;
        }

        private void inorder(TreeNode node, TreeInfo info) {
            if (node == null) {
                return;
            }

            // traverse left subtree
            inorder(node.left, info);

            // update answer
            if (info.prev != -1) {
                info.ans = Math.min(info.ans, node.val - info.prev);
            }

            // traverse right subtree
            info.prev = node.val;
            inorder(node.right, info);
        }

        private static class TreeInfo {
            int prev;
            int ans;

            TreeInfo(int prev, int ans) {
                this.prev = prev;
                this.ans = ans;
            }
        }
    }
}
