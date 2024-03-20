package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.AddTwoNumbers2.AddTwoNumbers2Rev1
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AddTwoNumbers2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(7).apply {
                    next = ListNode(2).apply {
                        next = ListNode(4).apply {
                            next = ListNode(3)
                        }
                    }
                },
                ListNode(5).apply {
                    next = ListNode(6).apply {
                        next = ListNode(4)
                    }
                },
                listOf(7, 8, 0, 7)
            ),
            Arguments.of(
                ListNode(2).apply {
                    next = ListNode(4).apply {
                        next = ListNode(3)
                    }
                },
                ListNode(5).apply {
                    next = ListNode(6).apply {
                        next = ListNode(4)
                    }
                },
                listOf(8, 0, 7),
            ),
            Arguments.of(
                ListNode(0),
                ListNode(0),
                listOf(0)
            ),
            Arguments.of(
                ListNode(5),
                ListNode(5),
                listOf(1, 0)
            )
        )
    }

    @Nested
    inner class AddTwoNumbers2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should add two numbers`(l1: ListNode, l2: ListNode, expected: List<Int>) {
            AddTwoNumbers2Rev1().test(l1, l2, expected)
        }
    }
}

private fun AddTwoNumbers2.test(l1: ListNode, l2: ListNode, expected: List<Int>) {
    val actual = addTwoNumbers(l1, l2)
    assertEquals(expected, actual.dump())
}
