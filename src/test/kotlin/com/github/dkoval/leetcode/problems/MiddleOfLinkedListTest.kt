package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.problems.MiddleOfLinkedList.MiddleOfLinkedListRev1
import com.github.dkoval.leetcode.problems.MiddleOfLinkedList.MiddleOfLinkedListRev2
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MiddleOfLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1),
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(2)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                listOf(2, 3)
            ),
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
                listOf(3, 4, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5).apply {
                                    next = ListNode(6)
                                }
                            }
                        }
                    }
                },
                listOf(4, 5, 6)
            )
        )
    }

    @Nested
    inner class MiddleOfLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the middle node of the linked list`(head: ListNode, expected: List<Int>) {
            MiddleOfLinkedListRev1().test(head, expected)
        }
    }

    @Nested
    inner class MiddleOfLinkedListRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the middle node of the linked list`(head: ListNode, expected: List<Int>) {
            MiddleOfLinkedListRev2().test(head, expected)
        }
    }
}

private fun MiddleOfLinkedList.test(head: ListNode, expected: List<Int>) {
    val actual = middleNode(head)
    assertEquals(expected, actual.toList())
}
