package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReorderListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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

    @ParameterizedTest
    @MethodSource("input")
    fun `should reorder list`(head: ListNode?, expected: List<Int>) {
        ReorderList.reorderList(head)
        assertEquals(expected, head.toList())
    }
}