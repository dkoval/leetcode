package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConstructBSTFromPreorderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.arguments(
                intArrayOf(8, 5, 1, 7, 10, 12),
                TreeNode(8).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(1)
                        right = TreeNode(7)
                    }
                    right = TreeNode(10).apply {
                        right = TreeNode(12)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the root node of a BST that matches the given preorder traversal`(
        preorder: IntArray,
        expected: TreeNode?
    ) {
        val actual = ConstructBSTFromPreorderTraversal.bstFromPreorder(preorder)
        assertTrue(expected.equalsTo(actual))
    }
}