package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LowestCommonAncestorOfBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2).apply {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(8)
                    }
                },
                5,
                1,
                3
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2).apply {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(8)
                    }
                },
                5,
                4,
                5
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                1,
                2,
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the lowest common ancestor of two given nodes in the tree`(
        root: TreeNode,
        p: Int,
        q: Int,
        expected: Int
    ) {
        val actual = LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, TreeNode(p), TreeNode(q))
        assertEquals(expected, actual.`val`)
    }
}