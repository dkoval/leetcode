package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PseudoPalindromicPathsInBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(1)
                    }
                },
                2
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(3).apply {
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(1)
                },
                1
            ),
            Arguments.of(
                TreeNode(9),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of pseudo-palindromic paths going from the root node to leaf nodes`(
        root: TreeNode?,
        expected: Int
    ) {
        val actual = PseudoPalindromicPathsInBinaryTree().pseudoPalindromicPaths(root)
        assertEquals(expected, actual)
    }
}