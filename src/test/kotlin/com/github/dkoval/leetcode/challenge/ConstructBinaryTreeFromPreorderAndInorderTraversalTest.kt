package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 9, 20, 15, 7),
                intArrayOf(9, 3, 15, 20, 7),
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                }
            ),
            Arguments.of(
                intArrayOf(-1),
                intArrayOf(-1),
                TreeNode(-1)
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7),
                intArrayOf(8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7),
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(8)
                            right = TreeNode(9).apply {
                                left = TreeNode(10)
                                right = TreeNode(11)
                            }
                        }
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                }
            ),
            Arguments.of(
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                TreeNode(1).apply {
                    left = TreeNode(2)
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should construct binary tree from preorder and inorder traversal`(
        preorder: IntArray,
        inorder: IntArray,
        expected: TreeNode
    ) {
        val actual = ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder)
        assertTrue(expected.equalsTo(actual))
    }
}