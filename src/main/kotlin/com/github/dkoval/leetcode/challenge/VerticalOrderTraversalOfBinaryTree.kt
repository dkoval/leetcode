package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import kotlin.math.max
import kotlin.math.min

/**
 * [Vertical Order Traversal of a Binary Tree](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3415/)
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 *
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
 * we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 *
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 * Return an list of non-empty reports in order of X coordinate. Every report will have a list of values of nodes.
 */
object VerticalOrderTraversalOfBinaryTree {

    private data class IntHolder(var value: Int)

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        // key: col, value: list of (row, node.value) pairs
        val cache = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        val minCol = IntHolder(0)
        val maxCol = IntHolder(0)
        dfs(root, 0, 0, cache, minCol, maxCol)
        val result = mutableListOf<List<Int>>()
        for (c in minCol.value..maxCol.value) {
            val elements = cache[c]!!
            elements.sortWith(Comparator { (row1, value1), (row2, value2) ->
                if (row1 != row2) row1 - row2 else value1 - value2
            })
            result.add(elements.map { (_, value) -> value })
        }
        return result
    }

    private fun dfs(
        node: TreeNode?,
        row: Int,
        col: Int,
        cache: MutableMap<Int, MutableList<Pair<Int, Int>>>,
        minCol: IntHolder,
        maxCol: IntHolder
    ) {
        if (node == null) return
        cache.getOrPut(col) { mutableListOf() }.add(row to node.`val`)
        minCol.apply { value = min(value, col) }
        maxCol.apply { value = max(value, col) }
        dfs(node.left, row + 1, col - 1, cache, minCol, maxCol)
        dfs(node.right, row + 1, col + 1, cache, minCol, maxCol)
    }
}