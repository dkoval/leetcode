package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeLevelOrderTraversal2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                null,
                emptyList<List<Int>>()
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(
                    listOf(15, 7),
                    listOf(9, 20),
                    listOf(3)
                )
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(4).apply {
                                left = TreeNode(5)
                            }
                        }
                    }
                },
                listOf(
                    listOf(5),
                    listOf(4),
                    listOf(3),
                    listOf(2),
                    listOf(1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the bottom-up level order traversal`(root: TreeNode?, expected: List<List<Int>>) {
        val actual = BinaryTreeLevelOrderTraversal2.levelOrderBottom(root)
        assertEquals(expected, actual)
    }
}