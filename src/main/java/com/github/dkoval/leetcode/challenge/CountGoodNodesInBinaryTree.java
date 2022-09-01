package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">Count Good Nodes in Binary Tree</a>
 * <p>
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the binary tree is in the range [1, 10^5].</li>
 *  <li>Each node's value is between [-10^4, 10^4].</li>
 * </ul>
 */
public interface CountGoodNodesInBinaryTree {

    int goodNodes(TreeNode root);

    // O(N) time, where N is the number of nodes in a binary tree | O(H) space, where H is the height of a binary tree
    class CountGoodNodesInBinaryTreeRev1 implements CountGoodNodesInBinaryTree {

        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }

        private int dfs(TreeNode root, int currPathMax) {
            // DFS
            if (root == null) {
                return 0;
            }

            int count = 0;
            if (root.val >= currPathMax) {
                count++;
            }

            currPathMax = Math.max(currPathMax, root.val);
            count += dfs(root.left, currPathMax);
            count += dfs(root.right, currPathMax);
            return count;
        }
    }
}
