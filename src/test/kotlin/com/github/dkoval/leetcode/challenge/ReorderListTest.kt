package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import com.github.dkoval.leetcode.problems.ReorderList
import com.github.dkoval.leetcode.problems.ReorderList.ReorderListByCalculatingNumberPairsToConnect
import com.github.dkoval.leetcode.problems.ReorderList.ReorderListUsingFastAndSlowPointers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReorderListTest {

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
                listOf(1, 2)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                listOf(1, 3, 2)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
                listOf(1, 4, 2, 3)
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
                listOf(1, 5, 2, 4, 3)
            )
        )
    }

    @Nested
    inner class ReorderListUsingFastAndSlowPointersTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reorder list`(head: ListNode?, expected: List<Int>) {
            ReorderListUsingFastAndSlowPointers().test(head, expected)
        }
    }

    @Nested
    inner class ReorderListByCalculatingNumberPairsToConnectTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reorder list`(head: ListNode?, expected: List<Int>) {
            ReorderListByCalculatingNumberPairsToConnect().test(head, expected)
        }
    }

    private fun ReorderList.test(head: ListNode?, expected: List<Int>) {
        reorderList(head)
        assertEquals(expected, head.dump())
    }
}