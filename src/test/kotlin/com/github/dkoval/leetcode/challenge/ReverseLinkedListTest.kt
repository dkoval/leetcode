package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.ReverseLinkedList.ReverseLinkedListIterative
import com.github.dkoval.leetcode.challenge.ReverseLinkedList.ReverseLinkedListRecursive
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReverseLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                listOf(5, 4, 3, 2, 1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(2, 1)
            ),
            Arguments.of(
                null,
                listOf<Int>()
            )
        )
    }

    @Nested
    inner class ReverseLinkedListIterativeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse a singly linked list`(head: ListNode?, expected: List<Int>) {
            ReverseLinkedListIterative().test(head, expected)
        }
    }

    @Nested
    inner class ReverseLinkedListRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse a singly linked list`(head: ListNode?, expected: List<Int>) {
            ReverseLinkedListRecursive().test(head, expected)
        }
    }

    private fun ReverseLinkedList.test(head: ListNode?, expected: List<Int>) {
        val actual = reverseList(head)
        assertEquals(expected, actual.dump())
    }
}