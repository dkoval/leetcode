package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Construct BST from Preorder Traversal](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/)
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 */
object ConstructBSTFromPreorderTraversal {

    fun bstFromPreorder(preorder: IntArray): TreeNode? =
        buildBSTFromPreorder(preorder, Index(0), Int.MIN_VALUE, Int.MAX_VALUE)

    private fun buildBSTFromPreorder(
        preorder: IntArray,
        index: Index,
        min: Int,
        max: Int
    ): TreeNode? {
        // base case
        if (index.value == preorder.size) {
            return null
        }

        // check if the next element of preorder traversal is in [min; max] range
        val value = preorder[index.value]
        if (value < min || value > max) {
            return null
        }

        val root = TreeNode(value)
        index.value++

        // all values in the left sub-tree of a BST must be less than the value of root node
        root.left = buildBSTFromPreorder(preorder, index, min, value - 1)
        // all values in the right sub-tree of a BST must be greater than the value of root node
        root.right = buildBSTFromPreorder(preorder, index, value + 1, max)
        return root
    }

    private class Index(var value: Int)
}