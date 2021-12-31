package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumDifferenceBetweenNodeAndAncestorTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(8).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(1)
                        right = TreeNode(6).apply {
                            left = TreeNode(4)
                            right = TreeNode(7)
                        }
                    }
                    right = TreeNode(10).apply {
                        right = TreeNode(14).apply {
                            left = TreeNode(13)
                        }
                    }
                },
                7
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(0).apply {
                            left = TreeNode(3)
                        }
                    }
                },
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should maximum difference between node and ancestor`(root: TreeNode, expected: Int) {
        val actual = MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(root)
        assertEquals(expected, actual)
    }
}