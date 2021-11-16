package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SubtreeOfAnotherTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(1)
                        right = TreeNode(2)
                    }
                    right = TreeNode(5)
                },
                TreeNode(4).apply {
                    left = TreeNode(1)
                    right = TreeNode(2)
                },
                true
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(1)
                        right = TreeNode(2).apply {
                            left = TreeNode(0)
                        }
                    }
                    right = TreeNode(5)
                },
                TreeNode(4).apply {
                    left = TreeNode(1)
                    right = TreeNode(2)
                },
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if there is a subtree of root with the same structure and node values of subRoot`(
        root: TreeNode,
        subRoot: TreeNode,
        expected: Boolean
    ) {
        val actual = SubtreeOfAnotherTree().isSubtree(root, subRoot)
        assertEquals(expected, actual)
    }
}