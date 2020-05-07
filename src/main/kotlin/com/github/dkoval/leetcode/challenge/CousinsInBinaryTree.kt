package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Cousins in Binary Tree](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/)
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
object CousinsInBinaryTree {

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val xn = findNode(root, x)
        val yn = findNode(root, y)
        return xn != null && yn != null && xn.depth == yn.depth && xn.parent != yn.parent
    }

    private class TreeNodeInfo(
        val parent: TreeNode?,
        val depth: Int
    )

    private fun findNode(root: TreeNode?, value: Int): TreeNodeInfo? {
        if (root == null) {
            return null
        }
        return doFindNode(root, null, 0, value)
    }

    private fun doFindNode(startFrom: TreeNode, parent: TreeNode?, depth: Int, value: Int): TreeNodeInfo? {
        if (startFrom.`val` == value) {
            return TreeNodeInfo(parent, depth)
        }
        val l = startFrom.left?.let { doFindNode(it, startFrom, depth + 1, value) }
        if (l != null) {
            return l
        }
        val r = startFrom.right?.let { doFindNode(it, startFrom, depth + 1, value) }
        if (r != null) {
            return r
        }
        return null
    }
}