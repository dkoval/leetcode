package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreePruningTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                TreeNode(1).apply {
                    right = TreeNode(0).apply {
                        right = TreeNode(1)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                TreeNode(1).apply {
                    right = TreeNode(1).apply {
                        right = TreeNode(1)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1).apply {
                            left = TreeNode(0)
                        }
                        right = TreeNode(1)
                    }
                    right = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                TreeNode(1).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                    right = TreeNode(0).apply {
                        right = TreeNode(1)
                    }
                }
            ),
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(0)
                    right = TreeNode(0)
                },
                null
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the same tree where every subtree not containing a 1 has been removed`(
        root: TreeNode,
        expected: TreeNode?
    ) {
        val actual = BinaryTreePruning().pruneTree(root)
        assertTrue(expected.equalsTo(actual))
    }
}