package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeMaximumPathSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                6
            ),
            Arguments.of(
                TreeNode(-10).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                42
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `find the maximum path sum`(root: TreeNode, expected: Int) {
        val actual = BinaryTreeMaximumPathSum().maxPathSum(root);
        assertEquals(expected, actual)
    }
}