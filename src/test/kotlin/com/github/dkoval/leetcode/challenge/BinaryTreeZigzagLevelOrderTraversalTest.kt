package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeZigzagLevelOrderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(3),
                    listOf(20, 9),
                    listOf(15, 7)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the zigzag level order traversal of nodes' values of a binary tree`(
        root: TreeNode?,
        expected: List<List<Int>>
    ) {
        val actual = BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root)
        assertEquals(expected, actual)
    }
}