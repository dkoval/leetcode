package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import kotlin.math.max
import kotlin.math.min

object VerticalOrderTraversalOfBinaryTreeRev1 : VerticalOrderTraversalOfBinaryTree {

    private data class IntHolder(var value: Int)

    override fun verticalTraversal(root: TreeNode): List<List<Int>> {
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