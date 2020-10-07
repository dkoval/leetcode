package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RotateListTest {

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
                listOf(4, 5, 1, 2, 3)
            ),
            Arguments.of(
                ListNode(0).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2)
                    }
                },
                4,
                listOf(2, 0, 1)
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
                    next = ListNode(2)
                },
                2,
                listOf(1, 2)
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
                10,
                listOf(1, 2, 3, 4, 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should rotate the list to the right by k places`(head: ListNode?, k: Int, expected: List<Int>) {
        val actual = RotateList().rotateRight(head, k)
        assertEquals(expected, actual.toList())
    }
}