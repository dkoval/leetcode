package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PathSum2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(11).apply {
                            left = TreeNode(7)
                            right = TreeNode(2)
                        }
                    }
                    right = TreeNode(8).apply {
                        left = TreeNode(13)
                        right = TreeNode(4).apply {
                            left = TreeNode(5)
                            right = TreeNode(1)
                        }
                    }
                },
                22,
                listOf(
                    listOf(5, 4, 11, 2),
                    listOf(5, 8, 4, 5)
                )
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                5,
                listOf<Int>()
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                0,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all root-to-leaf paths where each path's sum equals targetSum`(
        root: TreeNode?,
        targetSum: Int,
        expected: List<List<Int>>
    ) {
        val actual = PathSum2().pathSum(root, targetSum)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}