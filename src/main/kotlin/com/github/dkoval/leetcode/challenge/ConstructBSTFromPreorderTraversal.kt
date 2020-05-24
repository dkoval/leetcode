package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Construct BST from Preorder Traversal](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/)
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 */
object ConstructBSTFromPreorderTraversal {

    private class Index(var value: Int)

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
        val key = preorder[index.value]
        if (key < min || key > max) {
            return null
        }

        val root = TreeNode(key)
        index.value++

        // all keys in the left sub-tree of a BST must be less than the key of root node
        root.left = buildBSTFromPreorder(preorder, index, min, key - 1)
        // all keys in the right sub-tree of a BST must be greater than the key of root node
        root.right = buildBSTFromPreorder(preorder, index, key + 1, max)
        return root
    }
}