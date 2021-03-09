package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddOneRowToTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                    right = TreeNode(6).apply {
                        left = TreeNode(5)
                    }
                },
                1,
                2,
                TreeNode(4).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(3)
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(6).apply {
                            left = TreeNode(5)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                },
                1,
                3,
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1).apply {
                            left = TreeNode(3)
                        }
                        right = TreeNode(1).apply {
                            right = TreeNode(1)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                1,
                1,
                TreeNode(1).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(2)
                        right = TreeNode(3)
                    }
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                1,
                3,
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(1)
                        right = TreeNode(1)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should add a row of nodes with value v at the given depth d`(
        root: TreeNode,
        v: Int,
        d: Int,
        expected: TreeNode
    ) {
        val actual = AddOneRowToTree().addOneRow(root, v, d)
        assertTrue(actual.equalsTo(expected))
    }
}