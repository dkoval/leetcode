package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveDuplicatesFromSortedList2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(3).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(4).apply {
                                        next = ListNode(5)
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(1, 2, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(1).apply {
                            next = ListNode(2).apply {
                                next = ListNode(3)
                            }
                        }
                    }
                },
                listOf(2, 3)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1)
                },
                listOf<Integer>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list`(
        head: ListNode?,
        expected: List<Int>
    ) {
        val actual = RemoveDuplicatesFromSortedList2().deleteDuplicates(head)
        assertEquals(expected, actual.toList())
    }
}