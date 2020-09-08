package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode

/**
 * [Convert Sorted Array to Binary Search Tree](https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/631/)
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differs by more than 1.
 */
object ConvertSortedArrayToBinarySearchTree {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return doSortedArrayToBST(nums, 0, nums.lastIndex)
    }

    private fun doSortedArrayToBST(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
        if (startIndex > endIndex) return null
        val midIndex = startIndex + (endIndex - startIndex) / 2
        val curr = TreeNode(nums[midIndex])
        curr.left = doSortedArrayToBST(nums, startIndex, midIndex - 1)
        curr.right = doSortedArrayToBST(nums, midIndex + 1, endIndex)
        return curr
    }
}