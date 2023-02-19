package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Constraints:
 *
 * - The number of nodes in the tree is in the range ```[0, 2000]```.
 * - -100 <= Node.val <= 100
 */
object BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val ans = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = ArrayDeque()
        queue.offer(root)
        var odd = true
        while (!queue.isEmpty()) {
            val level = LinkedList<Int>()
            var count = queue.size
            while (count-- > 0) {
                val node = queue.poll()
                if (odd) {
                    level.addLast(node.`val`)
                } else {
                    level.addFirst(node.`val`)
                }
                node.left?.also { queue.add(it) }
                node.right?.also { queue.add(it) }
            }
            ans.add(level)
            odd = !odd
        }
        return ans
    }
}