package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfLeftLeavesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(30).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                24
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the sum of all left leaves in a given binary tree`(root: TreeNode?, expected: Int) {
        val actual = SumOfLeftLeaves.sumOfLeftLeaves(root)
        assertEquals(expected, actual)
    }
}