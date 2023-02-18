package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

object InvertBinaryTreeRecursive : InvertBinaryTree {

    // O(N) time | O(H) space
    // N - the number of nodes in the tree
    // H - height of the tree (H == N in the worst case)
    override fun invertTree(root: TreeNode?): TreeNode? {
        // base case
        if (root == null) {
            return null
        }

        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)
        return root
    }
}