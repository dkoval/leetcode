package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeTwoSortedListsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(4)
                    }
                },
                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4)
                    }
                },
                listOf(1, 1, 2, 3, 4, 4)
            )
        )
    }

    @Nested
    inner class MergeTwoSortedListsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should merge two sorted linked lists and return it as a new sorted list`(
            l1: ListNode?,
            l2: ListNode?,
            expected: List<Int>
        ) {
            MergeTwoSortedListsIter.test(l1, l2, expected)
        }
    }

    @Nested
    inner class MergeTwoSortedListsRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should merge two sorted linked lists and return it as a new sorted list`(
            l1: ListNode?,
            l2: ListNode?,
            expected: List<Int>
        ) {
            MergeTwoSortedListsRecursive.test(l1, l2, expected)
        }
    }

    private fun MergeTwoSortedLists.test(l1: ListNode?, l2: ListNode?, expected: List<Int>) {
        val actual = mergeTwoLists(l1, l2)
        assertEquals(expected, actual.toList())
    }
}