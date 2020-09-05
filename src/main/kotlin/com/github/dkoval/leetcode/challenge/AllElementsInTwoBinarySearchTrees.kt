package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [All Elements in Two Binary Search Trees](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/)
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 */
object AllElementsInTwoBinarySearchTrees {

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()
        result = traverseInorder(root1, result)
        result = traverseInorder(root2, result)
        return result.apply { sort() }
    }

    private fun traverseInorder(root: TreeNode?, result: MutableList<Int>): MutableList<Int> {
        fun doTraverseInorder(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) return
            doTraverseInorder(root.left, result)
            result.add(root.`val`)
            doTraverseInorder(root.right, result)
        }
        return result.also { doTraverseInorder(root, it) }
    }
}