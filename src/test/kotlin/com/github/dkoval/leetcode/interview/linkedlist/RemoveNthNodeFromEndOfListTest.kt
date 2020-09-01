package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveNthNodeFromEndOfListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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
                2,
                listOf(1, 2, 3, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                1,
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                2,
                listOf<Int>(2)
            ),
            Arguments.of(
                ListNode(1),
                1,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove the n-th node from the end of list and return its head`(
        head: ListNode?,
        n: Int,
        expected: List<Int>
    ) {
        val actual = RemoveNthNodeFromEndOfList.removeNthFromEnd(head, n)
        assertEquals(expected, actual.toList())
    }
}