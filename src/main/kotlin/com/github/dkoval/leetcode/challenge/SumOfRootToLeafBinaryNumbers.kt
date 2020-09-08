package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Sum of Root To Leaf Binary Numbers](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/)
 *
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 */
object SumOfRootToLeafBinaryNumbers {

    fun sumRootToLeaf(root: TreeNode?): Int = doSumRootToLeaf(root, 0)

    private fun doSumRootToLeaf(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        val updatedSum = (sum shl 1) + root.`val` // base2 to base10 conversion
        if (root.left == null && root.right == null) {
            // reached a leaf node
            return updatedSum
        }
        return doSumRootToLeaf(root.left, updatedSum) + doSumRootToLeaf(root.right, updatedSum)
    }
}