package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.SwapNodesInPairs.SwapNodesInPairsHandlingEdgeCases
import com.github.dkoval.leetcode.challenge.SwapNodesInPairs.SwapNodesInPairsUsingDummyNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SwapNodesInPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                null,
                listOf<Int>()
            ),
            Arguments.of(
                ListNode(1),
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(2, 1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                listOf(2, 1, 3)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
                listOf(2, 1, 4, 3)
            )
        )
    }

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                null,
                listOf<Int>()
            ),
            Arguments.of(
                ListNode(1),
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(2, 1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                listOf(2, 1, 3)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
                listOf(2, 1, 4, 3)
            )
        )
    }

    @Nested
    inner class SwapNodesInPairsUsingDummyNodeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should swap every two adjacent nodes and return the head of modified list`(
            head: ListNode?,
            expected: List<Int>
        ) {
            SwapNodesInPairsUsingDummyNode().test(head, expected)
        }
    }

    @Nested
    inner class SwapNodesInPairsHandlingEdgeCasesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should swap every two adjacent nodes and return the head of modified list`(
            head: ListNode?,
            expected: List<Int>
        ) {
            SwapNodesInPairsHandlingEdgeCases().test(head, expected)
        }
    }

    private fun SwapNodesInPairs.test(head: ListNode?, expected: List<Int>) {
        val actual = swapPairs(head)
        assertEquals(expected, actual.dump())
    }
}