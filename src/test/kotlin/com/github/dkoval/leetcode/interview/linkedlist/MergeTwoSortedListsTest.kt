package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MergeTwoSortedListsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(4)
                    }
                },
                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4)
                    }
                },
                listOf(1, 1, 2, 3, 4, 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should merge two sorted linked lists and return it as a new sorted list`(
        l1: ListNode?,
        l2: ListNode?,
        expected: List<Int>
    ) {
        val actual = MergeTwoSortedLists.mergeTwoLists(l1, l2)
        assertEquals(expected, actual.toList())
    }
}