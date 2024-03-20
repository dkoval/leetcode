package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveDuplicatesFromSortedListTest {

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
                    next = ListNode(1)
                },
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(1).apply {
                            next = ListNode(2).apply {
                                next = ListNode(2).apply {
                                    next = ListNode(3)
                                }
                            }
                        }
                    }
                },
                listOf(1, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should delete all duplicates such that each element appears only once`(head: ListNode?, expected: List<Int>) {
        val actual = RemoveDuplicatesFromSortedList().deleteDuplicates(head)
        assertEquals(expected, actual.dump())
    }
}