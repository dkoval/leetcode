package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Invert Binary Tree](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/)
 *
 * Invert a binary tree.
 */
object InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right
        root.right = left
        return root
    }
}