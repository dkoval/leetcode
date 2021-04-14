package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PartitionListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(4).apply {
                        next = ListNode(3).apply {
                            next = ListNode(2).apply {
                                next = ListNode(5).apply {
                                    next = ListNode(2)
                                }
                            }
                        }
                    }
                },
                3,
                listOf(1, 2, 2, 4, 3, 5)
            ),
            Arguments.of(
                ListNode(2).apply {
                    next = ListNode(1)
                },
                2,
                listOf(1, 2)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                4,
                listOf(1, 2, 3)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                1,
                listOf(1, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should partition list`(head: ListNode, x: Int, expected: List<Int>) {
        val actual = PartitionList().partition(head, x)
        assertEquals(actual.toList(), expected)
    }
}