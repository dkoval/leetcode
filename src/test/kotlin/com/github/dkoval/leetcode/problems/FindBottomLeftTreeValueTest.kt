package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindBottomLeftTreeValueTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(7)
                        }
                        right = TreeNode(6)
                    }
                },
                7
            ),
            Arguments.of(
                TreeNode(0),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the leftmost value in the last row of the tree`(root: TreeNode, expected: Int) {
        val actual = FindBottomLeftTreeValue().findBottomLeftValue(root)
        assertEquals(expected, actual)
    }
}