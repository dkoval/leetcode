package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import kotlin.math.abs

/**
 * [Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value)
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 */
object ClosestBinarySearchTreeValue {

    fun closestValue(root: TreeNode, target: Double): Int = when {
        root.`val` > target && root.left != null -> {
            // search in the left subtree
            val l = closestValue(root.left!!, target)
            if (abs(l - target) < abs(root.`val` - target)) l else root.`val`
        }
        root.`val` < target && root.right != null -> {
            // search in the right subtree
            val r = closestValue(root.right!!, target)
            if (abs(r - target) < abs(root.`val` - target)) r else root.`val`
        }
        else -> root.`val`
    }
}