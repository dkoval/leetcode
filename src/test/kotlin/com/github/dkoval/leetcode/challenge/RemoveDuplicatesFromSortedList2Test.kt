package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.RemoveDuplicatesFromSortedList2.RemoveDuplicatesFromSortedList2Rev1
import com.github.dkoval.leetcode.challenge.RemoveDuplicatesFromSortedList2.RemoveDuplicatesFromSortedList2Rev2
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveDuplicatesFromSortedList2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(3).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(4).apply {
                                        next = ListNode(5)
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(1, 2, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(1).apply {
                            next = ListNode(2).apply {
                                next = ListNode(3)
                            }
                        }
                    }
                },
                listOf(2, 3)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1)
                },
                listOf<Int>()
            )
        )
    }

    @Nested
    inner class RemoveDuplicatesFromSortedList2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list`(
            head: ListNode?,
            expected: List<Int>
        ) {
            RemoveDuplicatesFromSortedList2Rev1().test(head, expected)
        }
    }

    @Nested
    inner class RemoveDuplicatesFromSortedList2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list`(
            head: ListNode?,
            expected: List<Int>
        ) {
            RemoveDuplicatesFromSortedList2Rev2().test(head, expected)
        }
    }

    private fun RemoveDuplicatesFromSortedList2.test(head: ListNode?, expected: List<Int>) {
        val actual = deleteDuplicates(head)
        assertEquals(expected, actual.dump())
    }
}