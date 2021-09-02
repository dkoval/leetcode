package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueBinarySearchTrees2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                1,
                listOf(
                    TreeNode(1)
                )
            ),
            Arguments.of(
                3,
                listOf(
                    TreeNode(1).apply {
                        right = TreeNode(3).apply {
                            left = TreeNode(2)
                        }
                    },
                    TreeNode(1).apply {
                        right = TreeNode(2).apply {
                            right = TreeNode(3)
                        }
                    },
                    TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    },
                    TreeNode(3).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                    },
                    TreeNode(3).apply {
                        left = TreeNode(1).apply {
                            right = TreeNode(2)
                        }
                    }
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all the structurally unique BSTs`(n: Int, expected: List<TreeNode>) {
        val actual = UniqueBinarySearchTrees2().generateTrees(n)
        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}