package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeTiltTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                1
            ),
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(5)
                    }
                    right = TreeNode(9).apply {
                        right = TreeNode(7)
                    }
                },
                15
            ),
            Arguments.of(
                TreeNode(21).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(1).apply {
                            left = TreeNode(3)
                            right = TreeNode(3)
                        }
                        right = TreeNode(1)
                    }
                    right = TreeNode(14).apply {
                        left = TreeNode(2)
                        right = TreeNode(2)
                    }
                },
                9
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of every tree node's tilt`(root: TreeNode?, expected: Int) {
        val actual = BinaryTreeTilt().findTilt(root)
        assertEquals(expected, actual)
    }
}