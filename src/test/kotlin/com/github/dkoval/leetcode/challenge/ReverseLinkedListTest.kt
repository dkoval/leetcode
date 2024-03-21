package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.ReverseLinkedList.ReverseLinkedListIterative
import com.github.dkoval.leetcode.challenge.ReverseLinkedList.ReverseLinkedListRecursive
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
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
                ListNode.headOf(1, 2, 3, 4, 5),
                ListNode.headOf(5, 4, 3, 2, 1)
            ),
            Arguments.of(
                ListNode.headOf(1, 2),
                ListNode.headOf(2, 1)
            ),
            Arguments.of(
                null,
                null
            )
        )
    }

    @Nested
    inner class ReverseLinkedListIterativeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse a singly linked list`(head: ListNode?, expected: ListNode?) {
            ReverseLinkedListIterative().test(head, expected)
        }
    }

    @Nested
    inner class ReverseLinkedListRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse a singly linked list`(head: ListNode?, expected: ListNode?) {
            ReverseLinkedListRecursive().test(head, expected)
        }
    }
}

private fun ReverseLinkedList.test(head: ListNode?, expected: ListNode?) {
    assertTrue { reverseList(head).equalsTo(expected) }
}
