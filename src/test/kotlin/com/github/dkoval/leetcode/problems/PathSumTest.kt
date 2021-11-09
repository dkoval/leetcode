package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PathSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(11).apply {
                            left = TreeNode(7)
                            right = TreeNode(2)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(13)
                        right = TreeNode(4).apply {
                            right = TreeNode(1)
                        }
                    }
                },
                22,
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                5,
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                0,
                false
            ),
            Arguments.of(
                TreeNode(-2).apply {
                    right = TreeNode(-3)
                },
                -5,
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum`(
        root: TreeNode?,
        targetSum: Int,
        expected: Boolean
    ) {
        val actual = PathSum().hasPathSum(root, targetSum)
        assertEquals(expected, actual)
    }
}