package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Kth Smallest Element in a BST](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/)
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
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