package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*
import kotlin.math.max

/**
 * [Maximum Width of Binary Tree](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/)
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes
 * are also counted into the length calculation.
 */
object MaximumWidthOfBinaryTree {

    private class TreeNodeWithIndex(val node: TreeNode, val index: Int)

    fun widthOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        var result = 1
        val queue: Deque<TreeNodeWithIndex> = LinkedList()
        queue.add(TreeNodeWithIndex(root, 0))
        while (!queue.isEmpty()) {
            val count = queue.size
            val startIndex = queue.first.index
            val endIndex = queue.last.index
            result = max(result, endIndex - startIndex + 1)
            repeat(count) {
                queue.poll().apply {
                    node.left?.also { queue.add(TreeNodeWithIndex(it, 2 * index + 1)) }
                    node.right?.also { queue.add(TreeNodeWithIndex(it, 2 * index + 2)) }
                }
            }
        }
        return result
    }
}