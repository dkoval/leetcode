package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class VerticalOrderTraversalOfBinaryTreeTest {

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
                    listOf(9),
                    listOf(3, 15),
                    listOf(20),
                    listOf(7)
                )
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(4),
                    listOf(2),
                    listOf(1, 5, 6),
                    listOf(3),
                    listOf(7)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the vertical order traversal of its nodes values`(root: TreeNode?, expected: List<List<Int>>) {
        val actual = VerticalOrderTraversalOfBinaryTree.verticalTraversal(root)
        assertEquals(expected, actual)
    }
}