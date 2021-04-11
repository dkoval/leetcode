package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DeepestLeavesSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(7)
                        }
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(6).apply {
                            right = TreeNode(8)
                        }
                    }
                },
                15
            ),
            Arguments.of(
                TreeNode(6).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(9)
                        }
                        right = TreeNode(7).apply {
                            left = TreeNode(1)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(1)
                        right = TreeNode(3).apply {
                            right = TreeNode(5)
                        }
                    }
                },
                19
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of values of its deepest leaves`(root: TreeNode, expected: Int) {
        val actual = DeepestLeavesSum().deepestLeavesSum(root)
        assertEquals(expected, actual)
    }
}