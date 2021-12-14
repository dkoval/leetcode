package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RangeSumOfBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3)
                        right = TreeNode(7)
                    }
                    right = TreeNode(15).apply {
                        right = TreeNode(18)
                    }
                },
                7,
                15,
                32
            ),
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(7).apply {
                            left = TreeNode(6)
                        }
                    }
                    right = TreeNode(15).apply {
                        left = TreeNode(13)
                        right = TreeNode(18)
                    }
                },
                6,
                10,
                23
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of values of all nodes with a value in the inclusive range`(
        root: TreeNode,
        low: Int,
        high: Int,
        expected: Int
    ) {
        val actual = RangeSumOfBST().rangeSumBST(root, low, high)
        assertEquals(expected, actual)
    }
}