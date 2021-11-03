package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Sum Root to Leaf Numbers](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/)
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
object SumRootToLeafNumbers {

    fun sumNumbers(root: TreeNode?): Int = doSumNumbers(root, 0)

    private fun doSumNumbers(root: TreeNode?, x: Int): Int {
        if (root == null) {
            return 0
        }
        val y = x * 10 + root.`val`
        if (root.left == null && root.right == null) {
            return y
        }
        return doSumNumbers(root.left, y) + doSumNumbers(root.right, y)
    }
}