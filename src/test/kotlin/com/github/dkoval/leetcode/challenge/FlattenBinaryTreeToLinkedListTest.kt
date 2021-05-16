package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FlattenBinaryTreeToLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(4)
                    }
                    right = TreeNode(5).apply {
                        right = TreeNode(6)
                    }
                },
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(3).apply {
                            right = TreeNode(4).apply {
                                right = TreeNode(5).apply {
                                    right = TreeNode(6)
                                }
                            }
                        }
                    }
                }
            ),
            Arguments.of(
                null,
                null
            ),
            Arguments.of(
                TreeNode(0),
                TreeNode(0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should flatten a binary tree into a linked list`(root: TreeNode?, expected: TreeNode?) {
        FlattenBinaryTreeToLinkedList().flatten(root)
        assertThat(root).`is`(Condition({ actual -> expected.equalsTo(actual) }, "treeNode"))
    }
}