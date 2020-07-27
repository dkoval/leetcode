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
        val inorderIndex = inorder.asSequence().mapIndexed { index, value -> value to index }.toMap()
        return doBuildTree(inorderIndex, postorder, 0, inorder.size, MutableInt(inorder.lastIndex))
    }

    private class MutableInt(var value: Int)

    private fun doBuildTree(
        inorderIndex: Map<Int, Int>,
        postorder: IntArray,
        startIndexInclusive: Int,
        endIndexExclusive: Int,
        idx: MutableInt
    ): TreeNode? {
        if (startIndexInclusive == endIndexExclusive) return null
        val root = postorder[idx.value]
        val indexOfRoot = inorderIndex[root] ?: return null
        idx.value--
        return TreeNode(root).apply {
            right = doBuildTree(inorderIndex, postorder, indexOfRoot + 1, endIndexExclusive, idx)
            left = doBuildTree(inorderIndex, postorder, startIndexInclusive, indexOfRoot, idx)
        }
    }
}