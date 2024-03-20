package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OddEvenLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                // 1->2->3->4->5->NULL
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                listOf(1, 3, 5, 2, 4)
            ),
            Arguments.of(
                // 2->1->3->5->6->4->7->NULL
                ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(3).apply {
                            next = ListNode(5).apply {
                                next = ListNode(6).apply {
                                    next = ListNode(4).apply {
                                        next = ListNode(7)
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(2, 3, 6, 7, 1, 5, 4)
            ),
            Arguments.of(
                null,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should group all odd nodes together followed by the even nodes`(head: ListNode?, expected: List<Int>) {
        val actual = OddEvenLinkedList.oddEvenList(head)
        assertEquals(actual.dump(), expected)
    }
}