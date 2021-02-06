package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeRightSideViewTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(4)
                    }
                },
                listOf(1, 3, 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the values of the nodes of the binary tree right side view`(
        root: TreeNode?,
        expected: List<Int>
    ) {
        val actual = BinaryTreeRightSideView().rightSideView(root)
        assertEquals(expected, actual)
    }
}