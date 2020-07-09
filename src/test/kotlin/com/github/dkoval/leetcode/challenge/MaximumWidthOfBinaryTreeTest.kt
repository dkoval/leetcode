package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumWidthOfBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9)
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                },
                2
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                    }
                    right = TreeNode(2)
                },
                2
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(6)
                        }
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9).apply {
                            right = TreeNode(7)
                        }
                    }
                },
                8
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should calculate the maximum width of a binary tree`(root: TreeNode?, expected: Int) {
        val actual = MaximumWidthOfBinaryTree.widthOfBinaryTree(root)
        assertEquals(expected, actual)
    }
}