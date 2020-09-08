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

    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0
        return doSumRootToLeaf(root, mutableListOf())
    }

    private fun doSumRootToLeaf(root: TreeNode, path: MutableList<Int>): Int {
        path.add(root.`val`)
        if (root.left == null && root.right == null) {
            // reached a leaf node
            return binToBase10(path)
        }
        var sum = 0
        if (root.left != null) {
            sum += doSumRootToLeaf(root.left!!, path)
            path.removeAt(path.lastIndex)
        }
        if (root.right != null) {
            sum += doSumRootToLeaf(root.right!!, path)
            path.removeAt(path.lastIndex)
        }
        return sum
    }

    private fun binToBase10(binNum: List<Int>): Int {
        var num = 0
        for (digit in binNum) {
            num = num * 2 + digit
        }
        return num
    }
}