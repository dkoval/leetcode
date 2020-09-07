package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode

/**
 * [Maximum Depth of Binary Tree](https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/)
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
object MaximumDepthOfBinaryTree {

    // Time complexity: O(N)
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftSubtreeDepth = maxDepth(root.left)
        val rightSubtreeDepth = maxDepth(root.right)
        return maxOf(leftSubtreeDepth, rightSubtreeDepth) + 1
    }
}