package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PalindromeLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                null,
                true
            ),
            Arguments.of(
                ListNode(1),
                true
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                false
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(2).apply {
                            next = ListNode(1)
                        }
                    }
                },
                true
            )
        )
    }

    @Nested
    inner class PalindromeLinkedListUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if a singly linked list is a palindrome`(head: ListNode?, expected: Boolean) {
            PalindromeLinkedListUsingExtraSpace.test(head, expected)
        }
    }

    @Nested
    inner class PalindromeLinkedListBreakAndReverseSecondHalfTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if a singly linked list is a palindrome`(head: ListNode?, expected: Boolean) {
            PalindromeLinkedListBreakAndReverseSecondHalf.test(head, expected)
        }
    }

    private fun PalindromeLinkedList.test(head: ListNode?, expected: Boolean) {
        val actual = isPalindrome(head)
        assertEquals(expected, actual)
    }
}