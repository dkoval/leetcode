package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.ConvertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTreeRev1
import com.github.dkoval.leetcode.challenge.ConvertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTreeRev2
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConvertSortedListToBinarySearchTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class ConvertSortedListToBinarySearchTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert an array of integers sorted in asc order to to a height balanced BST`(
            head: ListNode?,
            expected: TreeNode?
        ) {
            ConvertSortedListToBinarySearchTreeRev1().test(head, expected)
        }
    }

    @Nested
    inner class ConvertSortedListToBinarySearchTreeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert an array of integers sorted in asc order to to a height balanced BST`(
            head: ListNode?,
            expected: TreeNode?
        ) {
            ConvertSortedListToBinarySearchTreeRev2().test(head, expected)
        }
    }
}

private fun ConvertSortedListToBinarySearchTree.test(head: ListNode?, expected: TreeNode?) {
    val actual = sortedListToBST(head)
    assertTrue(actual.equalsTo(expected))
}
