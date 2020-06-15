package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7)
                },
                2,
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
            ),
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7)
                },
                5,
                null
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `find the node in the BST that the node's value equals the given value`(
        root: TreeNode?,
        `val`: Int,
        expected: TreeNode?
    ) {
        val actual = SearchInBST.searchBST(root, `val`)
        assertTrue(expected.equalsTo(actual))
    }
}