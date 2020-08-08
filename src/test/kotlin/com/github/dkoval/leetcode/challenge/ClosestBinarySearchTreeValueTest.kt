package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ClosestBinarySearchTreeValueTest {

    companion object {
        private val testTree = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(5)
        }

        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                testTree,
                3.714286,
                4
            ),
            Arguments.of(
                testTree,
                3.414286,
                3
            ),
            Arguments.of(
                testTree,
                2.614286,
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the value in the BST that is closest to the target`(
        root: TreeNode,
        target: Double,
        expected: Int
    ) {
        val actual = ClosestBinarySearchTreeValue.closestValue(root, target)
        assertEquals(expected, actual)
    }
}