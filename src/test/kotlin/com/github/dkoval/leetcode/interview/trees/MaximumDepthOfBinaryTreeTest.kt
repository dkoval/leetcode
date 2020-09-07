package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumDepthOfBinaryTreeTest {

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
                3
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15).apply {
                            left = TreeNode(42)
                        }
                        right = TreeNode(7)
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7).apply {
                            right = TreeNode(42)
                        }
                    }
                },
                4
            ),
            Arguments.of(
                TreeNode(1),
                1
            ),
            Arguments.of(
                null,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum depth of a binary tree`(root: TreeNode?, expected: Int) {
        val actual = MaximumDepthOfBinaryTree.maxDepth(root)
        assertEquals(expected, actual)
    }
}