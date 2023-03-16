package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        // postorder.length == inorder.length
        val n = inorder.size
        // inorder[i] -> i
        val inorderIndices = inorder.withIndex().associate { it.value to it.index }
        return buildTree(inorderIndices, 0, n - 1, postorder, 0, n - 1)
    }

    private fun buildTree(
        inorder: Map<Int, Int>, inStart: Int, inEnd: Int,
        postOrder: IntArray, postStart: Int, postEnd: Int
    ): TreeNode? {
        // base case
        if (inStart > inEnd || postStart > postEnd) {
            return null
        }

        // lookup index of the current root in inorder[]
        val inRoot = inorder[postOrder[postEnd]]!!
        val numLeftNodes = inRoot - inStart

        val root = TreeNode(postOrder[postEnd])
        root.left = buildTree(inorder, inStart, inRoot - 1, postOrder, postStart, postStart + numLeftNodes - 1)
        root.right = buildTree(inorder, inRoot + 1, inEnd, postOrder, postStart + numLeftNodes, postEnd - 1)
        return root
    }
}