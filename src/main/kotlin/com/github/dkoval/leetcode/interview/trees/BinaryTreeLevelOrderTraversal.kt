package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Binary Tree Level Order Traversal](https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/628/)
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
object BinaryTreeLevelOrderTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        val result = mutableListOf<List<Int>>()
        while (!q.isEmpty()) {
            val count = q.size
            val level = mutableListOf<Int>()
            repeat(count) {
                val node = q.poll()
                level.add(node.`val`)
                node.left?.also { q.add(it) }
                node.right?.also { q.add(it) }
            }
            result.add(level)
        }
        return result
    }
}