package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*
import kotlin.math.max

object MaximumWidthOfBinaryTreeKt : MaximumWidthOfBinaryTree {

    private class TreeNodeWithIndex(val node: TreeNode, val index: Int)

    override fun widthOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        var result = 1
        val queue: Deque<TreeNodeWithIndex> = LinkedList()
        queue.add(TreeNodeWithIndex(root, 0))
        while (!queue.isEmpty()) {
            val startIndex = queue.first.index
            val endIndex = queue.last.index
            result = max(result, endIndex - startIndex + 1)
            repeat(queue.size) {
                queue.poll().apply {
                    node.left?.also { queue.add(TreeNodeWithIndex(it, 2 * index + 1)) }
                    node.right?.also { queue.add(TreeNodeWithIndex(it, 2 * index + 2)) }
                }
            }
        }
        return result
    }
}