package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SameTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(1)
                },
                TreeNode(1).apply {
                    left = TreeNode(1)
                    right = TreeNode(2)
                },
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if two binary trees are the same`(p: TreeNode?, q: TreeNode?, expected: Boolean) {
        val actual = SameTree.isSameTree(p, q)
        assertEquals(expected, actual)
    }
}