package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumProductOfSplittedBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                    }
                },
                110
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(4).apply {
                            left = TreeNode(5)
                            right = TreeNode(6)
                        }
                    }
                },
                90
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(1)
                },
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum product of the sums of the two subtrees`(root: TreeNode?, expected: Int) {
        val actual = MaximumProductOfSplittedBinaryTree().maxProduct(root)
        assertEquals(expected, actual)
    }
}