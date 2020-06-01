package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class InvertBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7).apply {
                        left = TreeNode(6)
                        right = TreeNode(9)
                    }
                },
                TreeNode(4).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(9)
                        right = TreeNode(6)
                    }
                    right = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should invert a binary tree`(root: TreeNode?, expected: TreeNode?) {
        val actual = InvertBinaryTree.invertTree(root)
        assertTrue(actual.equalsTo(expected))
    }
}