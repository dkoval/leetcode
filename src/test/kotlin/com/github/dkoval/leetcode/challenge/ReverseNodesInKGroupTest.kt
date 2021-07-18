package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseNodesInKGroupTest {

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
                listOf(2, 1, 4, 3, 5)
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
                3,
                listOf(3, 2, 1, 4, 5)
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
                1,
                listOf(1, 2, 3, 4, 5)
            ),
            Arguments.of(
                ListNode(1),
                1,
                listOf(1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse the nodes of a linked list k at a time and return its modified list`(
        head: ListNode,
        k: Int,
        expected: List<Int>
    ) {
        val actual = ReverseNodesInKGroup().reverseKGroup(head, k)
        assertEquals(expected, actual.toList())
    }
}