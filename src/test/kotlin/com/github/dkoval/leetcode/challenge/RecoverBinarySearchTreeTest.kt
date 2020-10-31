package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RecoverBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        right = TreeNode(2)
                    }
                },
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        right = TreeNode(2)
                    }
                }
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1)
                    right = TreeNode(4).apply {
                        left = TreeNode(2)
                    }
                },
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(4).apply {
                        left = TreeNode(3)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should recover the tree without changing its structure`(root: TreeNode, expected: TreeNode) {
        RecoverBinarySearchTree().recoverTree(root)
        assertTrue(expected.equalsTo(root))
    }
}