package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FlipBinaryTreeToMatchPreorderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                intArrayOf(2, 1),
                listOf(-1)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                intArrayOf(1, 3, 2),
                listOf(1)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                intArrayOf(1, 2, 3),
                listOf<Int>()
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                intArrayOf(1, 2),
                listOf<Int>()
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                    }
                },
                intArrayOf(1, 3, 2),
                listOf(-1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a list of the values of all flipped nodes`(
        root: TreeNode,
        voyage: IntArray,
        expected: List<Int>
    ) {
        val actual = FlipBinaryTreeToMatchPreorderTraversal().flipMatchVoyage(root, voyage)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}