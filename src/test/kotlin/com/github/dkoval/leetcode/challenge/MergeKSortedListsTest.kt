package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MergeKSortedListsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    ListNode(1).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    },
                    ListNode(1).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    },
                    ListNode(2).apply {
                        next = ListNode(6)
                    }
                ),
                listOf(1, 1, 2, 3, 4, 4, 5, 6)
            ),
            Arguments.of(
                emptyArray<ListNode>(),
                emptyList<Int>()
            ),
            Arguments.of(
                arrayOfNulls<ListNode>(size = 1),
                emptyList<Int>()
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should merge all the linked-lists into one sorted linked-list and return it`(
        lists: Array<ListNode?>,
        expected: List<Int>
    ) {
        val actual = MergeKSortedLists().mergeKLists(lists)
        assertEquals(expected, actual.dump())
    }
}