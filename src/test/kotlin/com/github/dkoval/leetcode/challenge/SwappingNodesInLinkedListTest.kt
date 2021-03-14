package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SwappingNodesInLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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
                2,
                listOf(1, 4, 3, 2, 5)
            ),
            Arguments.of(
                ListNode(7).apply {
                    next = ListNode(9).apply {
                        next = ListNode(6).apply {
                            next = ListNode(6).apply {
                                next = ListNode(7).apply {
                                    next = ListNode(8).apply {
                                        next = ListNode(3).apply {
                                            next = ListNode(0).apply {
                                                next = ListNode(9).apply {
                                                    next = ListNode(5)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                5,
                listOf(7, 9, 6, 6, 8, 7, 3, 0, 9, 5)
            ),
            Arguments.of(
                ListNode(1),
                1,
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                1,
                listOf(2, 1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                2,
                listOf(1,2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end`(
        head: ListNode,
        k: Int,
        expected: List<Int>
    ) {
        val actual = SwappingNodesInLinkedList().swapNodes(head, k)
        assertEquals(expected, actual.toList())
    }
}