package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConvertSortedArrayToBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(-10, -3, 0, 5, 9),
                TreeNode(0).apply {
                    left = TreeNode(-10).apply {
                        right = TreeNode(-3)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(9)
                    }
                }
            ),
            Arguments.of(
                intArrayOf(1, 3),
                TreeNode(1).apply {
                    right = TreeNode(3)
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should convert an integer array sorted in ascending order a height-balanced binary search tree`(
        nums: IntArray,
        expected: TreeNode
    ) {
        val actual = ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums)
        assertTrue(expected.equalsTo(actual))
    }
}