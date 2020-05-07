package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CousinsInBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(testTree1, 4, 3, false),
            Arguments.of(testTree2, 5, 4, true),
            Arguments.of(testTree3, 2, 3, false)
        )

        private val testTree1: TreeNode =
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                }
                right = TreeNode(3)
            }

        private val testTree2: TreeNode =
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(4)
                }
                right = TreeNode(3).apply {
                    right = TreeNode(5)
                }
            }

        private val testTree3: TreeNode =
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(4)
                }
                right = TreeNode(3)
            }
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if 2 nodes are cousins in a binary tree`(root: TreeNode?, x: Int, y: Int, expected: Boolean) {
        val actual = CousinsInBinaryTree.isCousins(root, x, y)
        assertEquals(expected, actual)
    }
}