package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountCompleteTreeNodesTest {

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
                    }
                },
                6
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count complete tree nodes`(root: TreeNode?, expected: Int) {
        val actual = CountCompleteTreeNodes.countNodes(root)
        assertEquals(expected, actual)
    }
}