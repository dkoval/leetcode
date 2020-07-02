package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Binary Tree Level Order Traversal II](https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/)
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
object BinaryTreeLevelOrderTraversal2 {

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val result = LinkedList<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList<TreeNode>().apply { add(root) }
        var numNodesAtLevel = 1
        while (!queue.isEmpty()) {
            val values = LinkedList<Int>()
            var count = 0
            repeat(numNodesAtLevel) {
                val node = queue.poll()
                values.add(node.`val`)
                node.left?.also {
                    queue.add(it)
                    count++
                }
                node.right?.also {
                    queue.add(it)
                    count++
                }
            }
            if (!values.isEmpty()) {
                result.addFirst(values)
            }
            numNodesAtLevel = count
        }
        return result
    }
}