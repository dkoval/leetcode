package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class InsertionSortListTest {

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
                }
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
                }
            ),
            Arguments.of(
                ListNode(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(5).apply {
                                next = ListNode(4)
                            }
                        }
                    }
                }
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(5).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(6)
                                }
                            }
                        }
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should sort a singly linked list using insertion sort and return the sorted list's head`(head: ListNode) {
        val expected = head.toList().sorted()
        val actual = InsertionSortList().insertionSortList(head)
        assertEquals(expected, actual.toList())
    }
}