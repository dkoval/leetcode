package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Count Complete Tree Nodes](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/)
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from [Wikipedia](http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees):
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
 * are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
object CountCompleteTreeNodes {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val lh = depth(root) { it.left }
        val rh = depth(root) { it.right }
        if (lh == rh) {
            return (1 shl lh) - 1 // 2^h - 1
        }
        return 1 + countNodes(root.left) + countNodes(root.right)
    }

    private fun depth(root: TreeNode?, onNext: (TreeNode) -> TreeNode?): Int {
        var height = 0
        var curr = root
        while (curr != null) {
            height++
            curr = onNext(curr)
        }
        return height
    }
}