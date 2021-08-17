package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountGoodNodesInBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(3)
                    }
                    right = TreeNode(4).apply {
                        left = TreeNode(1)
                        right = TreeNode(5)
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(4)
                        right = TreeNode(2)
                    }
                },
                3
            ),
            Arguments.of(
                TreeNode(1),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of good nodes in a binary tree`(root: TreeNode, expected: Int) {
        val actual = CountGoodNodesInBinaryTree().goodNodes(root)
        assertEquals(expected, actual)
    }
}