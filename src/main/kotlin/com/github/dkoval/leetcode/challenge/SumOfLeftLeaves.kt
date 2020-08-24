package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Sum of Left Leaves](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/)
 *
 * Find the sum of all left leaves in a given binary tree.
 */
object SumOfLeftLeaves {

    fun sumOfLeftLeaves(root: TreeNode?): Int = doSumOfLeftLeaves(root, false)

    private fun doSumOfLeftLeaves(root: TreeNode?, isLeftChild: Boolean): Int {
        if (root == null) return 0
        if (isLeftChild && root.left == null && root.right == null) return root.`val`
        return doSumOfLeftLeaves(root.left, true) + doSumOfLeftLeaves(root.right, false)
    }
}