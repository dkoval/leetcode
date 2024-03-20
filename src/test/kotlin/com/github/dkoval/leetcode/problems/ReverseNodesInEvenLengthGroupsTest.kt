package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseNodesInEvenLengthGroupsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(5).apply {
                    next = ListNode(2).apply {
                        next = ListNode(6).apply {
                            next = ListNode(3).apply {
                                next = ListNode(9).apply {
                                    next = ListNode(1).apply {
                                        next = ListNode(7).apply {
                                            next = ListNode(3).apply {
                                                next = ListNode(8).apply {
                                                    next = ListNode(4)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(5, 6, 2, 3, 9, 1, 4, 8, 3, 7)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(0).apply {
                            next = ListNode(6)
                        }
                    }
                },
                listOf(1, 0, 1, 6)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(0).apply {
                            next = ListNode(6).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                listOf(1, 0, 1, 5, 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should Reverse the nodes in each group with an even length`(head: ListNode, expected: List<Int>) {
        val actual = ReverseNodesInEvenLengthGroups().reverseEvenLengthGroups(head)
        assertEquals(expected, actual.dump())
    }
}