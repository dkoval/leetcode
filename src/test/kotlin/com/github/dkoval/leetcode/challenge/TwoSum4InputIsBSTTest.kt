package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TwoSum4InputIsBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2)
                        right = TreeNode(4)
                    }
                    right = TreeNode(6).apply {
                        right = TreeNode(7)
                    }
                },
                9,
                true
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2)
                        right = TreeNode(4)
                    }
                    right = TreeNode(6).apply {
                        right = TreeNode(7)
                    }
                },
                28,
                false
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                4,
                true
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                1,
                false
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                3,
                true
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(-4)
                        right = TreeNode(1)
                    }
                    right = TreeNode(3)
                },
                -1,
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should true if there exist two elements in the BST such that their sum is equal to k`(
        root: TreeNode,
        k: Int,
        expected: Boolean
    ) {
        val actual = TwoSum4InputIsBST().findTarget(root, k)
        assertEquals(expected, actual)
    }
}