package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Search in a Binary Search Tree](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3361/)
 *
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value
 * equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 */
object SearchInBST {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? = when {
        root == null -> null
        `val` < root.`val` -> searchBST(root.left, `val`)
        `val` > root.`val` -> searchBST(root.right, `val`)
        else -> root
    }
}