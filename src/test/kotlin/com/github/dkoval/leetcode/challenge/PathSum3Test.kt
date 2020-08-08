package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PathSum3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // Return 3. The paths that sum to 8 are:
            // 5 -> 3
            // 5 -> 2 -> 1
            // -3 -> 11
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(3)
                            right = TreeNode(-2)
                        }
                        right = TreeNode(2).apply {
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(-3).apply {
                        right = TreeNode(11)
                    }
                },
                8,
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the number of paths that sum to a given value`(root: TreeNode?, sum: Int, expected: Int) {
        val actual = PathSum3.pathSum(root, sum)
        assertEquals(expected, actual)
    }
}