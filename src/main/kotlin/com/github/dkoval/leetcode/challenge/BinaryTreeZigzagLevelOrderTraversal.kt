package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/)
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
object BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        val result = LinkedList<List<Int>>()
        var reverseOrder = false
        while (!queue.isEmpty()) {
            val level = LinkedList<Int>()
            var count = queue.size
            while(count-- > 0) {
                val node = queue.poll()
                if (reverseOrder) {
                    level.addFirst(node.`val`)
                } else {
                    level.add(node.`val`)
                }
                node.left?.also { queue.add(it) }
                node.right?.also { queue.add(it) }
            }
            result.add(level)
            reverseOrder = !reverseOrder
        }
        return result
    }
}