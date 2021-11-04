package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveLinkedListElementsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(6).apply {
                            next = ListNode(3).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(5).apply {
                                        next = ListNode(6)
                                    }
                                }
                            }
                        }
                    }
                },
                6,
                listOf(1, 2, 3, 4, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(1)
                },
                1,
                emptyList<Int>()
            ),
            Arguments.of(
                null,
                1,
                emptyList<Int>()
            ),
            Arguments.of(
                ListNode(7).apply {
                    next = ListNode(7).apply {
                        next = ListNode(7).apply {
                            next = ListNode(7)
                        }
                    }
                },
                7,
                emptyList<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove all elements from a linked list of integers that have value val`(
        head: ListNode?,
        `val`: Int,
        expected: List<Int>
    ) {
        val actual = RemoveLinkedListElements.removeElements(head, `val`)
        assertEquals(expected, actual.toList())
    }
}