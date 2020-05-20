package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KthSmallestElementInBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(1).apply {
                        right = TreeNode(2)
                    }
                    right = TreeNode(4)
                },
                1,
                1
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(4)
                    }
                    right = TreeNode(6)
                },
                3,
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return k-th smallest element in a BST`(root: TreeNode?, k: Int, expected: Int) {
        val actual = KthSmallestElementInBST.kthSmallest(root, k)
        assertEquals(expected, actual)
    }
}