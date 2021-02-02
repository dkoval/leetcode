package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TrimBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(2)
                },
                1,
                2,
                TreeNode(1).apply {
                    right = TreeNode(2)
                }
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(0).apply {
                        right = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                    }
                    right = TreeNode(4)
                },
                1,
                3,
                TreeNode(3).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1),
                1,
                2,
                TreeNode(1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should trim a BST`(root: TreeNode, low: Int, high: Int, expected: TreeNode) {
        val actual = TrimBST().trimBST(root, low, high)
        assertTrue(actual.equalsTo(expected))
    }
}