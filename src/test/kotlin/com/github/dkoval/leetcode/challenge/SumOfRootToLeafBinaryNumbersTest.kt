package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfRootToLeafBinaryNumbersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                22 // (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
            ),
            Arguments.of(
                TreeNode(0),
                0
            ),
            Arguments.of(
                TreeNode(1),
                1
            ),
            Arguments.of(
                null,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return sum of root to leaf binary numbers`(root: TreeNode?, expected: Int) {
        val actual = SumOfRootToLeafBinaryNumbers.sumRootToLeaf(root)
        assertEquals(expected, actual)
    }
}