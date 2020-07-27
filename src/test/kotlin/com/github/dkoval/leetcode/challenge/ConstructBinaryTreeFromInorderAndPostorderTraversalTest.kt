package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(9, 3, 15, 20, 7),
                intArrayOf(9, 15, 7, 20, 3),
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should construct binary tree from inorder and postorder traversal`(
        inorder: IntArray,
        postorder: IntArray,
        expected: TreeNode?
    ) {
        val actual = ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(inorder, postorder)
        assertTrue(expected.equalsTo(actual))
    }
}