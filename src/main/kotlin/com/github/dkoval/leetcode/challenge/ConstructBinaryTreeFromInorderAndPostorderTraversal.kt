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
        if (inorder.isEmpty()) return null
        val inorderIndex = inorder.asSequence().withIndex().associate { it.value to it.index }
        return doBuildTree(inorderIndex, 0, inorder.size, postorder, 0, postorder.size)
    }

    private fun doBuildTree(
        inorderIndex: Map<Int, Int>,
        inorderStartIndex: Int,
        inorderEndIndex: Int,
        postorder: IntArray,
        postorderStartIndex: Int,
        postorderEndIndex: Int
    ): TreeNode? {
        if (inorderStartIndex == inorderEndIndex || postorderStartIndex == postorderEndIndex) return null
        val rootValue = postorder[postorderEndIndex - 1]
        val rootIndex = inorderIndex[rootValue] ?: return null
        val offset = rootIndex - inorderStartIndex
        val root = TreeNode(rootValue)
        root.left = doBuildTree(
            inorderIndex,
            inorderStartIndex,
            rootIndex,
            postorder,
            postorderStartIndex,
            postorderStartIndex + offset
        )
        root.right = doBuildTree(
            inorderIndex,
            rootIndex + 1,
            inorderEndIndex,
            postorder,
            postorderStartIndex + offset,
            postorderEndIndex - 1
        )
        return root
    }
}