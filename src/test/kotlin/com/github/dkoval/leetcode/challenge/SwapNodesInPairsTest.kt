package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SwapNodesInPairsTest {

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

    @ParameterizedTest
    @MethodSource("input")
    fun `should swap every two adjacent nodes and return the head of modified list`(
        head: ListNode?,
        expected: List<Int>
    ) {
        val actual = SwapNodesInPairs().swapPairs(head)
        assertEquals(expected, actual.toList())
    }
}