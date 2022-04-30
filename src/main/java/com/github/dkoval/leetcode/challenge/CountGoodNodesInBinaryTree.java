package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3899/">Count Good Nodes in Binary Tree</a>
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
public class CountGoodNodesInBinaryTree {

    // O(N) time, where N is the number of nodes in a binary tree | O(H) space, where H is the height of a binary tree
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int currPathMax) {
        // DFS
        if (root == null) {
            return 0;
        }

        int x = (root.val >= currPathMax) ? 1 : 0;
        currPathMax = Math.max(currPathMax, root.val);
        return x + goodNodes(root.left, currPathMax) + goodNodes(root.right, currPathMax);
    }
}
