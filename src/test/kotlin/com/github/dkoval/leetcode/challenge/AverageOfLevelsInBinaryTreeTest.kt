package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AverageOfLevelsInBinaryTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(3.0, 14.5, 11.0)
            ),
            Arguments.of(
                TreeNode(Int.MAX_VALUE).apply {
                    left = TreeNode(Int.MAX_VALUE)
                    right = TreeNode(Int.MAX_VALUE)
                },
                listOf(Int.MAX_VALUE.toDouble(), Int.MAX_VALUE.toDouble())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the average value of the nodes on each level`(root: TreeNode, expected: List<Double>) {
        val actual = AverageOfLevelsInBinaryTree().averageOfLevels(root)
        assertEquals(expected, actual)
    }
}