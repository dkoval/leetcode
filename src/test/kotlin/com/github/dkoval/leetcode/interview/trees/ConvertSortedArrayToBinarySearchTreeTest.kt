package com.github.dkoval.leetcode.interview.trees

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
                intArrayOf(),
                null
            ),
            Arguments.of(
                intArrayOf(1),
                TreeNode(1)
            ),
            Arguments.of(
                intArrayOf(1, 2),
                TreeNode(1).apply {
                    right = TreeNode(2)
                }
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3).apply {
                        right = TreeNode(4)
                    }
                }
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        right = TreeNode(2)
                    }
                    right = TreeNode(4).apply {
                        right = TreeNode(5)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should convert a sorted array to a height balanced BST`(nums: IntArray, expected: TreeNode?) {
        val actual = ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(nums)
        assertTrue(expected.equalsTo(actual))
    }
}