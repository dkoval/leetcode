package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

object SumOfLeftLeavesDFS : SumOfLeftLeaves {

    override fun sumOfLeftLeaves(root: TreeNode?): Int = dfs(root, false)

    private fun dfs(root: TreeNode?, isLeftChild: Boolean): Int = when {
        root == null -> 0
        isLeftChild && root.left == null && root.right == null -> root.`val`
        else -> dfs(root.left, true) + dfs(root.right, false)
    }
}