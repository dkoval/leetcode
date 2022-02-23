package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LowestCommonAncestorOfBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(6).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(0)
                        right = TreeNode(4).apply {
                            left = TreeNode(3)
                            right = TreeNode(5)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(7)
                        right = TreeNode(9)
                    }
                },
                2,
                8,
                6
            ),
            Arguments.of(
                TreeNode(6).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(0)
                        right = TreeNode(4).apply {
                            left = TreeNode(3)
                            right = TreeNode(5)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(7)
                        right = TreeNode(9)
                    }
                },
                2,
                4,
                2
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                },
                2,
                1,
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `find the lowest common ancestor of two given nodes in the BST`(root: TreeNode, p: Int, q: Int, expected: Int) {
        val actual = LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor(root, TreeNode(p), TreeNode(q))
        Assertions.assertEquals(expected, actual.`val`)
    }
}