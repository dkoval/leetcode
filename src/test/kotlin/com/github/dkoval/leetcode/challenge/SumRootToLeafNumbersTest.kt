package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumRootToLeafNumbersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                // The root-to-leaf path 1->2 represents the number 12.
                // The root-to-leaf path 1->3 represents the number 13.
                // Therefore, sum = 12 + 13 = 25.
                25
            ),
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(9).apply {
                        left = TreeNode(5)
                        right = TreeNode(1)
                    }
                    right = TreeNode(0)
                },
                // The root-to-leaf path 4->9->5 represents the number 495.
                // The root-to-leaf path 4->9->1 represents the number 491.
                // The root-to-leaf path 4->0 represents the number 40.
                // Therefore, sum = 495 + 491 + 40 = 1026.
                1026
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the total sum of all root-to-leaf numbers`(root: TreeNode?, expected: Int) {
        val actual = SumRootToLeafNumbers.sumNumbers(root)
        assertEquals(expected, actual)
    }
}