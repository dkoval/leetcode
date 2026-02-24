package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

object SumOfRootToLeafBinaryNumbersRev1 : SumOfRootToLeafBinaryNumbers {

    // O(N) time | O(N) space
    override fun sumRootToLeaf(root: TreeNode?): Int = doSumRootToLeaf(root, 0)

    private fun doSumRootToLeaf(root: TreeNode?, num: Int): Int {
        if (root == null) return 0
        val updatedNum = num * 2 + root.`val` // base2 to base10 conversion
        if (root.left == null && root.right == null) {
            // reached a leaf node
            return updatedNum
        }
        return doSumRootToLeaf(root.left, updatedNum) + doSumRootToLeaf(root.right, updatedNum)
    }
}