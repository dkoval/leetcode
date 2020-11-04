package com.github.dkoval.leetcode.interview.trees;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum (Hard)</a>
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any node sequence from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = dfs(root.left);
        int rightMaxPathSum = dfs(root.right);

        // side effect: update maxPathSum
        int combinedPathSum = root.val + leftMaxPathSum + rightMaxPathSum;
        result = Math.max(result, combinedPathSum);

        // return the maximum path sum starting from `root` node to its parent (prefer 0 over negative sum)
        return Math.max(0, root.val + Math.max(leftMaxPathSum, rightMaxPathSum));
    }
}
