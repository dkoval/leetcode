package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.ConvertBinaryNumberInLinkedListToInteger.ConvertBinaryNumberInLinkedListToIntegerRev1
import com.github.dkoval.leetcode.challenge.ConvertBinaryNumberInLinkedListToInteger.ConvertBinaryNumberInLinkedListToIntegerRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConvertBinaryNumberInLinkedListToIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(0).apply {
                        next = ListNode(1)
                    }
                },
                5
            ),
            Arguments.of(
                ListNode(0),
                0
            ),
            Arguments.of(
                ListNode(1),
                1
            ),
            Arguments.of(
                ListNode(0).apply {
                    next = ListNode(0)
                },
                0
            )
        )
    }

    @Nested
    inner class ConvertBinaryNumberInLinkedListToIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decimal value of the number in the linked list`(head: ListNode, expected: Int) {
            ConvertBinaryNumberInLinkedListToIntegerRev1().test(head, expected)
        }
    }

    @Nested
    inner class ConvertBinaryNumberInLinkedListToIntegerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decimal value of the number in the linked list`(head: ListNode, expected: Int) {
            ConvertBinaryNumberInLinkedListToIntegerRev2().test(head, expected)
        }
    }
}

private fun ConvertBinaryNumberInLinkedListToInteger.test(head: ListNode, expected: Int) {
    val actual = getDecimalValue(head)
    assertEquals(expected, actual)
}
