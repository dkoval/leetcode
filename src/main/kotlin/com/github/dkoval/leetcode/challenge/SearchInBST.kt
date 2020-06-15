package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

object SearchInBST {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? = when {
        root == null -> null
        `val` < root.`val` -> searchBST(root.left, `val`)
        `val` > root.`val` -> searchBST(root.right, `val`)
        else -> root
    }
}