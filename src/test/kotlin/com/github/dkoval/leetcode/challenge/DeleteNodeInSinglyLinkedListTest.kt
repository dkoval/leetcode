package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.find
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DeleteNodeInSinglyLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(9)
                        }
                    }
                },
                5,
                listOf(4, 1, 9)
            ),
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(9)
                        }
                    }
                },
                1,
                listOf(4, 5, 9)
            ),
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(9)
                        }
                    }
                },
                4,
                listOf(5, 1, 9)
            ),
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(9)
                        }
                    }
                },
                9,
                listOf(4, 5, 1, 9) // can't delete the last node in the list
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should delete a node from a singly-linked list`(head: ListNode?, nodeValue: Int, expected: List<Int>) {
        DeleteNodeInSinglyLinkedList.deleteNode(head.find(nodeValue))
        assertEquals(expected, head.toList())
    }
}