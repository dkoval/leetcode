package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.TreeNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DeleteNodesAndReturnForestTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                },
                intArrayOf(3, 5),
                listOf(
                    TreeNode(1).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(4)
                        }
                    },
                    TreeNode(6),
                    TreeNode(7)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the roots of the trees in the remaining forest`(
        root: TreeNode,
        nodesToDelete: IntArray,
        expected: List<TreeNode>
    ) {
        val actual = DeleteNodesAndReturnForest().delNodes(root, nodesToDelete)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}