package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.PalindromeLinkedList.PalindromeLinkedListFollowUp
import com.github.dkoval.leetcode.challenge.PalindromeLinkedList.PalindromeLinkedListUsingExtraSpace
import com.github.dkoval.leetcode.interview.linkedlist.PalindromeLinkedListBreakAndReverseSecondHalf
import com.github.dkoval.leetcode.interview.linkedlist.PalindromeLinkedListUsingExtraSpaceKt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PalindromeLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(1, 2, 2, 1),
                true
            ),
            Arguments.of(
                ListNode.headOf(1, 2),
                false
            ),
            Arguments.of(
                ListNode.headOf(1, 2, 3, 2, 1),
                true
            )
        )
    }

    @Nested
    inner class PalindromeLinkedListUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a singly linked list is a palindrome`(head: ListNode, expected: Boolean) {
            PalindromeLinkedListUsingExtraSpace().test(head, expected)
        }
    }

    @Nested
    inner class PalindromeLinkedListUsingExtraSpaceKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a singly linked list is a palindrome`(head: ListNode, expected: Boolean) {
            PalindromeLinkedListUsingExtraSpaceKt.test(head, expected)
        }
    }

    @Nested
    inner class PalindromeLinkedListFollowUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a singly linked list is a palindrome`(head: ListNode, expected: Boolean) {
            PalindromeLinkedListFollowUp().test(head, expected)
        }
    }

    @Nested
    inner class PalindromeLinkedListBreakAndReverseSecondHalfTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a singly linked list is a palindrome`(head: ListNode, expected: Boolean) {
            PalindromeLinkedListBreakAndReverseSecondHalf.test(head, expected)
        }
    }
}

private fun PalindromeLinkedList.test(head: ListNode, expected: Boolean) {
    val actual = isPalindrome(head)
    assertEquals(expected, actual)
}
