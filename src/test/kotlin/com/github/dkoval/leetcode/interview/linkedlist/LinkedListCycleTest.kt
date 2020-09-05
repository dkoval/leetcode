package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LinkedListCycleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(3).apply {
                    val cycleStart = ListNode(2)
                    next = cycleStart.apply {
                        next = ListNode(0).apply {
                            next = ListNode(-4).apply {
                                next = cycleStart
                            }
                        }
                    }
                },
                true
            ),
            Arguments.of(
                ListNode(1).apply {
                    val cycleStart = this
                    next = ListNode(2).apply {
                        next = cycleStart
                    }
                },
                true
            ),
            Arguments.of(
                ListNode(1),
                false
            ),
            Arguments.of(
                null,
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine if there is a cycle in a singly linked list`(head: ListNode?, expected: Boolean) {
        val actual = LinkedListCycle.hasCycle(head)
        assertEquals(expected, actual)
    }
}