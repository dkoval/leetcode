package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/)
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        // postorder.length == inorder.length
        val n = inorder.size
        val inorderIndices = inorder.asSequence().withIndex().associate { it.value to it.index }
        return doBuildTree(inorderIndices, 0, n - 1, postorder, 0, n - 1)
    }

    private fun doBuildTree(
        inorderIndices: Map<Int, Int>, inorderStart: Int, inorderEnd: Int,
        postorder: IntArray, postorderStart: Int, postorderEnd: Int
    ): TreeNode? {
        // base case
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null
        }

        val rootValue = postorder[postorderEnd]
        // lookup index of the current root in inorder[]
        val inorderRootIdx = inorderIndices[rootValue] ?: return null
        // in essence, offset = number of nodes in the left sub-tree
        val offset = inorderRootIdx - inorderStart

        val root = TreeNode(rootValue)

        root.left = doBuildTree(
            inorderIndices, inorderStart, inorderRootIdx - 1,
            postorder, postorderStart, postorderStart + offset - 1
        )

        root.right = doBuildTree(
            inorderIndices, inorderRootIdx + 1, inorderEnd,
            postorder, postorderStart + offset, postorderEnd - 1
        )

        return root
    }
}