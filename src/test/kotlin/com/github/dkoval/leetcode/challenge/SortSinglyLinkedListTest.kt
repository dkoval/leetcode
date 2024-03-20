package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SortSinglyLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(2).apply {
                        next = ListNode(1).apply {
                            next = ListNode(3)
                        }
                    }
                },
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                ListNode(-1).apply {
                    next = ListNode(5).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(0)
                            }
                        }
                    }
                },
                listOf(-1, 0, 3, 4, 5)
            ),
            Arguments.of(
                null,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should sort singly linked list in ascending order`(head: ListNode?, expected: List<Int>) {
        val actual = SortSinglyLinkedList().sortList(head)
        assertEquals(expected, actual.dump())
    }
}