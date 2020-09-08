package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeLevelOrderTraversalTest {

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
                    listOf(9, 20),
                    listOf(15, 7)
                )
            ),
            Arguments.of(
                TreeNode(1),
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                null,
                listOf<List<Int>>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the level order traversal of a binary tree node's value`(
        root: TreeNode?,
        expected: List<List<Int>>
    ) {
        val actual = BinaryTreeLevelOrderTraversal.levelOrder(root)
        assertEquals(expected, actual)
    }
}