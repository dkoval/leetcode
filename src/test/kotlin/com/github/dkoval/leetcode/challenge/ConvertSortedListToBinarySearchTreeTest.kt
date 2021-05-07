package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConvertSortedListToBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(-10).apply {
                    next = ListNode(-3).apply {
                        next = ListNode(0).apply {
                            next = ListNode(5).apply {
                                next = ListNode(9)
                            }
                        }
                    }
                },
                TreeNode(0).apply {
                    left = TreeNode(-3).apply {
                        left = TreeNode(-10)
                    }
                    right = TreeNode(9).apply {
                        left = TreeNode(5)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should convert an array of integers sorted in asc order to to a height balanced BST`(
        head: ListNode?,
        expected: TreeNode?
    ) {
        val actual = ConvertSortedListToBinarySearchTree().sortedListToBST(head)
        assertTrue(actual.equalsTo(expected))
    }
}