package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

object KthSmallestElementInBST {

    fun kthSmallest(root: TreeNode?, k: Int): Int = doKthSmallest(root, k, MutableInt(0))

    // Fact: In-order traversal of a BST returns the node in ascending order.
    // Idea: Keep track of the number of nodes processed so far while traversing the BST in in-order fashion.
    // When the number of nodes processed becomes equal to k, the current node is k-th smallest.
    private fun doKthSmallest(root: TreeNode?, k: Int, i: MutableInt): Int {
        if (root == null) {
            return Int.MAX_VALUE
        }
        // search in the left subtree
        val left = doKthSmallest(root.left, k, i)
        if (left != Int.MAX_VALUE) {
            return left
        }
        // if the current node is k-th, return its node
        if (++i.value == k) {
            return root.`val`
        }
        // search in the right subtree
        return doKthSmallest(root.right, k, i)
    }

    private class MutableInt(var value: Int)
}